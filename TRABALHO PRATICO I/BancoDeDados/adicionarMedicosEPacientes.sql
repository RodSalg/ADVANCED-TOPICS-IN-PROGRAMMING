select *from dados_medicos; /* mostrar toda a tabela */

insert into dados_medicos values (NULL, "Pio", "Chefe Cirurgiao", 10, 19);
insert into dados_medicos values (NULL, "Nakamura", "Otorrino", 10, 19);
insert into dados_medicos values (NULL, "Eduardo Lazueiro", "Ortopedista", 10, 19);

select *from dados_medicos; /* mostrar toda a tabela com os novos medicos */


select *from dados_pacientes; /* mostrar toda a tabela */

insert into dados_pacientes values (NULL, "Ines Padilha", 35, "A+", "Medico Geral", 15, "Febre, tosse, garganta seca");
insert into dados_pacientes values (NULL, "Disney", 49, "B+", "Ortopedista", 13, "torceu o tornozelo");
insert into dados_pacientes values (NULL, "Darth Vader", 35, "A+", "Cardiologista", 15, "Coracao Frio");

select *from dados_pacientes; /* mostrar toda a tabela com os novos pacientes */
