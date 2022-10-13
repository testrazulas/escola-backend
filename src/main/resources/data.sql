
insert into USUARIO (ID, EMAIL, NOME, SENHA) values (1, 'professor@email.com', 'Fulano', '123456')

insert into TURMA (ID, DATA_CRIACAO, NIVEL, TITULO, USUARIO_ID) values (1, '2015-01-10', 'Primeiro Ano - Ensino Médio', 'Sala 1', 1)
insert into TURMA (ID, DATA_CRIACAO, NIVEL, TITULO, USUARIO_ID) values (2, '2016-02-20', 'Segundo Ano - Ensino Médio', 'Sala 2', 1)
insert into TURMA (ID, DATA_CRIACAO, NIVEL, TITULO, USUARIO_ID) values (3,'2014-01-20', 'Nono Ano - Ensino Fundamental', 'Sala 3', 1)


insert into ESTUDANTE (ID, DATA_MATRICULA, IDADE, NOME, SEXO, STATUS, TURMA_ID) values (1, '2022-02-01', 15, 'Tiago Severo', 'M', 'MATRICULADO', 1)
insert into ESTUDANTE (ID, DATA_MATRICULA, IDADE, NOME, SEXO, STATUS, TURMA_ID) values (2, '2021-10-01', 16, 'Ticiany', 'F', 'MATRICULADO', 2)
insert into ESTUDANTE (ID, DATA_MATRICULA, IDADE, NOME, SEXO, STATUS, TURMA_ID) values (3, '2022-01-15', 14, 'Joao', 'M', 'MATRICULADO', 3)



