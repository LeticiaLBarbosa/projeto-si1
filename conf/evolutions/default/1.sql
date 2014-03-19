# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table aluno (
  login                     varchar(255) not null,
  nome                      varchar(255),
  senha                     varchar(255),
  planejador_id             bigint,
  constraint pk_aluno primary key (login))
;

create table disciplina (
  id                        bigint not null,
  nome                      varchar(255),
  creditos                  integer,
  alocada_corretamente      boolean,
  dificuldade               integer,
  constraint pk_disciplina primary key (id))
;

create table periodo (
  id                        bigint not null,
  constraint pk_periodo primary key (id))
;

create table planejador (
  id                        bigint not null,
  constraint pk_planejador primary key (id))
;


create table periodo_disciplina (
  periodo_id                     bigint not null,
  disciplina_id                  bigint not null,
  constraint pk_periodo_disciplina primary key (periodo_id, disciplina_id))
;
create sequence aluno_seq;

create sequence disciplina_seq;

create sequence periodo_seq;

create sequence planejador_seq;

alter table aluno add constraint fk_aluno_planejador_1 foreign key (planejador_id) references planejador (id) on delete restrict on update restrict;
create index ix_aluno_planejador_1 on aluno (planejador_id);



alter table periodo_disciplina add constraint fk_periodo_disciplina_periodo_01 foreign key (periodo_id) references periodo (id) on delete restrict on update restrict;

alter table periodo_disciplina add constraint fk_periodo_disciplina_discipl_02 foreign key (disciplina_id) references disciplina (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists aluno;

drop table if exists disciplina;

drop table if exists periodo;

drop table if exists periodo_disciplina;

drop table if exists planejador;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists aluno_seq;

drop sequence if exists disciplina_seq;

drop sequence if exists periodo_seq;

drop sequence if exists planejador_seq;

