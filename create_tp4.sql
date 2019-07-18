USE BDD_DEMO
GO

CREATE TABLE repas(
	id_repas int IDENTITY(1,1) NOT NULL,
	date date NOT NULL,
	heure time NOT NULL,
 CONSTRAINT PK_REPAS PRIMARY KEY CLUSTERED 
(id_repas ASC)
)

GO


CREATE TABLE aliment(
	id_aliment int IDENTITY(1,1) NOT NULL,
	libelle varchar(24) NOT NULL,

 CONSTRAINT PK_aliment PRIMARY KEY CLUSTERED 
(
	id_aliment ASC
)
) 

GO


CREATE TABLE repas_aliment(
	id_aliment int NOT NULL  CONSTRAINT FK_repas_aliment__ID_aliment FOREIGN KEY (id_aliment) REFERENCES aliment,
	id_repas int NOT NULL  CONSTRAINT FK_repas_aliment__ID_repas FOREIGN KEY (id_repas) REFERENCES repas,
	 CONSTRAINT PK_repas_aliment PRIMARY KEY (id_aliment, id_repas)
	 )
GO


