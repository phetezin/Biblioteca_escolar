-- Raphael Cordeiro Lopes UNIPLAN 4° SEMESTRE //*

CREATE DATABASE biblioteca_escolar;
USE biblioteca_escolar;

CREATE TABLE Livros (
    id_livro INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    codigo VARCHAR(50),
    ano_publicacao INT,
    status ENUM('Disponivel', 'Emprestado', 'Em Manutencao') NOT NULL
);

CREATE TABLE Emprestimos (
    idEmprestimo INT PRIMARY KEY AUTO_INCREMENT,
    idLivro INT,
    dataEmprestimo DATE NOT NULL,
    dataDevolucao DATE,
    
	FOREIGN KEY (idLivro) REFERENCES Livros(id_livro)
);