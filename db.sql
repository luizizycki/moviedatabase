CREATE TABLE tipo_usuario(
	id INT AUTO_INCREMENT PRIMARY KEY,
	tipo VARCHAR(20) NOT NULL UNIQUE,
	descricao TEXT
);

CREATE TABLE usuarios(
	id INT AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(15) NOT NULL UNIQUE,
	senha VARCHAR(15),
	tipo_user_id INT NOT NULL,
	FOREIGN KEY(tipo_user_id) REFERENCES tipo_usuario(id)
);

CREATE TABLE filmes(
	id INT AUTO_INCREMENT PRIMARY KEY,
	titulo VARCHAR(100) NOT NULL,
	diretor VARCHAR(50) NOT NULL,
	ano INT NOT NULL
);


INSERT INTO tipo_usuario (tipo, descricao) VALUES
('admin', 'Administrador do sistema, tem acesso a todas as funcionalidades.'),
('user', 'Usuário regular, acesso limitado ao sistema.');

INSERT INTO usuarios (username, senha, tipo_user_id) VALUES
('admin', 'senhateste123', 1),
('johndoe', 'minhasenha3434', 2),
('Luiz Gustavo', 'senhaluiz123123', 2);

INSERT INTO filmes (titulo, diretor, ano) VALUES
('Inception', 'Christopher Nolan', 2010),
('The Matrix', 'Lana Wachowski', 1999),
('The Godfather', 'Francis Ford Coppola', 1972),
('Pulp Fiction', 'Quentin Tarantino', 1994),
('The Shawshank Redemption', 'Frank Darabont', 1994);
