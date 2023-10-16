CREATE TABLE tbusuarios (

    IdUser INT AUTO_INCREMENT PRIMARY KEY,
    Usuario varchar(50) not null,
    Nome varchar(150) not null,
    Login varchar(15) not null unique,
    senha varchar(15) not null,
    Idade int not null,
    Sexo varchar(10) not null,
    Email varchar(50) not null
);

-- Criação da tabela de Livros
CREATE TABLE Livros (
    LivroID INT AUTO_INCREMENT PRIMARY KEY,
    Titulo VARCHAR(255) NOT NULL,
    Autor VARCHAR(100),
    Tipo VARCHAR(50)
);

-- Criação da tabela de Avaliações
CREATE TABLE Avaliacoes (
    AvaliacoesID INT AUTO_INCREMENT PRIMARY KEY,
    IdUses INT,
    LivroID INT,
    Avaliacao INT,
    FOREIGN KEY (IdUses) REFERENCES Users(IdUses),
    FOREIGN KEY (LivroID) REFERENCES Books(LivroID)
);