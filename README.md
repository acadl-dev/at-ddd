# 🎵 Music Streaming Platform – DDD + Spring Boot

Sistema acadêmico simulando uma plataforma de streaming de música com foco em **Domain-Driven Design (DDD)**, **Design Patterns** e **arquitetura em camadas com contextos isolados**.

---

# 📌 Visão Geral

O sistema implementa funcionalidades de:

- Criação de contas de usuário
- Gestão de assinaturas
- Processamento de transações financeiras
- Regras antifraude
- Validação de cartão de crédito

A arquitetura foi projetada utilizando **Bounded Contexts independentes**, seguindo princípios de **DDD estratégico e tático**.

---

# 🧠 Arquitetura do Sistema

## 📦 Bounded Contexts

- Account Context
- Subscription Context
- Payment Context

---

## 🏗️ Diagrama de Context Map (DDD)

```mermaid
flowchart LR

%% =========================
%% CONTEXTOS PRINCIPAIS
%% =========================

AccountContext[Account Context]
SubscriptionContext[Subscription Context]
PaymentContext[Payment Context]

CatalogContext[Catalog Context]
PlaylistContext[Playlist Context]
FavoriteContext[Favorite Context]

%% =========================
%% RELAÇÕES CORE DO DOMÍNIO
%% =========================

AccountContext -->|Customer-Supplier| SubscriptionContext
SubscriptionContext -->|Customer-Supplier| PaymentContext

AccountContext -->|Partnership| PaymentContext

CatalogContext -->|Upstream Provider| PlaylistContext
CatalogContext -->|Upstream Provider| FavoriteContext

%% =========================
%% ISOLAMENTO DE DOMÍNIO (ACL)
%% =========================

PaymentContext -->|Anti-Corruption Layer| AccountContext
PaymentContext -->|Anti-Corruption Layer| SubscriptionContext

%% =========================
%% REGRAS EXTERNAS (SISTEMAS TERCEIROS)
%% =========================

PaymentGateway[Payment Gateway / Bank API]
MusicProvider[Music Provider API]

PaymentContext -->|External Gateway| PaymentGateway
CatalogContext -->|External Source| MusicProvider
```

---


## 🧱 Estrutura do projeto

src/main/java/com/acadl/musicstreaming
```
├── account
│   ├── controller
│   ├── domain
│   └── repository

├── subscription
│   ├── controller
│   ├── domain
│   ├── service
│   ├── repository
│   └── usecase

├── payment
│   ├── controller
│   ├── domain
│   ├── repository
│   ├── rule
│   ├── service
│   └── usecase

└── shared
    └── exception
```

## ⚙️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
- Lombok

## 🚀 Como Executar o Projeto
```bash
git clone https://github.com/seu-repositorio/music-streaming-ddd.git
cd music-streaming-ddd
```
Acessar H2 Database:
```http://localhost:8081/h2-console```

User Name: atddd

Password: teste


## 📡 Endpoints da API


##  Endpoints

### Account
| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/accounts` | Criar conta |

### Subscription
| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/subscriptions` | Criar plano |

### Payment
| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/transactions` | Autorizar transação |

---

Exemplos de body:
 
- Para criar conta:

``` 
{
  "name": "User Name",
  "email": "user@email.com"
} 
```

- Para criar plano:

``` 
{
  "userId": "UUID"
}
```

- Para autorizar transação:

```
{
  "userId": "UUID",
  "merchant": "Spotify Premium",
  "amount": 29.90
}
```

Para testes o cartão de crédito precisa ser inserido manualmente:

``` sql
INSERT INTO credit_cards
(id, user_id, card_number, active)

VALUES
(
RANDOM_UUID(),
'UUID_DO_USUARIO',
'123456789',
true
);
```



## 🧠 Regras de Negócio

Subscription Context
- Um usuário pode ter apenas uma assinatura ativa
Payment Context (Antifraude)
- Cartão deve estar ativo
- Máximo de 3 transações em 2 minutos
- Máximo de 2 transações iguais no mesmo intervalo
- Regras implementadas com Strategy Pattern

## 🧩 Padrões de Projeto Aplicados

✔ Strategy Pattern (Fraud Rules)
✔ Repository Pattern
✔ Domain Service
✔ Use Case Pattern
✔ Anti-Corruption Layer
✔ Domain-Driven Design (DDD)

## 🧠 Conceitos de DDD Aplicados

✔ Bounded Contexts

Separação clara entre domínio de conta, assinatura e pagamento.

✔ Ubiquitous Language

Termos consistentes como:

Subscription
Transaction
Credit Card
Fraud Rule
✔ Domain Services

Regras complexas isoladas do domínio das entidades.

✔ Aggregates
User
Subscription
Transaction
CreditCard

## 🔐 Regras Antifraude

Card must be active
Max 3 transactions in 2 minutes
Max 2 identical transactions in 2 minutes

## 📌 Conclusão

Este projeto demonstra a aplicação prática de:

Domain-Driven Design
Clean Architecture simplificada
Design Patterns essenciais
Separação de contextos
Modelagem orientada ao domínio

O objetivo principal é manter um sistema:

escalável
modular
testável
e alinhado com boas práticas de engenharia de software.