package br.com.hospital_sao_rafael.crm.repository;

import br.com.hospital_sao_rafael.crm.domain.Paciente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PacienteRepository {

    private final JdbcTemplate jdbcTemplate;

    public PacienteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Paciente> rowMapper = (rs, rowNum) -> {
        Paciente p = new Paciente();
        p.setId(rs.getLong("ID_PACIENTE"));
        p.setNome(rs.getString("NOME"));
        p.setCpf(rs.getString("CPF"));
        p.setPeso(rs.getDouble("PESO"));
        p.setAltura(rs.getDouble("ALTURA"));
        p.setImc(rs.getDouble("IMC"));
        return p;
    };

    public void save(Paciente p) {
        String sql = "INSERT INTO pacientes (NOME, CPF, PESO, ALTURA, IMC) VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                p.getNome(),
                p.getCpf(),
                p.getPeso(),
                p.getAltura(),
                p.getImc()
        );
    }

    public boolean existsByCpf(String cpf) {
        String sql = "SELECT COUNT(*) FROM pacientes WHERE CPF = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, cpf);
        return count != null && count > 0;
    }

    public List<Paciente> findAll() {
        return jdbcTemplate.query("SELECT * FROM pacientes", rowMapper);
    }
}