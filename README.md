# Desafio Técnico - Vaga Backend

## Sobre o Desafio

O objetivo é avaliar a capacidade de estruturar uma API RESTFUL utilizando boas práticas, relacionamentos de entidades e persistência de dados com Spring Boot e PostgreSQL.

---

## Desafio

Construa uma API REST para gerenciamento de clientes e seus contatos.  
Cada cliente pode ter um ou mais contatos associados.

---

## Requisitos Técnicos

A aplicação deve conter:

- Cadastro de Cliente (`POST /clientes`)
- Cadastro de Contato (`POST /contatos`) associado a um cliente existente
- Listagem de todos os clientes com seus contatos (`GET /clientes`)
- Listagem de contatos de um cliente específico (`GET /clientes/{id}/contatos`)
- Uso de Spring Boot + Spring Data JPA
- Banco de dados PostgreSQL
- Entidades `Cliente` e `Contato` com relacionamento **OneToMany / ManyToOne**

---

## Requisitos de Código

O código deve seguir boas práticas de desenvolvimento, incluindo:

- Separação de responsabilidades (camadas: **controller**, **service**, **repository**)
- Uso de **DTOs** para entrada e saída de dados
- Tratamento adequado de erros
- Uso de **Lombok**

---
