# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table aluno (
  nome                      varchar(255),
  planejador_id             bigint)
;

create table disciplina (
  id                        bigint not null,
  nome                      varchar(255),
  periodo                   integer,
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

create sequence disciplina_seq;

create sequence periodo_seq;

create sequence planejador_seq;

alter table aluno add constraint fk_aluno_planejador_1 foreign key (planejador_id) references planejador (id) on delete restrict on update restrict;
create index ix_aluno_planejador_1 on aluno (planejador_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists aluno;

drop table if exists disciplina;

drop table if exists periodo;

drop table if exists planejador;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists disciplina_seq;

drop sequence if exists periodo_seq;

drop sequence if exists planejador_seq;

