create database sig default charset 'utf8';
use sig;

create table funcionario(
	cpf varchar(11),
    nome varchar(50) not null,
    telefone varchar(11) not null,
    salario decimal(8,2) unsigned not null,
    primary key(cpf)
);

create table estoque(
	codigo varchar(3),
    capacidade int unsigned not null,
    primary key(codigo)
);

create table gerencia(
	numero_gerencia int auto_increment,
	cpf_funcionario varchar(11),
    codigo_estoque varchar(3),
    primary key(numero_gerencia, cpf_funcionario, codigo_estoque)
);

create table produto(
	codigo varchar(4),
    nome varchar(50) not null,
    preco decimal(8,2) unsigned not null,
    codigo_estoque varchar(3) not null,
    primary key(codigo)
);

alter table gerencia
add foreign key(cpf_funcionario)
	references funcionario(cpf)
    on delete cascade
    on update cascade;
    
alter table gerencia
add foreign key(codigo_estoque)
	references estoque(codigo)
    on delete cascade
    on update cascade;

alter table produto
add foreign key(codigo_estoque)
	references estoque(codigo)
    on delete cascade
    on update cascade;