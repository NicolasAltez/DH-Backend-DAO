package com.backend.playground.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Conexion {

    // TODO ESTE METODO ES EL QUE SE DEBE USAR PARA CONECTARSE A LA BASE DE DATOS
    //TODO INIT=RUNSCRIPT FROM 'create.sql' -> Este parametro es para que se ejecute el script de creacion de la base de datos
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:mem:testdb;INIT=RUNSCRIPT FROM 'create.sql'", "user", "password");
    }

}
