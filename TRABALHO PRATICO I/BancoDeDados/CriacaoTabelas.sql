#DataBase = db_clinica

CREATE TABLE receitas(
id INT NOT NULL PRIMARY KEY auto_increment,
nome varchar(50) UNIQUE NOT NULL,
especialidade varchar(12) NOT NULL,
horaEntrada int,
horaSaida int NOT NULL
);

CREATE TABLE dados_pacientes(
id INT NOT NULL PRIMARY KEY auto_increment,
nome varchar(30) UNIQUE NOT NULL,
idade int NOT NULL,
tipoSanguineo varchar(10),
especialista varchar(150) NOT NULL,
sintomas varchar(150) not null
);