package br.com.hospital_sao_rafael.crm.controller;

import br.com.hospital_sao_rafael.crm.domain.Paciente;
import br.com.hospital_sao_rafael.crm.service.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @PostMapping
    public void criar(@RequestBody Paciente paciente) {
        service.criarPaciente(paciente);
    }

    @GetMapping
    public List<Paciente> listar() {
        return service.listar();
    }
}