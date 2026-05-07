# 📅 Agendador de Horários

API REST desenvolvida com Java e Spring Boot para gerenciamento de agendamentos, autenticação JWT e controle de acesso.

---

# 🚀 Tecnologias utilizadas

- Java 21
- Spring Boot 3
- Spring Data JPA
- Spring Security
- JWT Authentication
- Swagger / OpenAPI
- Bean Validation
- Lombok
- MySQL
- Maven

---

# 📌 Funcionalidades

## 📅 Agendamentos

- ✅ Criar agendamento
- ✅ Buscar agendamentos por dia
- ✅ Atualizar agendamento
- ✅ Deletar agendamento
- ✅ Validação de conflitos de horário
- ✅ Validação de datas futuras
- ✅ Validação automática de campos obrigatórios

---

## 🔐 Segurança

- ✅ Login com JWT
- ✅ Senha criptografada com BCrypt
- ✅ Proteção de endpoints com Spring Security
- ✅ Autenticação via Bearer Token

---

## 📖 Documentação

- ✅ Swagger/OpenAPI integrado
- ✅ Exemplos de requests no Swagger
- ✅ API Docs gerada automaticamente

---

# 🗄️ Banco de dados

O projeto utiliza MySQL para persistência de dados.

---

# 📂 Estrutura do projeto

```text
src/main/java/com/javag/agendador_horarios
│
├── config
│   └── OpenApiConfig
│
├── controller
│   ├── AgendamentoController
│   └── AuthController
│
├── dto
│   ├── AgendamentoRequest
│   ├── AgendamentoResponse
│   ├── LoginRequest
│   └── LoginResponse
│
├── exception
│   ├── AgendamentoException
│   └── GlobalExceptionHandler
│
├── infrastructure
│   ├── entity
│   │   ├── Agendamento
│   │   └── Usuario
│   │
│   └── repository
│       ├── AgendamentoRepository
│       └── UsuarioRepository
│
├── security
│   ├── JwtFilter
│   ├── JwtService
│   ├── SecurityConfig
│   └── CustomUserDetailsService
│
├── service
│   ├── AgendamentoService
│   └── AuthService
│
└── AgendadorHorariosApplication
```

---

# 🔗 Endpoints

## 🔐 Autenticação

### Login

#### POST `/auth/login`

##### Request

```json
{
  "username": "admin",
  "password": "123456"
}
```

##### Response

```json
{
  "token": "eyJhbGciOiJIUzI1Ni..."
}
```

---

# 📅 Agendamentos

## ➕ Criar agendamento

### POST `/agendamentos`

#### Request

```json
{
  "servico": "Barba",
  "profissional": "Barbeiro",
  "cliente": "João",
  "telefone": "11999999999",
  "dataHoraAgendamento": "2026-04-24T10:00:00"
}
```

#### Response

```json
{
  "id": 1,
  "cliente": "João",
  "dataHoraAgendamento": "2026-04-24T10:00:00",
  "servico": "Barba"
}
```

---

## 🔍 Buscar agendamentos por dia

### GET `/agendamentos?data=2026-04-24`

#### Response

```json
[
  {
    "id": 1,
    "cliente": "João",
    "dataHoraAgendamento": "2026-04-24T10:00:00",
    "servico": "Barba"
  }
]
```

---

## ✏️ Atualizar agendamento

### PUT `/agendamentos?cliente=João&dataHoraAgendamento=2026-04-24T10:00:00`

#### Request

```json
{
  "servico": "Barba",
  "profissional": "Barbeiro",
  "cliente": "João",
  "telefone": "11999999999",
  "dataHoraAgendamento": "2026-04-24T11:00:00"
}
```

---

## 🗑️ Deletar agendamento

### DELETE `/agendamentos?cliente=João&dataHoraAgendamento=2026-04-24T10:00:00`

---

# ⚠️ Regras de negócio

- Não é permitido criar agendamentos conflitantes
- Cada agendamento possui duração de 1 hora
- Datas devem estar no futuro
- Campos obrigatórios são validados automaticamente
- O sistema valida conflitos utilizando intervalo de tempo

---

# 🔐 Autenticação JWT

A API utiliza JWT para autenticação.

Após realizar login:

```http
POST /auth/login
```

o sistema retorna um token JWT.

Esse token deve ser enviado nas requisições protegidas:

```http
Authorization: Bearer SEU_TOKEN
```

---

# 📖 Swagger / OpenAPI

## Swagger UI

```text
http://localhost:8080/swagger-ui/index.html
```

---

## API Docs

```text
http://localhost:8080/v3/api-docs
```

---

# ▶️ Como rodar o projeto

## 1️⃣ Clonar repositório

```bash
git clone https://github.com/VagnerUrata/agendador-horarios.git
```

---

## 2️⃣ Entrar na pasta

```bash
cd agendador-horarios
```

---

## 3️⃣ Criar banco MySQL

```sql
CREATE DATABASE agendador;
```

---

## 4️⃣ Configurar application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/agendador
spring.datasource.username=root
spring.datasource.password=1234

spring.jpa.hibernate.ddl-auto=update

jwt.secret=minha-chave-super-secreta-com-32-bytes
```

---

## 5️⃣ Rodar aplicação

```bash
./mvnw spring-boot:run
```

Ou executar diretamente pela IDE.

---

# 🧪 Usuário de teste

## Gerar hash BCrypt

```java
new BCryptPasswordEncoder().encode("123456")
```

---

## Inserir usuário

```sql
INSERT INTO usuario(username, password)
VALUES (
    'admin',
    '$2a$10$HASH_GERADO'
);
```

---

# 🛡️ Tratamento global de exceções

A API possui tratamento global utilizando:

- `@RestControllerAdvice`
- `@ExceptionHandler`

Tratando:

- Erros de validação
- Regras de negócio
- Erros internos do servidor

---

# 📌 Melhorias futuras

- Cadastro de usuários
- Roles (ADMIN / USER)
- Refresh Token
- Docker
- Deploy em nuvem
- Testes unitários
- Paginação
- Logs centralizados
- Observabilidade
- Rate limiting

---

# 👨‍💻 Autor

Projeto desenvolvido por Vagner Urata para estudo e prática de desenvolvimento backend utilizando:

- Java
- Spring Boot
- Spring Security
- JWT
- APIs REST
- Arquitetura Backend