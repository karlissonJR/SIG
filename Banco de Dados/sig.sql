create database sig default charset 'utf8';
use sig;

create table gerente_de_estoque(
	cpf varchar(11),
    nome varchar(50) not null,
    salario decimal(8,2) unsigned not null,
    primary key(cpf)
);

create table estoque(
	codigo varchar(4),
    capacidade int not null,
    primary key(codigo)
);

create table produto(
	codigo varchar(6),
    nome varchar(30) not null,
    preco decimal(6,2) unsigned not null,
    codigo_estoque varchar(4),
    primary key(codigo)
);

create table gerencia(
	cpf_gerente varchar(11),
    codigo_estoque varchar(4),
    primary key(cpf_gerente, codigo_estoque)
);

alter table produto
add foreign key(codigo_estoque)
	references estoque(codigo)
    on delete set null
    on update cascade;
    
alter table gerencia
add foreign key(cpf_gerente)
	references gerente_de_estoque(cpf)
    on delete cascade
    on update cascade;
    
alter table gerencia
add foreign key(codigo_estoque)
	references estoque(codigo)
    on delete cascade
    on update cascade;