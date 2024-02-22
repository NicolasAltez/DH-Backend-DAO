package com.backend.playground.dao.impl;

import com.backend.playground.dao.IDao;
import com.backend.playground.db.H2Conexion;
import com.backend.playground.entity.Avion;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvionDaoH2Impl implements IDao<Avion> {

    //TODO CONSTANTE LOGGER
    private final Logger LOGGER = Logger.getLogger(AvionDaoH2Impl.class);

    @Override
    public Avion registar(Avion avion) throws SQLException {
        Connection connection = null;
        Avion avionRegistrado = null;

        try {
            //TODO CONEXION A LA BASE DE DATOS
            connection = H2Conexion.getConnection();
            connection.setAutoCommit(false);

            //TODO SENTENCIA SQL PARA INSERTAR UN AVION EN LA BASE DE DATOS
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO AVIONES (marca, modelo, matricula, fecha_entrada_servicio) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, avion.getMarca());
            preparedStatement.setString(2, avion.getModelo());
            preparedStatement.setString(3, avion.getMatricula());
            preparedStatement.setDate(4, Date.valueOf(avion.getFechaEntradaServicio()));

            //TODO EJECUCION DE LA SENTENCIA SQL
            preparedStatement.execute();

            //TODO CONFIRMACION DE LA TRANSACCION
            connection.commit();

            //TODO OBTENCION DE LA CLAVE GENERADA POR LA BASE DE DATOS
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            //TODO OBTENCION DE LOS DATOS DEL AVION REGISTRADO EN LA BASE DE DATOS
            while (resultSet.next()) {
                avionRegistrado = new Avion(resultSet.getInt(1), avion.getMarca(), avion.getModelo(), avion.getMatricula(), avion.getFechaEntradaServicio());
            }

            //TODO MENSAJE LOG DE CONFIRMACION
            LOGGER.info("Avion registrado con exito : " + avionRegistrado);

            //TODO MANEJO DE EXCEPCIONES EN CASO DE ERROR
        } catch (Exception e) {
            LOGGER.error(e.getMessage());

            //TODO VERIFICACION DE QUE EXISTA UNA CONEXION ABIERTA
            if (connection != null) {

                //TODO ROLLBACK DE LA TRANSACCION EN CASO DE ERROR
                try {
                    connection.rollback();
                    LOGGER.info("Se hizo rollback de la transaccion");
                } catch (SQLException ex) {
                    LOGGER.error(ex.getMessage());
                }
            }

            //TODO CIERRE DE LA CONEXION A LA BASE DE DATOS
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }

        }
        //TODO RETORNO DEL AVION REGISTRADO
        return avionRegistrado;
    }

    @Override
    public Avion buscarPorId(int id) {
        Connection connection = null;
        Avion avionEncontrado = null;

        try {
            connection = H2Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM AVIONES WHERE id = ?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                avionEncontrado = new Avion(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDate(5).toLocalDate());
                LOGGER.info("Avion encontrado con exito : " + avionEncontrado);
            }


        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
        return avionEncontrado;
    }

    @Override
    public void eliminarPorId(int id) {
        Connection connection = null;
        try {
            connection = H2Conexion.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM AVIONES WHERE id = ?");
            preparedStatement.setInt(1, id);
            connection.commit();

            LOGGER.info("El avion con id " + id + " fue eliminado con exito.");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            if (connection != null) {
                try {
                    connection.rollback();
                    LOGGER.info("Se hizo un rollback de la transaccion");
                } catch (SQLException ex) {
                    LOGGER.error(ex.getMessage());
                } finally {
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (SQLException exception) {
                            LOGGER.error(exception.getMessage());
                        }
                    }
                }
            }
        }
    }

    @Override
    public List<Avion> buscarTodos() {
        Connection connection = null;
        List<Avion> avionesEncontrados = new ArrayList<>();
        try{
            connection = H2Conexion.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM AVIONES");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Avion avion = new Avion(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDate(5).toLocalDate());
                avionesEncontrados.add(avion);
            }

            LOGGER.info("Aviones encontrados con exito : " + avionesEncontrados);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
        return avionesEncontrados;
    }
}
