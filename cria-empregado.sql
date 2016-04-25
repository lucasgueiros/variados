

begin;

/* Cria a tabela EMPREGADO */
CREATE TABLE EMPREGADO (
  NOMINIC      VARCHAR(8)         NOT NULL,
  nomint       char(1),
  NOMEFIM      VARCHAR(8)         NOT NULL,
  NUMAT        char(4)            NOT NULL,
  DTNASC       DATE,
  ENDER        VARCHAR(12),
  SEXO         CHAR(1),
  SALARIO      numeric(6,2),
  NSUPER       char(4),
  NDEPTO       smallint          DEFAULT 1 NOT NULL,
  PRIMARY KEY  (NUMAT)
);

/* Cria a tabela DEPARTAMENTO */
CREATE TABLE DEPARTAMENTO (
  NOMEDEP      VARCHAR(15)      NOT NULL,
  NUMDEP       smallint         NOT NULL,
  NCHEFE       char(4)          DEFAULT '8886' NOT NULL,
  DTINCHEF     DATE,
  PRIMARY KEY  (NUMDEP),
  UNIQUE       (NOMEDEP)
);

/* Cria a tabela LOCALDEPTO */
CREATE TABLE LOCALDEPTO (
  NUMDEP       smallint          NOT NULL,
  LOCDEP       VARCHAR(15)       NOT NULL,
  PRIMARY KEY  (NUMDEP, LOCDEP)
);

/* Cria a tabela PROJETO */
CREATE TABLE PROJETO (
  NOMEPROJ     VARCHAR(20)    NOT NULL,
  NUMPROJ      INT            NOT NULL,
  LOCPROJ      VARCHAR(15)    NOT NULL,
  NUMDEP       smallint       NOT NULL,
  PRIMARY KEY  (NUMPROJ),
  UNIQUE       (NOMEPROJ)
);

/* Cria a tabela TRABALHAEM */
CREATE TABLE TRABALHAEM (
  NUMEMP       char(4)       NOT NULL,
  NPROJ        INT           NOT NULL,
  HORAS        DECIMAL(3,1),
  PRIMARY KEY  (NUMEMP, NPROJ)
);

/* Cria a tabela DEPENDENTE */
CREATE TABLE DEPENDENTE (
  NUMEMP       char(4)          NOT NULL,
  DEPEND       VARCHAR(15)         NOT NULL,
  SEXO         CHAR(1),
  DTNASC       DATE,
  TIPO         varchar(8),
  PRIMARY KEY  (NUMEMP, DEPEND)
);
commit;
