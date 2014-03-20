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


create table dependencias (
  disciplina                     bigint not null,
  preRequisito                   bigint not null,
  constraint pk_dependencias primary key (disciplina, preRequisito))
;

create table dependenciasPeriodo (
  periodo                        bigint not null,
  disciplinas                    bigint not null,
  constraint pk_dependenciasPeriodo primary key (periodo, disciplinas))
;

create table planejador_periodo (
  planejador_id                  bigint not null,
  periodo_id                     bigint not null,
  constraint pk_planejador_periodo primary key (planejador_id, periodo_id))
;

create table planejador_disciplina (
  planejador_id                  bigint not null,
  disciplina_id                  bigint not null,
  constraint pk_planejador_disciplina primary key (planejador_id, disciplina_id))
;
create sequence aluno_seq;

create sequence disciplina_seq;

create sequence periodo_seq;

create sequence planejador_seq;

alter table aluno add constraint fk_aluno_planejador_1 foreign key (planejador_id) references planejador (id) on delete restrict on update restrict;
create index ix_aluno_planejador_1 on aluno (planejador_id);



alter table dependencias add constraint fk_dependencias_disciplina_01 foreign key (disciplina) references disciplina (id) on delete restrict on update restrict;

alter table dependencias add constraint fk_dependencias_disciplina_02 foreign key (preRequisito) references disciplina (id) on delete restrict on update restrict;

alter table dependenciasPeriodo add constraint fk_dependenciasPeriodo_period_01 foreign key (periodo) references periodo (id) on delete restrict on update restrict;

alter table dependenciasPeriodo add constraint fk_dependenciasPeriodo_discip_02 foreign key (disciplinas) references disciplina (id) on delete restrict on update restrict;

alter table planejador_periodo add constraint fk_planejador_periodo_planeja_01 foreign key (planejador_id) references planejador (id) on delete restrict on update restrict;

alter table planejador_periodo add constraint fk_planejador_periodo_periodo_02 foreign key (periodo_id) references periodo (id) on delete restrict on update restrict;

alter table planejador_disciplina add constraint fk_planejador_disciplina_plan_01 foreign key (planejador_id) references planejador (id) on delete restrict on update restrict;

alter table planejador_disciplina add constraint fk_planejador_disciplina_disc_02 foreign key (disciplina_id) references disciplina (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists aluno;

drop table if exists disciplina;

drop table if exists dependencias;

drop table if exists periodo;

drop table if exists dependenciasPeriodo;

drop table if exists planejador;

drop table if exists planejador_periodo;

drop table if exists planejador_disciplina;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists aluno_seq;

drop sequence if exists disciplina_seq;

drop sequence if exists periodo_seq;

drop sequence if exists planejador_seq;

