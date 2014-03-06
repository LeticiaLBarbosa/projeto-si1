# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table aluno (
  id                        bigint not null,
  constraint pk_aluno primary key (id))
;

create sequence aluno_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists aluno;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists aluno_seq;

