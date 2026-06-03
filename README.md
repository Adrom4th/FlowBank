## Projeto FlowBank
Aplicação bancária desktop desenvolvida como projeto acadêmico no curso de Ciência da Computação. O sistema simula operações financeiras básicas de uma instituição bancária, incluindo cadastro de clientes, autenticação, consulta de extrato e transferências entre contas.

--

### Funcionalidades
- **Cadastro de clientes** com validação de dados
- **Autenticação via login** com e-mail e senha
- **Extrato bancário** com listagem de lançamentos com data, descrição e valor
- **Transferência entre contas** validada com movimentação em registro duplo (double-entry), vinculado por UUID para garantir rastreabilidade
- **Integridade transacional** com uso de transações JDBC com rollback automático em caso de falha

---

### Tecnologias Utilizadas
- **Java** como Linguagem principal
- **Java Swing** para Interface gráfica (GUI)
- **PostgreSQL** como Banco de dados relacional
- **Supabase** para Hospedagem do banco de dados
- **Git** e **GitHub** para Versionamento de código

---

### Screenshots

---

### Como Rodar o Projeto Localmente

#### Pré-requisitos
- Java JDK 17 ou superior instalado
- IDE Java de sua preferência
- Conta no Supabase com um projeto PostgreSQL configurado

#### Passo a passo
1. Clone o repositório
    ```
    git clone https://github.com/Adrom4th/FlowBank.git
    ```

2. Configure as credenciais do banco de dados
    ```
    public static String URL = "jdbc:postgresql://SEU_HOST:5432/postgres";
    public static String USERNAME = "SEU_USUARIO";
    public static String PASSWORD = "SUA_SENHA";
    public static String DRIVER = "org.postgresql.Driver";
    ```

3. Execute o script SQL para criar as tabelas no seu banco de dados.

O script de criação das tabelas está disponível em sql/schema.sql (se aplicável).

4. Abra o projeto na IDE
- Vá em File -> Open Project e selecione a pasta do FlowBank
- Certifique-se de que o driver JDBC do PostgreSQL está nas libraries do projeto
- Execute o projeto com F6 ou clicando em Run Project

---

### Estrutura do Banco de Dados
O sistema utiliza duas tabelas principais:

- **clientes** — armazena os dados dos usuários (id, nome, e-mail, celular, data de nascimento, senha)
- **extrato** — registra todos os lançamentos financeiros, com suporte a transferências vinculadas via coluna id_transferencia (UUID)

---

### 👨‍💻 Autor
Desenvolvido por Matheus Henrique, Matheus Serpeloni Silva, Leonardo Viana, Nicholas Alves e Lucas Ribeiro	como projeto de estudos de conceitos de lógica de programação em Java
