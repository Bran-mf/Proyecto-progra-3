/*
Created: 30/8/2019
Modified: 17/9/2019
Model: Oracle 11g Release 2
Database: Oracle 11g Release 2
*/


-- Create sequences section -------------------------------------------------

CREATE SEQUENCE ReporteCitaSeq
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 MINVALUE 1
 NOCACHE
;

CREATE SEQUENCE ExpedienteSeq
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 MINVALUE 1
 NOCACHE
;

CREATE SEQUENCE AntecedentesSeq
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 MINVALUE 1
 NOCACHE
;

CREATE SEQUENCE CitasIdSeq
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 MINVALUE 1
 NOCACHE
;

CREATE SEQUENCE ExamenIdSeq
 INCREMENT BY 1
 START WITH 1
 NOMAXVALUE
 MINVALUE 1
 NOCACHE
;

-- Create tables section -------------------------------------------------

-- Table cu_Usuarios

CREATE TABLE cu_Usuarios(
  usu_Nombre Varchar2(30 ) NOT NULL,
  usu_Apellido Varchar2(30 ) NOT NULL,
  usu_Cedula Varchar2(15 ) NOT NULL,
  usu_Correo Varchar2(50 ) NOT NULL,
  usu_Tipo Varchar2(1 ) NOT NULL
        CONSTRAINT CK_USUARIOS_TIPO CHECK (usu_Tipo IN ('M', 'A', 'R')),
  usu_Idioma Varchar2(1 ) NOT NULL
        CONSTRAINT CK_USUARIOS_IDIOMA CHECK (usu_Idioma IN ('1', '0')),
  usu_Estado Varchar2(1 ) NOT NULL
        CONSTRAINT CK_USUARIOS_ESTADO CHECK (usu_Estado IN ('A', 'I')),
  usu_Usuario Varchar2(30 ) NOT NULL,
  usu_Contrasena Varchar2(30 ) NOT NULL,
  usu_Version Number DEFAULT 1,
  usu_Temp Varchar2(1 ) NOT NULL
        CONSTRAINT CK_USUARIO_TEMP CHECK (usu_Temp IN ('S', 'N')),
  usu_CodAct Varchar2(30)	
)
;

-- Add keys for table cu_Usuarios

ALTER TABLE cu_Usuarios ADD CONSTRAINT PK_cu_Usuarios PRIMARY KEY (usu_Cedula)
;


-- Table and Columns comments section

COMMENT ON COLUMN cu_Usuarios.usu_Nombre IS 'Nombre del usuario

'
;
COMMENT ON COLUMN cu_Usuarios.usu_Apellido IS 'Apellido del usuario'
;
COMMENT ON COLUMN cu_Usuarios.usu_Cedula IS 'Cedula de usuario
'
;
COMMENT ON COLUMN cu_Usuarios.usu_Correo IS 'Correo de usuario
'
;
COMMENT ON COLUMN cu_Usuarios.usu_Tipo IS 'Tipo de usuario: Medico, Administrador o Recepcionista'
;
COMMENT ON COLUMN cu_Usuarios.usu_Idioma IS 'Idioma de la aplicacion'
;
COMMENT ON COLUMN cu_Usuarios.usu_Estado IS 'Estado: Activo o Inactivo'
;
COMMENT ON COLUMN cu_Usuarios.usu_Usuario IS 'Nombre de usuario del usuario'
;
COMMENT ON COLUMN cu_Usuarios.usu_Contrasena IS 'Clave del usuario'
;
COMMENT ON COLUMN cu_Usuarios.usu_Temp IS 'Guarda S si la contraseña es temporal'
;

-- Table cu_Medicos

CREATE TABLE cu_Medicos(
  med_Folio Varchar2(30 ) NOT NULL,
  med_Codigo Varchar2(30 ) NOT NULL,
  med_Cerne Varchar2(30 ) NOT NULL,
  med_Estado Varchar2(1 ) NOT NULL
        CONSTRAINT CK_MEDICO_ESTADO CHECK (med_Estado in ('A', 'I')),
  med_Inicio Varchar2(5 ) NOT NULL,
  med_Final Varchar2(5 ) NOT NULL,
  med_Espacios Varchar2(1 ) NOT NULL
        CONSTRAINT CK_MEDICO_ESPACIOS CHECK (med_Espacios in ('1', '2', '3', '4')),
  usu_Cedula Varchar2(15 ) NOT NULL,
  med_Version Number DEFAULT 1
)
;

-- Add keys for table cu_Medicos

ALTER TABLE cu_Medicos ADD CONSTRAINT PK_cu_Medicos PRIMARY KEY (med_Folio)
;

ALTER TABLE cu_Medicos ADD CONSTRAINT med_Codigo UNIQUE (med_Codigo)
;

ALTER TABLE cu_Medicos ADD CONSTRAINT med_Cerne UNIQUE (med_Cerne)
;


-- Table and Columns comments section

COMMENT ON COLUMN cu_Medicos.med_Folio IS 'Folio del medico'
;
COMMENT ON COLUMN cu_Medicos.med_Codigo IS 'Codigo de medico'
;
COMMENT ON COLUMN cu_Medicos.med_Cerne IS 'Carne del medico'
;
COMMENT ON COLUMN cu_Medicos.med_Estado IS 'Estado activo o inactivo
'
;
COMMENT ON COLUMN cu_Medicos.med_Inicio IS 'Hora de Inicio de labor'
;
COMMENT ON COLUMN cu_Medicos.med_Final IS 'Hora de final de labor'
;
COMMENT ON COLUMN cu_Medicos.med_Espacios IS 'Cantidad de espacios por hora'
;
COMMENT ON COLUMN cu_Medicos.usu_Cedula IS 'llave foranea con usuario'
;

-- Table cu_Pacientes

CREATE TABLE cu_Pacientes(
  pac_Nombre Varchar2(30 ) NOT NULL,
  pac_Apellido Varchar2(30 ) NOT NULL,
  pac_Cedula Varchar2(30 ) NOT NULL,
  pac_Correo Varchar2(30 ) NOT NULL,
  pac_Genero Varchar2(1 ) NOT NULL
        CONSTRAINT CK_PACIENTE_GENERO CHECK (pac_Genero IN ('H', 'M')),
  pac_Nacimiento Date NOT NULL,
  pac_Version Number DEFAULT 1
)
;

-- Add keys for table cu_Pacientes

ALTER TABLE cu_Pacientes ADD CONSTRAINT PK_cu_Pacientes PRIMARY KEY (pac_Cedula)
;

-- Table and Columns comments section

COMMENT ON COLUMN cu_Pacientes.pac_Nombre IS 'Nombre del paciente'
;
COMMENT ON COLUMN cu_Pacientes.pac_Apellido IS 'Apellido del paciente'
;
COMMENT ON COLUMN cu_Pacientes.pac_Cedula IS 'Cedula del Paciente'
;
COMMENT ON COLUMN cu_Pacientes.pac_Correo IS 'Correo del Paciente'
;
COMMENT ON COLUMN cu_Pacientes.pac_Genero IS 'Genero del paciente
'
;
COMMENT ON COLUMN cu_Pacientes.pac_Nacimiento IS 'Fecha de nacimiento
'
;

-- Table cu_Citas

CREATE TABLE cu_Citas(
  cit_Estado Varchar2(1 ) NOT NULL
        CONSTRAINT CK_CITAS_ESTADO CHECK (cit_Estado IN ('A', 'U', 'P', 'C')),
  cit_Motivo Varchar2(500 ),
  cit_Telefono Varchar2(8 ) NOT NULL,
  cit_Correo Varchar2(50 ) NOT NULL,
  pac_Cedula Varchar2(30 ) NOT NULL,
  usu_Cedula Varchar2(15 ) NOT NULL,
  cit_Version Number DEFAULT 1,
  med_Folio Varchar2(30 ) NOT NULL,
  cit_fecha Date NOT NULL,
  cit_Hora Varchar2(5 ) NOT NULL,
  cit_Espacios Varchar2(1 ) NOT NULL
        CONSTRAINT CK_CITAS_ESPACIOS CHECK (cit_Espacios IN ('1', '2', '3', '4')),
  cit_Id Number NOT NULL
)
;

-- Add keys for table cu_Citas

ALTER TABLE cu_Citas ADD CONSTRAINT PK_cu_Citas PRIMARY KEY (cit_Id)
;


-- Table and Columns comments section

COMMENT ON COLUMN cu_Citas.cit_Estado IS 'Estado de la cita: Programada (P), Atendida (A), Cancelada (C) y Ausente(U)'
;
COMMENT ON COLUMN cu_Citas.cit_Motivo IS 'Motivo de la cita
'
;
COMMENT ON COLUMN cu_Citas.cit_Telefono IS 'Telefono con quien registro la cita'
;
COMMENT ON COLUMN cu_Citas.cit_Correo IS 'Correo con que registro la cita'
;
COMMENT ON COLUMN cu_Citas.cit_fecha IS 'fecha de la cita'
;
COMMENT ON COLUMN cu_Citas.cit_Hora IS 'Hora de la cita'
;
COMMENT ON COLUMN cu_Citas.cit_Espacios IS 'Espacios de la cita'
;

-- Table cu_Expediente

CREATE TABLE cu_Expediente(
  exp_Id Number NOT NULL,
  pac_Cedula Varchar2(30 ) NOT NULL
)
;

-- Add keys for table cu_Expediente

ALTER TABLE cu_Expediente ADD CONSTRAINT PK_cu_Expediente PRIMARY KEY (exp_Id)
;


-- Table and Columns comments section

COMMENT ON COLUMN cu_Expediente.exp_Id IS 'Numero de expediente'
;

-- Table cu_Antecedentes

CREATE TABLE cu_Antecedentes(
  ant_Tipo Varchar2(30 ) NOT NULL,
  ant_Tratamiento Varchar2(30 ),
  ant_Heredado Number DEFAULT 0,
  ant_Parentesco Varchar2(30 ),
  ant_Enfermedad Varchar2(30 ),
  ant_Version Number DEFAULT 1,
  exp_Id Number NOT NULL,
  ant_Id Number NOT NULL
)
;

-- Add keys for table cu_Antecedentes

ALTER TABLE cu_Antecedentes ADD CONSTRAINT PK_cu_Antecedentes PRIMARY KEY (ant_Id)
;


-- Table and Columns comments section

COMMENT ON COLUMN cu_Antecedentes.ant_Tipo IS 'Tipo de antecedente'
;
COMMENT ON COLUMN cu_Antecedentes.ant_Heredado IS 'Hetrtedado 0 no 1 si'
;
COMMENT ON COLUMN cu_Antecedentes.ant_Parentesco IS 'Parentesco de la persona que heredo la enfermedad'
;
COMMENT ON COLUMN cu_Antecedentes.ant_Enfermedad IS 'El transtorno heredado'
;

-- Table cu_reporteCita

CREATE TABLE cu_reporteCita(
  rc_fecha Date NOT NULL,
  rc_Id Number NOT NULL,
  rc_hora Varchar2(5 ),
  rc_Presion Varchar2(7 ),
  rc_peso Number,
  rc_Talla Varchar2(3 ),
  rc_temperatura Varchar2(2 ),
  rc_IMC Number,
  rc_NotasEnfermeria Varchar2(1000 ),
  rc_Razon Varchar2(100 ),
  rc_Observaciones Varchar2(1000 ),
  exp_Id Number NOT NULL,
  rc_plan Varchar2(1000 ),
  rc_examen Varchar2(500 ),
  rc_tratamiento Varchar2(500 ),
  rc_Version Number DEFAULT 1,
  rc_FrecCard Varchar2(10)
)
;

-- Add keys for table cu_reporteCita

ALTER TABLE cu_reporteCita ADD CONSTRAINT PK_cu_reporteCita PRIMARY KEY (rc_Id)
;


-- Table and Columns comments section

COMMENT ON COLUMN cu_reporteCita.rc_Presion IS 'Presion alerial'
;
COMMENT ON COLUMN cu_reporteCita.rc_Razon IS 'Razo de porque la cunsulta'
;
COMMENT ON COLUMN cu_reporteCita.rc_Observaciones IS 'Obsrvaciones del doctor'
;
COMMENT ON COLUMN cu_reporteCita.rc_plan IS 'El plan de atencion que se le dará la paciente'
;
COMMENT ON COLUMN cu_reporteCita.rc_examen IS 'Detalle del examen fisico que se le hizo al paciente'
;
COMMENT ON COLUMN cu_reporteCita.rc_tratamiento IS 'Detalle del tratamineto que se le dara el paciente
'
;

-- Table cu_examen

CREATE TABLE cu_examen(
  exa_id Number NOT NULL,
  exa_fecha Date,
  exa_nombre Varchar2(30 ),
  exa_Anotacones Varchar2(500 ),
  exa_adjunto Varchar2(100 ),
  exa_Version Number DEFAULT 1,
  exp_Id Number NOT NULL
)
;

-- Add keys for table cu_examen

ALTER TABLE cu_examen ADD CONSTRAINT PK_cu_examen PRIMARY KEY (exa_id)
;


-- Table and Columns comments section

COMMENT ON COLUMN cu_examen.exa_nombre IS 'Nombre del examen'
;
COMMENT ON COLUMN cu_examen.exa_Anotacones IS 'Anotaciones para el medico'
;
COMMENT ON COLUMN cu_examen.exa_adjunto IS 'archivo asjunto al examen'
;

-- Trigger for sequence CitasIdSeq for column cit_Id in table cu_Citas ---------
CREATE OR REPLACE TRIGGER ts_cu_Citas_CitasIdSeq BEFORE INSERT
ON cu_Citas FOR EACH ROW
BEGIN
	if :new.cit_Id is null then
		:new.cit_Id := CitasIdSeq.nextval;
	end if;
END;
/
CREATE OR REPLACE TRIGGER tsu_cu_Citas_CitasIdSeq AFTER UPDATE OF cit_Id
ON cu_Citas FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column cit_Id in table cu_Citas as it uses sequence.');
END;
/

-- Trigger for sequence ExpedienteSeq for column exp_Id in table cu_Expediente ---------
CREATE OR REPLACE TRIGGER ts_cu_Expediente_ExpedienteSeq BEFORE INSERT
ON cu_Expediente FOR EACH ROW
BEGIN
	if :new.exp_Id is null then
		:new.exp_Id := ExpedienteSeq.nextval;
	end if;
END;
/
CREATE OR REPLACE TRIGGER tsu_cu_Expediente_Expediente_0 AFTER UPDATE OF exp_Id
ON cu_Expediente FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column exp_Id in table cu_Expediente as it uses sequence.');
END;
/

-- Trigger for sequence AntecedentesSeq for column ant_Id in table cu_Antecedentes ---------
CREATE OR REPLACE TRIGGER ts_cu_Antecedentes_Anteceden_7 BEFORE INSERT
ON cu_Antecedentes FOR EACH ROW
BEGIN
	if :new.ant_Id is null then
		:new.ant_Id := AntecedentesSeq.nextval;
	end if;
END;
/
CREATE OR REPLACE TRIGGER tsu_cu_Antecedentes_Antecede_7 AFTER UPDATE OF ant_Id
ON cu_Antecedentes FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column ant_Id in table cu_Antecedentes as it uses sequence.');
END;
/

-- Trigger for sequence ExamenIdSeq for column exa_id in table cu_examen ---------
CREATE OR REPLACE TRIGGER ts_cu_examen_ExamenIdSeq BEFORE INSERT
ON cu_examen FOR EACH ROW
BEGIN
	if :new.exa_id is null then
		:new.exa_id := ExamenIdSeq.nextval;
	end if;
END;
/
CREATE OR REPLACE TRIGGER tsu_cu_examen_ExamenIdSeq AFTER UPDATE OF exa_id
ON cu_examen FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column exa_id in table cu_examen as it uses sequence.');
END;
/


-- Create foreign keys (relationships) section ------------------------------------------------- 

ALTER TABLE cu_Medicos ADD CONSTRAINT rel_usu_med FOREIGN KEY (usu_Cedula) REFERENCES cu_Usuarios (usu_Cedula)
;


ALTER TABLE cu_Citas ADD CONSTRAINT rel_pac_cit FOREIGN KEY (pac_Cedula) REFERENCES cu_Pacientes (pac_Cedula)
;


ALTER TABLE cu_Citas ADD CONSTRAINT rel_usu_cit FOREIGN KEY (usu_Cedula) REFERENCES cu_Usuarios (usu_Cedula)
;


ALTER TABLE cu_Expediente ADD CONSTRAINT rel_pac_exp FOREIGN KEY (pac_Cedula) REFERENCES cu_Pacientes (pac_Cedula)
;


ALTER TABLE cu_Citas ADD CONSTRAINT rel_med_cit FOREIGN KEY (med_Folio) REFERENCES cu_Medicos (med_Folio)
;


ALTER TABLE cu_Antecedentes ADD CONSTRAINT rel_exp_ant FOREIGN KEY (exp_Id) REFERENCES cu_Expediente (exp_Id)
;


ALTER TABLE cu_reporteCita ADD CONSTRAINT rel_exp_rc FOREIGN KEY (exp_Id) REFERENCES cu_Expediente (exp_Id)
;


ALTER TABLE cu_examen ADD CONSTRAINT rel_exp_exa FOREIGN KEY (exp_Id) REFERENCES cu_Expediente (exp_Id)
;





