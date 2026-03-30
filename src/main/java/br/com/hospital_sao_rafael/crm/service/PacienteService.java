package br.com.hospital_sao_rafael.crm.service;

import br.com.hospital_sao_rafael.crm.domain.Paciente;
import br.com.hospital_sao_rafael.crm.exception.ValidationException;
import br.com.hospital_sao_rafael.crm.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public void criarPaciente(Paciente p) {

        if (p.getNome() == null || p.getNome().isBlank()) {
            throw new ValidationException("Nome é obrigatório");
        }

        p.calcularIMC();

        repository.save(p);
    }

    public List<Paciente> listar() {
        return repository.findAll();
    }
}