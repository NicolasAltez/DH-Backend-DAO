DROP TABLE IF EXISTS AVIONES; CREATE TABLE AVIONES(ID INT AUTO_INCREMENT PRIMARY KEY, MARCA VARCHAR(255) NOT NULL, MODELO VARCHAR(255) NOT NULL, MATRICULA VARCHAR(255) NOT NULL, FECHA_ENTRADA_SERVICIO DATE NOT NULL);


INSERT INTO AVIONES(MARCA, MODELO, MATRICULA, FECHA_ENTRADA_SERVICIO) VALUES('Boeing', '747', 'EC-1234', '2019-01-01');
INSERT INTO AVIONES(MARCA, MODELO, MATRICULA, FECHA_ENTRADA_SERVICIO) VALUES('Airbus', 'A320', 'EC-5678', '2019-01-01');