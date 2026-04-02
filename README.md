# 🏥 CRM Hospitalar - Hospital São Rafael

## 📌 Descrição do Projeto

Este projeto consiste no desenvolvimento de um **CRM (Customer Relationship Management) para a área da saúde**, utilizando **Java com Spring Boot** e integração com **banco de dados Oracle via JDBC**.

A aplicação foi estruturada com base em conceitos de **Domain Driven Design (DDD) simplificado**, com foco em organização, clareza e separação de responsabilidades.

O sistema permite o gerenciamento de **pacientes** e **agendamentos médicos**, aplicando regras reais de negócio.

## 🧱 Arquitetura do Projeto

```

├── controller    → API REST (entrada de dados)
├── service       → regras de negócio
├── repository    → acesso ao banco (JDBC)
├── domain        → entidades do sistema
├── exception     → exceções customizadas
├── config        → configurações (JdbcTemplate)
└── CrmApplication.java

```

---

## ⚙️ Tecnologias Utilizadas

- Java 17+ / 21
- Spring Boot
- JDBC Template
- Oracle Database
- Maven

---

## 🗄️ Integração com Banco de Dados
```
properties
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:XE
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

server.port=8080
```
---
## 📦 Entidades Principais
## 👤 Paciente

- id
- nome
- cpf
- peso
- altura
- imc
## 📅 Agendamento

- id
- pacienteId
- medicoId
- procedimentoId
- dataHora
- status

## Regras de Negócio

- Não permitir agendamento no passado
- Não permitir conflito de horário para o mesmo médico
- Cpf não pode ser duplicado
- Paciente e médico são obrigatórios
---
## Endpoints da API
## Pacientes
- POST/pacientes
```
{
  "nome": "Gabriela",
  "cpf": "12345678900",
  "peso": 60,
  "altura": 1.65
}
```
- GET/pacientes
---
## Agendamentos
- POST/agendamentos
```
{
  "pacienteId": 1,
  "medicoId": 1,
  "procedimentoId": 1,
  "dataHora": "2026-04-10T14:00:00"
}
```
- GET/agendamentos
```
    {
        "dataHora": "2026-03-12T20:16:49",
        "id": 769,
        "medicoId": 1685,
        "pacienteId": 506,
        "procedimentoId": 1678,
        "status": "falta"
    }
```
---
## 🎯 Considerações Finais

Este projeto foi desenvolvido com foco acadêmico, aplicando conceitos de arquitetura em camadas e Domain Driven Design (DDD) de forma simplificada.

A solução permite o gerenciamento de pacientes e agendamentos médicos, integrando uma API REST com banco de dados Oracle utilizando JDBC.

---

## 👥 Integrantes do Grupo

- Rafaela Heer Robinson - RM 560249
- Lucas Alves Piereti - RM 559533
- Julia Hadja Kfouri Nunes - RM 559410
- Maria Eduarda Ferrés - RM 560418
- Gabriela Queiroga Cocuzza da Silva - RM 560035













