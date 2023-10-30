CREATE TABLE tbusuarios (

    idUser INT AUTO_INCREMENT PRIMARY KEY,
    usuario varchar(50) not null,
    nome varchar(150) not null,
    login varchar(15) not null unique,
    senha varchar(15) not null,
    idade int not null,
    sexo varchar(10) not null,
    email varchar(50) not null
);
-- Selecionar todos os registros da tabela "tbusuarios"
SELECT * FROM tbusuarios; 

-- Adicionar usuario admin na tabela "tbusuarios"
INSERT INTO tbusuarios(usuario, nome, login, senha, idade, sexo, email) value('admin', 'administrador', 'admin', '123', '23', 'masculino', 'admin@hotmail.com');

-- Adicionar usuario comum na tabela "tbusuarios"
INSERT INTO tbusuarios(usuario, nome, login, senha, idade, sexo, email) value('comum', 'Mariana', 'mariana123', 'senha123', '21', 'feminino', 'mariana@hotmail.com');

-- Criação da tabela de Livros
CREATE TABLE Livros (
    livroID INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(100),
    tipo VARCHAR(50)
);

-- Criação da tabela de Avaliações
CREATE TABLE Avaliacoes (
    avaliacoesID INT AUTO_INCREMENT PRIMARY KEY,
    idUses INT,
    livroID INT,
    avaliacao INT,
    FOREIGN KEY (IdUses) REFERENCES Users(IdUses),
    FOREIGN KEY (LivroID) REFERENCES Books(LivroID)
);