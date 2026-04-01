package br.com.hospital_sao_rafael.crm.repository;

import br.com.hospital_sao_rafael.crm.domain.Agendamento;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class AgendamentoRepository {

    private final JdbcTemplate jdbcTemplate;

    public AgendamentoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Agendamento> rowMapper = (rs, rowNum) -> {
        Agendamento a = new Agendamento();
        a.setId(rs.getLong("id"));
        a.setPacienteId(rs.getLong("paciente_id"));
        a.setMedicoId(rs.getLong("medico_id"));
        a.setProcedimentoId(rs.getLong("procedimento_id"));
        a.setDataHora(rs.getTimestamp("data_hora").toLocalDateTime());
        return a;
    };

    public void save(Agendamento a) {
        String sql = "INSERT INTO agendamentos (paciente_id, medico_id, procedimento_id, data_hora) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                a.getPacienteId(),
                a.getMedicoId(),
                a.getProcedimentoId(),
                Timestamp.valueOf(a.getDataHora())
        );
    }

    public List<Agendamento> findAll() {
        return jdbcTemplate.query("SELECT * FROM agendamentos", rowMapper);
    }

    public boolean existsByMedicoAndHorario(Long medicoId, Timestamp dataHora) {
        String sql = "SELECT COUNT(*) FROM agendamentos WHERE medico_id = ? AND data_hora = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, medicoId, dataHora);
        return count != null && count > 0;
    }
}