package br.com.hospital_sao_rafael.crm.domain;

public class Paciente {

    private Long id;
    private String cpf;
    private String nome;
    private Double peso;
    private Double altura;
    private Double imc;

    public Paciente() {}

    public void calcularIMC() {
        if (peso != null && altura != null && altura > 0) {
            this.imc = peso / (altura * altura);
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getPeso() { return peso; }
    public void setPeso(Double peso) { this.peso = peso; }

    public Double getAltura() { return altura; }
    public void setAltura(Double altura) { this.altura = altura; }

    public Double getImc() { return imc; }
    public void setImc(Double imc) { this.imc = imc; }
}