create table organizacao (
   id serial not null,
   nome varchar(80) not null,
   cnpj varchar(15) not null,
   endereco varchar(50) not null,
   telefone varchar(15) not null,
   situacao boolean not null,
   numero_nivel varchar(2) not null,
   primary key (id)
);

create table funcionario (
   id serial not null,
   nome varchar(80),
   email varchar(80),
   senha varchar(15),
   cpf varchar(14),
   cargo varchar(15),
   endereco varchar(100),
   telefone varchar(10),
   ativo boolean not null,
   foto varchar(100),
   organizacao_id int,
   primary key (id),
   foreign key (organizacao_id) references organizacao (id)
      on delete no action
      on update no action
);

create table nivel (
   id serial not null,
   nome varchar(30) not null,
   nivel_superior_id int,
   nivel_inferior_id int,
   funcionario_id int not null,
   organizacao_id int not null,
   primary key (id),
   foreign key (nivel_superior_id) references nivel (id)
      on delete no action
      on update no action,
   foreign key (nivel_inferior_id) references nivel (id)
      on delete no action
      on update no action,
   foreign key (funcionario_id) references funcionario (id)
      on delete no action
      on update no action,
   foreign key (organizacao_id) references organizacao (id)
      on delete no action
      on update no action
);

create table setor (
   id serial not null,
   nome varchar(20) not null,
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
   id serial not null,
   setor_id int not null,
   funcionario_id int not null,
   primary key (id),
   foreign key (setor_id) references setor (id)
      on delete no action
      on update no action,
   foreign key (funcionario_id) references funcionario (id)
      on delete no action
      on update no action
);

create table tipo_item (
   id serial not null,
   nome varchar(100) not null,
   primary key (id)
);

create table tipo_campo (
   id serial not null,
   nome varchar(100) not null,
   descricao varchar(300),
   tipo varchar(6) not null,
   primary key (id)
);

create table tipo_item_campo (
   id serial not null,
   tipo_item_id int not null,
   tipo_campo_id int not null,
   primary key (id),
   foreign key (tipo_item_id) references tipo_item (id)
      on delete no action
      on update no action,
   foreign key (tipo_campo_id) references tipo_campo (id)
      on delete no action
      on update no action
);

create table tipo_solicitacao_delegacao (
   id serial not null,
   tipo varchar(100) not null,
   tipo_s_d char(1) not null,
   descricao varchar(300) not null,
   primary key (id)
);

create table tipo_solicitacao_delegacao_item (
   id serial not null,
   tipo_delegacao_id int not null,
   tipo_item_id int not null,
   primary key (id),
   foreign key (tipo_delegacao_id) references tipo_solicitacao_delegacao (id)
      on delete no action
      on update no action,
   foreign key (tipo_item_id) references tipo_item (id)
      on delete no action
      on update no action
);

/* Parte do backend */

create table solicitacao_delegacao (
	id serial not null,
   	tipo_id int not null,
   	status varchar(30) not null,
   	primary key (id),
   	foreign key (tipo_id) references tipo_solicitacao_delegacao (id)
      on delete no action
      on update no action
);

create table comentario (
	id serial not null,
	comentario varchar(300) not null,
	s_d_id int not null,
	funcionario_id int not null,
	primary key (id),
	foreign key (s_d_id) references solicitacao_delegacao (id)
      on delete no action
      on update no action,
    foreign key (funcionario_id) references funcionario (id)
      on delete no action
      on update no action
);

create table item (
   id serial not null,
   s_d_id int not null,
   tipo_item_id int not null,
   primary key (id),
   foreign key (s_d_id) references solicitacao_delegacao (id)
      on delete no action
      on update no action,
   foreign key (tipo_item_id) references tipo_item (id)
      on delete no action
      on update no action
);

create table campo (
   id serial not null,
   valor varchar(200) not null,
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
