CREATE TABLE tb_tipo_usuario(
id_tipo_usuario INT PRIMARY KEY AUTO_INCREMENT,
descricao VARCHAR(10) NOT NULL
);

INSERT INTO `tb_tipo_usuario`(`id_tipo_usuario`, `descricao`) VALUES ('1','admin');
INSERT INTO `tb_tipo_usuario`(`id_tipo_usuario`, `descricao`) VALUES ('2','usuario');

CREATE TABLE tbusuarios (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    nome varchar(150) not null,
    login varchar(15) not null unique,
    senha varchar(15) not null,
    idade int not null,
    sexo varchar(10) not null,
    id_tipo_usuario INT NOT NULL,
	CONSTRAINT FK_usuario_tipo FOREIGN KEY (id_tipo_usuario) REFERENCES tb_tipo_usuario(id_tipo_usuario)
);
-- Selecionatbusuariosr todos os registros da tabela "tbusuarios"
SELECT * FROM tbusuarios; 

-- Adicionar usuario admin na tabela "tbusuarios"
INSERT INTO tbusuarios (nome, login, senha, idade, sexo, id_tipo_usuario)
VALUES ('administrador','admin', 123, 23, 'masculino', 1);

-- Adicionar usuario comum na tabela "tbusuarios"
INSERT INTO tbusuarios(usuario, nome, login, senha, idade, sexo) value('comum', 'Mariana', 'mariana123', 'senha123', '21', 'feminino');

-- Criação da tabela de Livros
CREATE TABLE tb_genero(
id_genero INT PRIMARY KEY,
descricao VARCHAR(30)
);

-- SELECT * FROM tb_genero;
-- INSERT INTO tb_genero (id_genero, descricao) VALUES ('1','romance');
-- INSERT INTO tb_genero (id_genero, descricao) VALUES ('2','ficção');
-- INSERT INTO tb_genero (id_genero, descricao) VALUES ('3','técnico');

CREATE TABLE tb_livro (
  id_livro INT PRIMARY KEY AUTO_INCREMENT,
  titulo VARCHAR(30) NOT NULL,
  id_genero INT NOT NULL,
  idUsuario INT NOT NULL,
  CONSTRAINT FK_livro_genero FOREIGN KEY (id_genero) REFERENCES tb_genero(id_genero),
  CONSTRAINT FK_livro_usuario FOREIGN KEY (idUsuario) REFERENCES tbusuarios(idUsuario)
);


CREATE TABLE tb_avaliacao(
id_avaliacao INT PRIMARY KEY AUTO_INCREMENT,
nota INT NOT NULL,
idUsuario INT NOT NULL,
id_livro INT NOT NULL,
CONSTRAINT FK_avaliacao_idlivro FOREIGN KEY (id_livro) REFERENCES tb_livro(id_livro),
CONSTRAINT FK_avaliacao_idusuario FOREIGN KEY (idUsuario) REFERENCES tbusuarios(idUsuario)
);

CREATE TABLE tb_preferidos(
id_preferido INT PRIMARY KEY AUTO_INCREMENT,
idUsuario INT NOT NULL,
id_genero INT NOT NULL,
CONSTRAINT FK_preferido_usuario FOREIGN KEY (idUsuario) REFERENCES tbusuarios(idUsuario),
CONSTRAINT FK_preferido_genero FOREIGN KEY (id_genero) REFERENCES tb_genero(id_genero)  
);

-- SELECT * FROM tb_preferidos;