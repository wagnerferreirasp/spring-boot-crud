CREATE TABLE usuario (
    usuario_id int auto_increment primary key,
    nome varchar(100) not null,
    email varchar(100) not null,
    senha varchar(300) not null
);

CREATE TABLE role (
    role_id int(11) NOT NULL auto_increment,
    nome varchar(255) default NULL,
    PRIMARY KEY (role_id)
);

CREATE TABLE  usuario_role (
    usuario_id int(11) NOT NULL,
    role_id int(11) NOT NULL,
    PRIMARY KEY  (usuario_id, role_id),
    FOREIGN KEY (usuario_id) REFERENCES usuario (usuario_id),
    FOREIGN KEY (role_id) REFERENCES role (role_id)
);

CREATE TABLE socio (
    socio_id int auto_increment primary key,
    nome varchar(100) not null
);

CREATE TABLE dados_da_empresa (
    dados_da_empresa_id int auto_increment primary key,
    nome varchar(100) not null,
    email varchar(100) not null,
    endereco varchar(100) not null,
    empresa_foi_constituida boolean not null,
    descricao_do_negocio varchar(1000) not null,
    socio_id int not null
);

ALTER TABLE dados_da_empresa
ADD foreign key (socio_id) references socio(socio_id);

CREATE TABLE grande_empresa (
    grande_empresa_id int auto_increment primary key,
    dados_da_empresa_id int not null
);

ALTER TABLE grande_empresa
ADD foreign key (dados_da_empresa_id) references dados_da_empresa(dados_da_empresa_id);

CREATE TABLE startup (
    startup_id int auto_increment primary key,
    dados_da_empresa_id int not null,
    esta_buscando_investimento boolean not null,
    foreign key (dados_da_empresa_id) references dados_da_empresa(dados_da_empresa_id)
);

CREATE TABLE tipo_de_mentor (
    tipo_de_mentor_id int auto_increment primary key,
    nome varchar(100) not null
);

CREATE TABLE startup_tipo_de_mentor (
    startup_tipo_de_mentor_id int auto_increment primary key,
    startup_id int not null,
    tipo_de_mentor_id int not null,
    foreign key (startup_id) references startup(startup_id),
    foreign key (tipo_de_mentor_id) references tipo_de_mentor(tipo_de_mentor_id)
);

CREATE TABLE usuario_startup (
    usuario_startup_id int auto_increment primary key,
    startup_id int not null,
    usuario_id int not null,
    foreign key (startup_id) references startup(startup_id),
    foreign key (usuario_id) references usuario(usuario_id)
);

CREATE TABLE usuario_grande_empresa (
    usuario_grande_empresa_id int auto_increment primary key,
    grande_empresa_id int not null,
    usuario_id int not null,
    foreign key (grande_empresa_id) references grande_empresa(grande_empresa_id),
    foreign key (usuario_id) references usuario(usuario_id)
);

