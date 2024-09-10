create table municipio(
id int not null primary key auto_increment,
nome varchar(100),
estado varchar(100)
);

create table cliente(
id int not null primary key auto_increment,
nome varchar(100),
endereco varchar(100),
numero varchar(100),
bairro varchar(100),
idmunicipio int not null,
telefone varchar(11),
celular varchar(11)
);

create table lancamento(
id int not null primary key auto_increment,
datalancamento date,
id_cliente int not null,
tipolancamento varchar(100),
valorlancamento decimal(10,2)
);

alter table cliente add constraint FK_municipio_cliente foreign key (idmunicipio)
references municipio(id);

alter table lancamento add constraint FK_cliente_lancamento foreign key (id_cliente)
references cliente(id);


