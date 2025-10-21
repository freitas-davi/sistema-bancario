# 🏦 Banco Simulador - Spring Boot + Java 17

Um projeto desenvolvido em **Spring Boot**, aplicando **Arquitetura Hexagonal** e boas práticas de desenvolvimento com **DTOs**, **camadas desacopladas** e um **banco H2 em memória**.

O objetivo é simular um **sistema bancário**, com funcionalidades de criação de usuários, contas bancárias, operações financeiras, e servir como base para o estudo.

---
## 🧩 Tecnologias Utilizadas

| Categoria | Tecnologias                                          |
|------------|------------------------------------------------------|
| Linguagem | **Java 17**                                          |
| Framework | **Spring Boot**, **Spring Web**, **Spring Data JPA** |
| Banco de Dados | **H2 database**                                      |
| Build | **Maven**                                            |
| Arquitetura | **Hexagonal (Ports & Adapters)**                     |

---

## 🚀 Funcionalidades Implementadas

✅ Criar **Usuário**  
✅ Criar automaticamente uma **Conta Bancária** associada  
✅ Geração de **número de conta aleatório (10 dígitos)**  
✅ Persistência em **banco local H2**  
✅ Estrutura em **Arquitetura Hexagonal (Ports and Adapters)**  
✅ Uso de **DTOs** para comunicação entre camadas

🔜 **Em desenvolvimento:**
- Autenticação com **JWT**
- Validação de **CPF**
- Depósito, saque e transferência
- Testes unitários com **JUnit 5**
