🏥 CRM Hospitalar - Spring Boot + JDBC
📌 Descrição do Projeto

Este projeto consiste no desenvolvimento de um CRM (Customer Relationship Management) para a área da saúde, utilizando Java com Spring Boot e integração com banco de dados Oracle via JDBC.

A aplicação foi estruturada com base em conceitos de Domain Driven Design (DDD) simplificado, com foco em organização, clareza e separação de responsabilidades.

O sistema permite o gerenciamento de pacientes e agendamentos médicos, aplicando regras reais de negócio.

👥 Integrantes do Grupo
Rafaela Heer Robinson - RM 560249
Lucas Alves Piereti - RM 559533
Julia Hadja Kfouri Nunes - RM 559410
Maria Eduarda Ferrés - RM 560418
Gabriela Queiroga Cocuzza da Silva - RM 560035
🧱 Arquitetura do Projeto
src/main/java/br/com/hospital_sao_rafael/crm/

├── controller
├── service
├── repository
├── domain
├── exception
├── config
└── CrmApplication.java
🔹 Responsabilidade de cada camada
Controller: recebe requisições HTTP
Service: aplica regras de negócio
Repository: executa queries no banco via JDBC
Domain: representa entidades
Exception: trata erros
Config: configura infraestrutura
⚙️ Tecnologias Utilizadas
Java 17+ / 21
Spring Boot
JDBC Template
Oracle Database
Maven
🗄️ Integração com Banco de Dados
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:XE
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

server.port=8080
📦 Entidades Principais
👤 Paciente
id
nome
cpf
peso
altura
imc (calculado automaticamente)
📅 Agendamento
id
pacienteId
medicoId
procedimentoId
dataHora
status
🔄 Funcionalidades Implementadas
👤 Pacientes
Cadastro de paciente
Listagem de pacientes
Validação de CPF único
Cálculo automático de IMC
📅 Agendamentos
Criação de agendamento
Listagem de agendamentos
Validação de data (não permite passado)
Validação de conflito de horário
Status automático
📏 Regras de Negócio
Não permitir agendamento no passado
Não permitir conflito de horário para o mesmo médico
CPF não pode ser duplicado
Paciente e médico são obrigatórios
IMC calculado automaticamente
⚠️ Tratamento de Exceções
ValidationException
BusinessException
ResourceNotFoundException
🌐 Endpoints da API
📌 Pacientes

POST /pacientes

{
  "nome": "Gabriela",
  "cpf": "12345678900",
  "peso": 60,
  "altura": 1.65
}

GET /pacientes

📌 Agendamentos

POST /agendamentos

{
  "pacienteId": 1,
  "medicoId": 1,
  "procedimentoId": 1,
  "dataHora": "2026-04-10T14:00:00"
}

GET /agendamentos

🚀 Como Executar
mvn spring-boot:run
🎯 Considerações Finais

Projeto desenvolvido com foco acadêmico, aplicando boas práticas de desenvolvimento, arquitetura em camadas e integração com banco de dados utilizando JDBC puro, sendo uma base sólida para evolução futura.
