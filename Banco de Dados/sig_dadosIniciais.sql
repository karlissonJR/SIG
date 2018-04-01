use sig;

insert into funcionario values
	("11111111111", "Karlisson", "01110111", 5000.50),
    ("22222222222", "Gabriel", "02220222", 12000),
    ("33333333333", "Willames", "03330333", 25000);
    
insert into estoque values
	("001", 25),
    ("002", 50),
    ("003", 100);
    
insert into gerencia (cpf_funcionario, codigo_estoque) values
	("11111111111", "001"),
    ("11111111111", "001"),
    ("33333333333", "003");

insert into produto values
	("P001", "Pen Drive 8 GB", 25, "001"),
    ("P002", "Raquete", 30.25, "003"),
    ("P003", "Ovo", 1, "002"),
    ("P004", "Tênis", 50, "003");