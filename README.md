# Library-Management-System

# 📚 Sistema de Gestão de Biblioteca

## 📖 Descrição do Projeto

O Sistema de Gestão de Biblioteca é uma aplicação desenvolvida para controlar o cadastro de usuários, livros e empréstimos de uma biblioteca.

O sistema permite gerenciar o acervo, registrar empréstimos e devoluções, além de controlar a disponibilidade dos livros em tempo real.

Este projeto foi desenvolvido com o objetivo de aplicar conceitos de desenvolvimento backend utilizando Java, Spring Boot e banco de dados relacional MySQL.

---

## 🚀 Tecnologias Utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* Maven
* MySQL
* Hibernate
* Lombok
* Bean Validation
* Swagger OpenAPI
* Git
* GitHub
* Postman

---

## 🏗️ Arquitetura do Projeto

```text
biblioteca/
│
├── controller
│   ├── UsuarioController
│   ├── LivroController
│   └── EmprestimoController
│
├── model
│   ├── Usuario
│   ├── Livro
│   └── Emprestimo
│
├── repository
│   ├── UsuarioRepository
│   ├── LivroRepository
│   └── EmprestimoRepository
│
├── service
│   └── EmprestimoService
│
├── dto
│   └── EmprestimoRequest
│
│
└── BibliotecaApplication
```

---

## 🗄️ Estrutura do Banco de Dados

### Tabela: usuarios

| Campo    | Tipo         |
| -------- | ------------ |
| id       | BIGINT       |
| nome     | VARCHAR(100) |
| email    | VARCHAR(100) |
| telefone | VARCHAR(20)  |

### Tabela: livros

| Campo      | Tipo         |
| ---------- | ------------ |
| id         | BIGINT       |
| titulo     | VARCHAR(200) |
| autor      | VARCHAR(100) |
| isbn       | VARCHAR(30)  |
| quantidade | INT          |

### Tabela: emprestimos

| Campo           | Tipo        |
| --------------- | ----------- |
| id              | BIGINT      |
| usuario_id      | BIGINT      |
| livro_id        | BIGINT      |
| data_emprestimo | DATE        |
| data_devolucao  | DATE        |
| status          | VARCHAR(20) |

---

## 🔗 Endpoints da API

### Usuários

| Método | Endpoint       |
| ------ | -------------- |
| GET    | /usuarios      |
| GET    | /usuarios/{id} |
| POST   | /usuarios      |
| PUT    | /usuarios/{id} |
| DELETE | /usuarios/{id} |

### Livros

| Método | Endpoint     |
| ------ | ------------ |
| GET    | /livros      |
| GET    | /livros/{id} |
| POST   | /livros      |
| PUT    | /livros/{id} |
| DELETE | /livros/{id} |

### Empréstimos

| Método | Endpoint                   |
| ------ | -------------------------- |
| GET    | /emprestimos               |
| POST   | /emprestimos               |
| PUT    | /emprestimos/{id}/devolver |

---

## 📌 Exemplo de Cadastro de Usuário

### POST /usuarios

```json
{
  "nome": "Lucas",
  "email": "lucas@email.com",
  "telefone": "27999999999"
}
```

### Resposta

```json
{
  "id": 1,
  "nome": "Lucas",
  "email": "lucas@email.com",
  "telefone": "27999999999"
}
```

---

## 📌 Exemplo de Cadastro de Livro

### POST /livros

```json
{
  "titulo": "Clean Code",
  "autor": "Robert C. Martin",
  "isbn": "9780132350884",
  "quantidade": 5
}
```

---

## 📌 Exemplo de Empréstimo

### POST /emprestimos

```json
{
  "usuarioId": 1,
  "livroId": 1
}
```

---

## 📊 Regras de Negócio

* Um livro só pode ser emprestado se houver quantidade disponível.
* Ao realizar um empréstimo, a quantidade do livro é reduzida.
* Ao devolver um livro, a quantidade é incrementada.
* Um empréstimo devolvido não pode ser devolvido novamente.
* Usuários e livros devem existir antes da realização do empréstimo.

---

## 📷 Prints do Sistema

### Cadastro de Usuário

Adicionar imagem do Postman.

### Cadastro de Livro

Adicionar imagem do Postman.

### Empréstimo

Adicionar imagem do Postman.

### Swagger

Adicionar imagem da documentação Swagger.

---

## ⚙️ Como Executar o Projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/biblioteca.git
```

### 2. Acessar a pasta

```bash
cd biblioteca
```

### 3. Criar o banco de dados

```sql
CREATE DATABASE biblioteca_db;
```

### 4. Configurar o application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca_db
spring.datasource.username=root
spring.datasource.password=sua_senha
```

### 5. Executar o projeto

```bash
mvn spring-boot:run
```

### 6. Acessar a API

```text
http://localhost:8080
```

### 7. Acessar o Swagger

```text
http://localhost:8080/swagger-ui/index.html
```

---

## 👨‍💻 Autor

Lucas Wandelkookem

Projeto desenvolvido para fins acadêmicos e aprimoramento de conhecimentos em Java, Spring Boot, APIs REST e Banco de Dados Relacional.
