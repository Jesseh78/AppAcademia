````md id="5i0b8e"
# Academia App

Sistema web desenvolvido em Java utilizando JSP, JDBC e MySQL com foco em gerenciamento de clientes e controle de check-ins em academias.

---

# Objetivo

O projeto tem como objetivo simular um sistema de academias onde clientes podem:

- Realizar login
- Visualizar academias disponíveis
- Fazer check-in
- Consultar histórico de check-ins

O sistema também possui um CRUD completo de clientes.

---

# Tecnologias Utilizadas

- Java
- JSP
- JDBC
- MySQL
- Apache NetBeans
- Bootstrap

---

# Estrutura do Projeto

```text
src/
├── model/
│   └── Cliente.java
│
├── model/dao/
│   └── ClienteDAO.java
│
└── util/
    └── ConectaDB.java

web/
├── cliente-cadastrar.jsp
├── cliente-listar.jsp
├── cliente-editar.jsp
├── login.jsp
└── historico.jsp
```

---

# Funcionalidades

## CRUD de Clientes

- Cadastrar cliente
- Listar clientes
- Editar cliente
- Excluir cliente

---

## Login

O cliente poderá acessar o sistema utilizando:

- Email
- Senha

---

## Academias

O sistema possui 8 academias mockadas para testes.

Exemplos:

- Academia Centro
- Academia Power Gym
- Academia Zona Sul
- Academia Fitness Max

---

## Check-in

O cliente poderá:

- Escolher uma academia
- Realizar check-in
- Registrar data e horário automaticamente

---

## Histórico

O sistema armazena:

- Cliente
- Academia
- Data do check-in
- Horário

---

# Banco de Dados

## Criar banco

```sql
CREATE DATABASE academia_app;
```

---

## Usar banco

```sql
USE academia_app;
```

---

## Tabela de clientes

```sql
CREATE TABLE clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    telefone VARCHAR(20)
);
```

---

# Configuração da Conexão

Arquivo:

```text
util/ConectaDB.java
```

Configuração padrão:

```java
DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/academia_app",
    "root",
    ""
);
```

---

# Como Executar

## 1. Clonar projeto

```bash
git clone URL_DO_REPOSITORIO
```

---

## 2. Abrir no NetBeans

- File
- Open Project

---

## 3. Configurar banco MySQL

Criar o banco utilizando os scripts SQL presentes neste README.

---

## 4. Executar o projeto

Executar no Apache Tomcat pelo NetBeans.

---

# Modelo de Entidades

## Cliente

| Campo | Tipo |
|---|---|
| id | INT |
| nome | VARCHAR |
| email | VARCHAR |
| senha | VARCHAR |
| telefone | VARCHAR |

---

## Academia

| Campo | Tipo |
|---|---|
| id | INT |
| nome | VARCHAR |
| endereco | VARCHAR |

---

## Checkin

| Campo | Tipo |
|---|---|
| id | INT |
| cliente_id | INT |
| academia_id | INT |
| data_hora | DATETIME |

---

# Melhorias Futuras

- Sistema de autenticação com sessão
- Criptografia de senha
- Dashboard
- Painel administrativo
- API REST
- Responsividade mobile

---

# Integrantes

- José Ulisses
- Nome Integrante 2
- Nome Integrante 3

---

# Licença

Projeto acadêmico desenvolvido para fins educacionais.
````
