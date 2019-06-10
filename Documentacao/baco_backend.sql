/* Nome do banco: backend */

create table usuario (
   id serial not null,
   email varchar(80) unique not null,
   senha varchar(65) not null,
   primary key (id)
);

/* Parte do Portal */

create table organizacao (
   id serial not null,
   nome varchar(80) not null,
   cnpj varchar(20) not null,
   endereco varchar(50) not null,
   telefone varchar(15) not null,
   situacao boolean not null,
   primary key (id)
);

create table funcionarios (
   id serial not null,
   nome varchar(80),
   cpf varchar(14),
   cargo varchar(15),
   endereco varchar(100),
   telefone varchar(10),
   ativo boolean not null,
   foto varchar(100),
   organizacao_id int not null,
   usuario_id int not null,
   primary key (id),
   foreign key (organizacao_id) references organizacao (id)
   on delete no action
   on update no action,
   foreign key (usuario_id) references usuario (id)
   on delete no action
   on update no action
);

create table nivel (
   id serial not null,
   nome varchar(30) not null,
   nivel_superior_id int not null,
   nivel_inferior_id int not null,
   responsavel_id int not null,
   organizacao_id int not null,
   primary key (id),
   foreign key (nivel_superior_id) references nivel (id)
   on delete no action
   on update no action,
   foreign key (nivel_inferior_id) references nivel (id)
   on delete no action
   on update no action,
   foreign key (responsavel_id) references funcionario (id)
   on delete no action
   on update no action,
   foreign key (organizacao_id) references organizacao (id)
   on delete no action
   on update no action
);

create table setor (
   id serial not null,
   nome varchar(30) not null,
   gerente_id int not null,
   nivel_id int not null,
   primary key (id),
   foreign key (gerente_id) references funcionario (id)
   on delete no action
   on update no action,
   foreign key (nivel_id) references nivel (id)
   on delete no action
   on update no action
);

create table setor_funcionario (
   setor_id int not null,
   funcionario_id int not null,
   foreign key (setor_id) references setor (id)
   on delete no action
   on update no action,
   foreign key (funcionario_id) references funcionario (id)
   on delete no action
   on update no action
);

create table tipo_campo (
   id serial not null,
   nome varchar(100) not null,
   descricao varchar(300) not null,
   tipo varchar(10) not null,
   primary key (id)
);

create table tipo_item (
   id serial not null,
   nome varchar(100) not null,
   primary key (id)
);

create table tipo_item_campo (
   tipo_item_id int not null,
   tipo_campo_id int not null,
   foreign key (tipo_item_id) references tipo_item (id)
   on delete no action
   on update no action,
   foreign key (tipo_campo_id) references tipo_campo (id)
   on delete no action
   on update no action
);

create table tipo_solicitacao_delegacao (
   id serial not null,
   nome varchar(100) not null,
   descricao varchar(200) not null,
   tipo varchar(12) not null,
   primary key (id)
);

create table tipo_solicitacao_delegacao_item (
   tipo_solicitacao_delegacao_id int not null,
   tipo_item_id int not null,
   foreign key (tipo_solicitacao_delegacao_id) references tipo_solicitacao_delegacao (id)
   on delete no action
   on update no action,
   foreign key (tipo_item_id) references tipo_item (id)
   on delete no action
   on update no action
);

create table tipo_solicitacao_delegacao_nivel (
   id serial not null,
   tipo_solicitacao_delegacao_id int not null,
   nivel_id int not null,
   primary key (id),
   foreign key (tipo_solicitacao_delegacao_id) references tipo_solicitacao_delegacao (id)
   on delete no action
   on update no action,
   foreign key (nivel_id) references nivel (id)
   on delete no action
   on update no action
);

/* Parte do Backend */

create table solicitacao_delegacao (
   id serial not null,
   status varchar(10) not null,
   tipo_solicitacao_delegacao_id int not null,
   primary key (id),
   foreign key (tipo_solicitacao_delegacao_id) references tipo_solicitacao_delegacao (id)
   on delete no action
   on update no action
);

create table item (
   id serial not null,
   solicitacao_delegacao_id int not null,
   tipo_item_id int not null,
   primary key (id),
   foreign key (solicitacao_delegacao_id) references solicitacao_delegacao (id)
   on delete no action
   on update no action,
   foreign key (tipo_item_id) references tipo_item (id)
   on delete no action
   on update no action
);

create table campo (
   id serial not null,
   valor varchar(300) not null,
   item_id int not null,
   tipo_campo_id int not null,
   primary key (id),
   foreign key (item_id) references item (id)
   on delete no action
   on update no action,
   foreign key (tipo_campo_id) references tipo_campo (id)
   on delete no action
   on update no action
);

create table comentario (
   id serial not null,
   comentario varchar(200) not null,
   solicitacao_delegacao_id int not null,
   funcionario_id int not null,
   primary key (id),
   foreign key (solicitacao_delegacao_id) references solicitacao_delegacao (id)
   on delete no action
   on update no action,
   foreign key (funcionario_id) references funcionario (id)
   on delete no action
   on update no action
);
