package com.backend.playground.services;

import com.backend.playground.dao.IDao;
import com.backend.playground.entity.Avion;

import java.sql.SQLException;
import java.util.List;

public class AvionService {

    //TODO ESTO ES UN SERVICE , ES UNA CLASE QUE SE ENCARGA DE MANEJAR LA LOGICA DE NEGOCIO DE UNA ENTIDAD
    private IDao<Avion> avionIDao;

    //TODO ESTE ES EL CONSTRUCTOR DE LA CLASE AVIONSERVICE SIRVE PARA INICIALIZAR EL ATRIBUTO AVIONIDAO
    public AvionService(IDao<Avion> avionIDao) {
        this.avionIDao = avionIDao;
    }


    //TODO ESTE METODO SIRVE PARA REGISTRAR UN AVION Y RETORNA EL RESULTADO DEL METODO REGISTRAR
    public Avion registrarAvion(Avion avion) throws SQLException {
        return avionIDao.registar(avion);
    }


    //TODO ESTE METODO SIRVE PARA BUSCAR UN AVION POR ID Y RETORNA EL RESULTADO DEL METODO BUSCARPORID
    public Avion buscarAvionPorId(int id) {
        return avionIDao.buscarPorId(id);
    }

    //TODO ESTE METODO SIRVE PARA ELIMINAR UN AVION POR ID Y NO RETORNA NADA
    public void eliminarAvionPorId(int id) {
        avionIDao.eliminarPorId(id);
    }

    //TODO CUANDO TRABAJAMOS CON UNA OPERACION QUE NOS PUEDE RETORNAR VARIOS REGISTROS, ES BUENA PRACTICA RETORNAR UNA LISTA
    public List<Avion> buscarTodosLosAviones() {
        return avionIDao.buscarTodos();
    }
}
