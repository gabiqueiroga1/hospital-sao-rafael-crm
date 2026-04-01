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
        p.setId(rs.getLong("id"));
        p.setNome(rs.getString("nome"));
        p.setPeso(rs.getDouble("peso"));
        p.setAltura(rs.getDouble("altura"));
        p.setImc(rs.getDouble("imc"));
        return p;
    };

    public void save(Paciente p) {
        String sql = "INSERT INTO pacientes (nome, cpf, peso, altura, imc) VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                p.getNome(),
                p.getCpf(),
                p.getPeso(),
                p.getAltura(),
                p.getImc()
        );
    }

    public boolean existsByCpf(String cpf) {
        String sql = "SELECT COUNT(*) FROM pacientes WHERE cpf = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, cpf);
        return count != null && count > 0;
    }

    public List<Paciente> findAll() {
        return jdbcTemplate.query("SELECT * FROM pacientes", rowMapper);
    }
}