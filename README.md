# 📅 Agendador de Horários

API REST desenvolvida em Java com Spring Boot para gerenciamento de agendamentos.

---

## 🚀 Tecnologias utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* Lombok
* H2 Database (atual)
* MySQL (planejado)
* Maven

---

## 📌 Funcionalidades

* ✅ Criar agendamento
* ❌ Evitar conflito de horários (validação de intervalo)
* 🔍 Buscar agendamentos por dia
* ✏️ Alterar agendamento
* 🗑️ Deletar agendamento

---

## 🗄️ Banco de dados

Atualmente o projeto utiliza o **H2 Database**, um banco em memória ideal para desenvolvimento e testes.

🔄 **Futuro:** o projeto será migrado para **MySQL**, visando persistência de dados em ambiente de produção.

---

## 📂 Estrutura do projeto

```
src/main/java/com/javag/agendador_horarios
│
├── controller
├── service
├── infrastructure
│   ├── entity
│   └── repository
```

---

## 🔗 Endpoints

### ➕ Criar agendamento

**POST** `/agendamentos`

```json
{
  "servico": "Barba",
  "profissional" : "barbeiro",
  "cliente": "João",
  "dataHoraAgendamento": "2026-04-24T10:00:00"
}
```

---

### 🔍 Buscar agendamentos por dia

**GET** `/agendamentos?data=2026-04-24`

---

### ✏️ Alterar agendamento

**PUT** `/agendamentos?cliente=João&dataHoraAgendamento=2026-04-24T10:00:00`

```json
{
  "servico": "Barba",
  "profissional" : "barbeiro",
  "cliente": "João",
  "dataHoraAgendamento": "2026-04-24T11:00:00"
}
```

---

### 🗑️ Deletar agendamento

**DELETE** `/agendamentos?cliente=João&dataHoraAgendamento=2026-04-24T10:00:00`

---

## ⚠️ Regras de negócio

* Não é permitido criar agendamentos no mesmo horário para o mesmo serviço
* Cada agendamento possui duração de 1 hora
* O sistema valida conflitos utilizando intervalo de tempo

---

## ▶️ Como rodar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/VagnerUrata/agendador-horarios.git
```

### 2. Entrar na pasta

```bash
cd agendador-horarios
```

### 3. Rodar aplicação

```bash
./mvnw spring-boot:run
```

Ou pela sua IDE (IntelliJ / VS Code)

---

## 🧪 Console do H2

Acesse:

```
http://localhost:8080/h2-console
```

---

## 📌 Melhorias futuras

* Migração para MySQL
* Autenticação com JWT
* Paginação de resultados
* Testes unitários
* Deploy em nuvem

---

## 👨‍💻 Autor

Projeto desenvolvido para estudo e prática com Spring Boot.
