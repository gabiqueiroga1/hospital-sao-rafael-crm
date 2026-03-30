package br.com.hospital_sao_rafael.crm.domain;

public class Paciente {

    private Long id;
    private String nome;
    private Double peso;
    private Double altura;
    private Double imc;

    public void calcularIMC() {

        if (peso != null && altura != null && altura > 0) {
            this.imc = peso / (altura * altura);
        }
    }

    // getters e setters
}