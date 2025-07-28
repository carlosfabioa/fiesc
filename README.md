# 🛒 API REST - Produtos e Categorias

Este projeto é uma API REST desenvolvida com Java e Spring Boot, que permite o gerenciamento de produtos vinculados a categorias. Utiliza banco de dados em memória (H2) e está documentada com Swagger (OpenAPI).

---

## Funcionalidades

- CRUD de Categorias
- CRUD de Produtos vinculados a Categorias
- Listagem de produtos por categoria
- Validações com Bean Validation
- Tratamento global de exceções
- Documentação automática com Swagger

---

## Tecnologias

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database
- Bean Validation
- Swagger / SpringDoc OpenAPI

---

## Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/api-produtos-categorias.git
   cd api-produtos-categorias
   
   
## Execute o projeto com Maven:
   ./mvnw spring-boot:run
   
## Acesse os recursos:
- Swagger UI: http://localhost:8080/swagger-ui.html
- H2 Console: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:produtosdb
- Usuário: sa
- Senha: (em branco)
 
 
## Endpoints da API
| Método | URL                        | Descrição                        |
|--------|----------------------------|----------------------------------|
| POST   | /categorias                | Criar nova categoria             |
| GET    | /categorias                | Listar todas as categorias       |
| GET    | /categorias/{id}           | Buscar categoria por ID          |
| PUT    | /categorias/{id}           | Atualizar categoria              |
| DELETE | /categorias/{id}           | Excluir categoria                |
| GET    | /categorias/{id}/produtos  | Listar produtos da categoria     |
| POST   | /produtos                  | Criar produto (com categoriaId)  |
| GET    | /produtos                  | Listar todos os produtos         |
| GET    | /produtos/{id}             | Buscar produto por ID            |
| PUT    | /produtos/{id}             | Atualizar produto                |
| DELETE | /produtos/{id}             | Excluir produto                  |

