DROP TABLE EMPLOYEES;

CREATE TABLE "EMPLOYEES" (
	"ID" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	"NAME" VARCHAR(25) NOT NULL,
	"FIRSTNAME" VARCHAR(25) NOT NULL,
	"TELHOME" VARCHAR(10) NOT NULL,
	"TELMOB" VARCHAR(10) NOT NULL,
	"TELPRO" VARCHAR(10) NOT NULL,
	"ADRESS" VARCHAR(150) NOT NULL,
	"POSTALCODE" VARCHAR(5) NOT NULL,
	"CITY" VARCHAR(25) NOT NULL,
	"EMAIL" VARCHAR(25) NOT NULL,
	CONSTRAINT primary_key_membre PRIMARY KEY (ID)
);

INSERT INTO EMPLOYEES(NAME,FIRSTNAME,TELHOME,TELMOB,TELPRO,ADRESS,POSTALCODE,CITY,EMAIL) VALUES
('Simpson','Homer','0123456789','0612345678','0698765432','2 avenue Duff','92700','Colombes','hsimpson@gmail.com'),
('Simpson','Bart','0145362787','0645362718','0611563477','10 rue des Rebelles','92270','Bois-colombes','bsimpson@gmail.com'),
('Lagaffe','Gaston','0187665987','0623334256','0654778654','65 rue de la Paresse','92700','Colombes','glagaffe@yahoo.fr'),
('Woodpecker','Woody','0187384987','0622494256','0674178654','5 bvd des Picoreurs','21000','Dijon','woody@mail.co.uk'),
('Brown','Charlie','0122456678','0699854673','0623445166','140 avenue Foche','90000','Nanterre','cbrown@live.com'),
('Billes','Guillaume','0102030405','0607080909','0606060606','1 rue de la rue','75000','Paris','bg@efrei.net'),
('Farge','Guillaume','0102030405','0607080909','0606060606','88 avenue Julien Lepers','88888','Une ville','fg@efrei.net'),
('Huang','Claire','0102030405','0607080909','0606060606','11 rue de la mer','12345','La mer sur mer','hc@efrei.net'),
('Wolf','Morgan','0102030405','0607080909','0606060606','44 rue des loups','98765','Saint Jean de Jeanine','wm@efrei.net'),
('Roche','Vincent','0102030405','0607080909','0606060606','77 avenue soixante-dix-sept','43210','La Maison sainte gare','rv@efrei.net');


DROP TABLE CREDENTIALS;

CREATE TABLE "CREDENTIALS" (
"ID" INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	"LOGIN" VARCHAR(25) NOT NULL,
	"PASSWORD" VARCHAR(25) NOT NULL,
	CONSTRAINT primary_key_credentials PRIMARY KEY (ID)
);

INSERT INTO CREDENTIALS(LOGIN,PASSWORD) VALUES('admin','admin');