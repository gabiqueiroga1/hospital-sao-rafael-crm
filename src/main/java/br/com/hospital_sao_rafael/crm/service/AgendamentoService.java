package br.com.hospital_sao_rafael.crm.service;

import br.com.hospital_sao_rafael.crm.domain.Agendamento;
import br.com.hospital_sao_rafael.crm.exception.ValidationException;
import br.com.hospital_sao_rafael.crm.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;

    public AgendamentoService(AgendamentoRepository repository) {
        this.repository = repository;
    }

    public void criarAgendamento(Agendamento a) {
        if (a.getDataHora().isBefore(LocalDateTime.now())) {
            throw new ValidationException("Não é permitido agendar no passado");
        }

        if (repository.existsByMedicoAndHorario(
                a.getMedicoId(),
                Timestamp.valueOf(a.getDataHora())
        )) {
            throw new ValidationException("Médico já possui agendamento nesse horário");
        }

        if (a.getPacienteId() == null) {
            throw new ValidationException("Paciente é obrigatório");
        }

        if (a.getMedicoId() == null) {
            throw new ValidationException("Médico é obrigatório");
        }

        repository.save(a);
    }

    public List<Agendamento> listar() {
        return repository.findAll();
    }
}
