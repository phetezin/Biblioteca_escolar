Sistema de Gerenciamento de Biblioteca Escolar

(Projeto Final de Programação Orientada a Objetos II - UNIPLAN)

Este projeto implementa um sistema CRUD (Create, Read, Update, Delete) completo para o gerenciamento de um acervo de biblioteca escolar, atendendo aos requisitos de arquitetura e tecnologia solicitados na avaliação final.

Arquitetura e Tecnologias
O sistema segue o padrão de arquitetura MVC (Model-View-Controller), garantindo a separação de responsabilidades e facilitando a manutenção do código.

1. Aplicação Desktop (Java - MVC Core)
Padrão: MVC (Model-View-Controller).

Linguagem: Java (JDK 11).

Interface: Java Swing (NetBeans IDE 14).

Camada model (Dados): Contém a classe Livro.java que define os atributos e o encapsulamento dos dados.

Camada view (Interface): Contém as telas Tela.java (Menu), TelaCadastro.java (Cadastro/Edição) e TelaListagem.java (Listagem/Pesquisa).

Camada dao (Controle/Acesso): Contém a lógica de serviço (LivroDAO.java) para comunicação direta com o banco de dados.

2. Banco de Dados
SGBD: MySQL.

Conexão: JDBC (MySQL Connector).

Estrutura: Tabelas Livros (incluindo o campo status ENUM) e Empréstimos (com Foreign Key para a tabela Livros).

3. Aplicação Mobile (AppSheet)
O requisito mobile é atendido através do AppSheet, utilizando o Google Sheets como base de dados para visualização de catálogo e status de empréstimos, provendo acesso rápido aos dados via dispositivos móveis.

Funcionalidades e Implementação (CRUD Detalhado)
Módulo	Funcionalidade Principal	Classes Envolvidas	Implementação no Código
CREATE (Cadastrar)	Inserção de novos livros no catálogo.	TelaCadastro, LivroDAO	O método btnSalvarActionPerformed chama dao.inserir().
READ (Listar/Filtrar)	Listagem de todos os livros com filtro em tempo real por Título e Autor.	TelaListagem, LivroDAO	O método carregarLivros(String filtro) chama dao.listarTodos(filtro) para aplicar a pesquisa SQL.
UPDATE (Editar)	Edição completa dos dados de um livro existente.	TelaCadastro, LivroDAO	O TelaCadastro é aberto com um ID; o método btnSalvarActionPerformed detecta o ID e chama dao.atualizar().
DELETE (Excluir)	Exclusão de um livro selecionado na tabela.	TelaListagem, LivroDAO	O método btnExcluirActionPerformed obtém o ID oculto da linha e chama dao.deletar(idLivro).


Como Executar o Projeto? 
Configurar o Banco de Dados: Execute o script script_biblioteca.sql no seu MySQL Workbench.

Abrir no NetBeans: Abra o projeto Biblioteca_escolar.

Adicionar Dependências: Adicione os arquivos JAR (mysql-connector.jar e rs2xml.jar) como bibliotecas do projeto.

Executar: Execute a classe principal (main method) na sua view/Tela.java.
