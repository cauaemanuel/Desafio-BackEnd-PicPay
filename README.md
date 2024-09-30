# PicPay Simplificado

Este projeto implementa um sistema simplificado inspirado no PicPay, permitindo a transferência de dinheiro entre usuários e para lojistas, validação de transações, e envio de e-mails personalizados para destinatários e remetentes após a conclusão das transações. Utiliza a integração com serviços externos simulados para autorização de transações e envio de notificações.

## Funcionalidades

### Cadastro de Usuários

- Cadastro de usuários com Nome Completo, CPF, e-mail e senha.
- Validação para garantir que CPF/CNPJ e e-mails sejam únicos no sistema.

### Transferências

- Usuários podem enviar dinheiro para outros usuários e lojistas.
- Lojistas apenas recebem transferências e não podem enviar dinheiro.
- Antes de finalizar a transferência, é validado se o usuário tem saldo suficiente.

### Autorização de Transações

- Utiliza um serviço externo simulado para autorizar transações antes da finalização.
- Site usado para criar o mock: https://designer.mocky.io/
### Notificação de Pagamentos

- Após a conclusão da transação, envia um e-mail personalizado tanto para o destinatário quanto para o remetente.

## Tecnologias Utilizadas

- **Java**: Linguagem principal de programação.
- **Spring Boot**: Framework utilizado para desenvolvimento da aplicação.
- **OpenFeign**: Biblioteca utilizada para integração com serviços externos via HTTP.
- **Banco de Dados**: Utiliza um banco de dados relacional H2 database

## Endpoints da API

### POST /transaction

Cria uma nova transação.

#### Payload de Exemplo

```json
{
  "value": 500.50,
  "senderid": 2,
  "receiver": 4
} 
```

### POST /users

Cadastra um novo usuário no sistema.

#### Payload de Exemplo

```json
{
  "NomeCompleto": "Usuario",
  "balance": 10000.00,
  "email": "usuairo@gmail.com",
  "senha": "senha123",
  "document": "123456789",
  "usertype": "COMMON or MERCHANT"
}
```

### GET /users

Este endpoint é utilizado para listar todos os usuários cadastrados no sistema. Não é necessário enviar um payload no corpo da requisição para este endpoint.
