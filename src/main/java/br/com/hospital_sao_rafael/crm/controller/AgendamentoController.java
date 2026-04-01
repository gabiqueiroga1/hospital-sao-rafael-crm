package br.com.hospital_sao_rafael.crm.controller;

import br.com.hospital_sao_rafael.crm.domain.Agendamento;
import br.com.hospital_sao_rafael.crm.service.AgendamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    @PostMapping
    public void criar(@RequestBody Agendamento agendamento) {
        service.criarAgendamento(agendamento);
    }

    @GetMapping
    public List<Agendamento> listar() {
        return service.listar();
    }
}
