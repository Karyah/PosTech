# Sistema de Reserva de Salas

Esse projeto é um sistema de reserva de salas desenvolvido em Java com Spring Boot. Ele permite gerenciar usuários, salas e realizar reservas, com uma interface que facilita o teste e a inicialização de dados.

## 🚀 Funcionalidades

- **CRUD de Usuários**: Permite adicionar, visualizar, atualizar e excluir usuários.
- **CRUD de Salas**: Permite gerenciar salas com informações específicas.
- **CRUD de Reservas**: Realize reservas entre usuários e salas com facilidade.
- **CRUD de Feedback**: Os usuários podem enviar feedbacks sobre suas reservas, ajudando na avaliação de melhorias.
- **População Automática**: Um arquivo SQL carrega automaticamente dados iniciais no H2 para testes.
- **Exemplo de Requisições**: Coleção do Postman com exemplos prontos para facilitar os testes.

## 🛠️ Tecnologias

- **Java** - Linguagem principal.
- **Spring Boot** - Framework de desenvolvimento.
- **H2 Database** - Banco de dados em memória para testes rápidos.
- **Postman** - Ferramenta para testes de API (coleção disponível).

## 📦 Estrutura do Projeto
PosTech  
├── src  
│   ├── main  
│   │   ├── java  
│   │   │   └── br.com.fiap.reserva_salas  
│   │   │       ├── dto  
│   │   │       ├── entity  
│   │   │       ├── service  
│   │   │       └── controller  
│   │   │           └── exception  
│   │   └── resources  
│   │       ├── application.properties  
│   │       └── data.sql  
└── README.md  

- **`dto`**: Contém as classes de Data Transfer Objects.
- **`entity`**: Contém as entidades mapeadas para o banco de dados.
- **`service`**: Lógica de negócio.
- **`controller`**: Controladores REST.
- **`resources`**: Configurações e arquivos de dados iniciais.

## 📝 Pré-requisitos

- **Java 17** ou superior
- **Maven**

## ⚙️ Configuração e Execução

1. **Clone o Repositório**

   ```bash
   git clone https://github.com/Karyah/PosTech.git
   cd PosTech

2. **Configure o Banco de Dados**

O projeto está configurado para usar um banco de dados H2. Na inicialização, ele carrega dados a partir do arquivo data.sql.

3. **Compile e Execute**
   
   ```bash
   mvn spring-boot:run

4. **Testando com Postman**

Use a coleção do Postman para facilitar os testes:

🔗 **[Acessar Coleção no Postman](https://api.postman.com/collections/15767856-87ba9f19-c3c1-4beb-b033-acd2913740b9?access_key=PMAT-01JBAWM1BXDBPVM33Q33YEVJAA)**


### Usuário

1. `GET /usuarios` - Lista todos os usuários.
2. `POST /usuarios` - Cria um novo usuário.
3. `GET /usuarios/{id}` - Lista um usuário pelo ID.
4. `PUT /usuarios/{id}` - Atualiza um usuário.
5. `DELETE /usuarios/{id}` - Remove um usuário.

### Sala

1. `GET /sala` - Lista todas as salas.
2. `POST /sala` - Cria uma nova sala.
3. `GET /sala/{id}` - Lista uma sala pelo ID.
4. `PUT /sala/{id}` - Atualiza uma sala.
5. `DELETE /sala/{id}` - Remove uma sala.

### Reserva

1. `GET /reservas` - Lista todas as reservas.
2. `POST /reservas` - Realiza uma nova reserva.
3. `GET /reservas/{id}` - Lista uma reserva pelo ID.
4. `PUT /reservas/{id}` - Atualiza uma reserva.
5. `DELETE /reservas/{id}` - Cancela uma reserva.

### Feedback
1. `POST /feedbacks` - Cria um novo feedback para uma reserva.
2. `GET /feedbacks/{id}` - Obtém um feedback específico pelo ID.
3. `GET /feedbacks/reserva/{reservaId}` - Lista todos os feedbacks relacionados a uma reserva específica.
4. `PUT /feedbacks/{id}` - Atualiza um feedback existente.
5. `DELETE /feedbacks/{id}` - Exclui um feedback.
