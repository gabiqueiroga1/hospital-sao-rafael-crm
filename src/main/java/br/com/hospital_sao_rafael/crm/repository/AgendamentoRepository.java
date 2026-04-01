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
        a.setId(rs.getLong("ID_AGENDAMENTO"));
        a.setPacienteId(rs.getLong("ID_PACIENTE"));
        a.setMedicoId(rs.getLong("ID_MEDICO"));
        a.setProcedimentoId(rs.getLong("ID_PROCEDIMENTO"));
        a.setDataHora(rs.getTimestamp("DATA_HORA").toLocalDateTime());
        a.setStatus(rs.getString("STATUS"));
        return a;
    };

    public void save(Agendamento a) {

        String sql = """
        INSERT INTO agendamentos 
        (ID_PACIENTE, ID_MEDICO, ID_PROCEDIMENTO, DATA_HORA, STATUS)
        VALUES (?, ?, ?, ?, ?)
    """;

        jdbcTemplate.update(sql,
                a.getPacienteId(),
                a.getMedicoId(),
                a.getProcedimentoId(),
                java.sql.Timestamp.valueOf(a.getDataHora()),
                a.getStatus()
        );
    }

    public List<Agendamento> findAll() {
        return jdbcTemplate.query("SELECT * FROM agendamentos", rowMapper);
    }

    public boolean existsByMedicoAndHorario(Long medicoId, Timestamp dataHora) {

        String sql = """
        SELECT COUNT(*) 
        FROM agendamentos 
        WHERE ID_MEDICO = ? AND DATA_HORA = ?
    """;

        Integer count = jdbcTemplate.queryForObject(
                sql,
                Integer.class,
                medicoId,
                dataHora
        );

        return count != null && count > 0;
    }
}