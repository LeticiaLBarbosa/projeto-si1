# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table aluno (
  id                        varchar(255) not null,
  planejador_id             bigint,
  nome                      varchar(255),
  senha                     varchar(255),
  constraint pk_aluno primary key (id))
;

create table catalogo_disciplinas (
  id                        varchar(255) not null,
  constraint pk_catalogo_disciplinas primary key (id))
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

create table planejador (
  id                        bigint not null,
  catalogo_id               varchar(255),
  constraint pk_planejador primary key (id))
;

create sequence aluno_seq;

create sequence catalogo_disciplinas_seq;

create sequence disciplina_seq;

create sequence planejador_seq;

alter table aluno add constraint fk_aluno_planejador_1 foreign key (planejador_id) references planejador (id) on delete restrict on update restrict;
create index ix_aluno_planejador_1 on aluno (planejador_id);
alter table planejador add constraint fk_planejador_catalogo_2 foreign key (catalogo_id) references catalogo_disciplinas (id) on delete restrict on update restrict;
create index ix_planejador_catalogo_2 on planejador (catalogo_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists aluno;

drop table if exists catalogo_disciplinas;

drop table if exists disciplina;

drop table if exists planejador;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists aluno_seq;

drop sequence if exists catalogo_disciplinas_seq;

drop sequence if exists disciplina_seq;

drop sequence if exists planejador_seq;

