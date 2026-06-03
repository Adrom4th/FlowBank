## Projeto FlowBank
Aplicação bancária desktop desenvolvida como projeto acadêmico no curso de Ciência da Computação. O sistema simula operações financeiras básicas de uma instituição bancária, incluindo cadastro de clientes, autenticação, consulta de extrato e transferências entre contas.

### Funcionalidades
Cadastro de clientes — registro de novos usuários com validação de dados
Autenticação — login seguro por e-mail e senha
Extrato bancário — listagem de lançamentos com data, descrição e valor formatado
Transferência entre contas — movimentação com registro duplo (double-entry), vinculado por UUID para garantir rastreabilidade
Integridade transacional — uso de transações JDBC (setAutoCommit(false)) com rollback automático em caso de falha
