package br.com.hospital_sao_rafael.crm.domain;

import java.time.LocalDateTime;

public class Agendamento {

    private Long id;
    private Long pacienteId;
    private Long medicoId;
    private Long procedimentoId;
    private LocalDateTime dataHora;
    private String status; // 🔥 FALTAVA ISSO

    public Agendamento() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPacienteId() { return pacienteId; }
    public void setPacienteId(Long pacienteId) { this.pacienteId = pacienteId; }

    public Long getMedicoId() { return medicoId; }
    public void setMedicoId(Long medicoId) { this.medicoId = medicoId; }

    public Long getProcedimentoId() { return procedimentoId; }
    public void setProcedimentoId(Long procedimentoId) { this.procedimentoId = procedimentoId; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public String getStatus() { return status; } // 🔥
    public void setStatus(String status) { this.status = status; } // 🔥
}