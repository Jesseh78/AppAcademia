# Projeto Final — Sistema de Academia

## Descrição do Projeto

O projeto consiste no desenvolvimento de um sistema de academia com autenticação de clientes, controle de academias disponíveis e registro de check-ins.

O sistema permitirá que um cliente realize login, visualize academias disponíveis e faça check-in em uma unidade, armazenando um histórico das entradas realizadas.

---

# Objetivo

Desenvolver um sistema simples utilizando:

- Java
- NetBeans
- Banco de Dados
- Bootstrap
- CRUD
- Login
- Relacionamento entre entidades

---

# Funcionalidades Principais

## Login de Cliente

O cliente poderá:

- Entrar no sistema utilizando email e senha
- Acessar as academias disponíveis
- Visualizar seu histórico de check-ins

---

## CRUD de Cliente

O sistema deverá permitir:

- Cadastrar cliente
- Listar clientes
- Editar clientes
- Excluir clientes

---

## Academias Mockadas

O sistema terá 8 academias cadastradas manualmente (mock).

Exemplo:

- Academia Centro
- Academia Zona Sul
- Academia Fitness Max
- Academia Power Gym
- etc.

---

## Check-in

O cliente poderá:

- Selecionar uma academia
- Realizar check-in
- Registrar data e horário automaticamente

---

## Histórico

O sistema armazenará:

- Cliente
- Academia
- Data do check-in
- Horário

---

# Estrutura das Entidades

## Cliente

| Campo | Tipo |
|---|---|
| id | Long |
| nome | String |
| email | String |
| senha | String |
| telefone | String |

---

## Academia

| Campo | Tipo |
|---|---|
| id | Long |
| nome | String |
| endereco | String |
| bairro | String |

---

## Checkin

| Campo | Tipo |
|---|---|
| id | Long |
| cliente_id | Long |
| academia_id | Long |
| data_hora | DateTime |

---

# Relacionamentos

- Um cliente pode realizar vários check-ins
- Uma academia pode receber vários check-ins
- O check-in relaciona cliente + academia

---

# Tecnologias

- Java
- NetBeans
- MySQL
- Bootstrap
- JDBC
- MVC

---

# Organização do Projeto

## Backend

Responsável por:

- Regras de negócio
- Login
- CRUD
- Banco de dados

---

## Frontend

Responsável por:

- Telas
- Bootstrap
- Interface do usuário

---

# Fluxo do Sistema

1. Cliente realiza login
2. Sistema exibe academias disponíveis
3. Cliente escolhe uma academia
4. Sistema registra check-in
5. Histórico é atualizado

---

# Evidências para Entrega

- Código no NetBeans
- Banco de dados funcionando
- Prints do sistema
- Diagrama/desenho da solução
- Uso do Bootstrap
- PDF no padrão ABNT

---

# Fluxo Básico de Git e Commits

## Entrar na branch dev

```bash
git checkout dev
git pull origin dev
git add .
git commit -m "feat: adiciona login de cliente"
git push origin dev

src/
├── model/
├──── dao/
├── controller/
├── util
