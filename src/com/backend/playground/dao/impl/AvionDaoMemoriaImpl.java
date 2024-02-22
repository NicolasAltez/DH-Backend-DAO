package com.backend.playground.dao.impl;

import com.backend.playground.dao.IDao;
import com.backend.playground.entity.Avion;

import java.sql.SQLException;
import java.util.List;

public class AvionDaoMemoriaImpl implements IDao<Avion> {

    //TODO AVIONES ES LA LISTA DE AVIONES QUE SE VA A UTILIZAR PARA SIMULAR LA BASE DE DATOS
    private final List<Avion> aviones;

    public AvionDaoMemoriaImpl(List<Avion> aviones) {
        this.aviones = aviones;
    }

    @Override
    public Avion registar(Avion avion) throws SQLException {
        //TODO AGREGAR EL AVION QUE LLEGA POR PARAMETRO A LA LISTA DE AVIONES
        aviones.add(avion);
        //TODO RETORNAR EL AVION QUE SE ACABA DE AGREGAR A LA LISTA
        return avion;
    }

    @Override
    public Avion buscarPorId(int id) {
        //TODO DEFINIMOS UNA VARIABLE AVIONBUSCADO QUE INICIA EN NULL
        Avion avionBuscado = null;

        //TODO RECORREMOS LA LISTA DE AVIONES Y COMPARAMOS EL ID DE CADA AVION CON EL ID QUE LLEGA POR PARAMETRO
        //TODO SI ENCONTRAMOS EL AVION CON EL ID QUE BUSCAMOS, LO ASIGNAMOS A LA VARIABLE AVIONBUSCADO Y ROMPEMOS EL CICLO
        //TODO SI NO ENCONTRAMOS EL AVION CON EL ID QUE BUSCAMOS, AVIONBUSCADO SIGUE SIENDO NULL
        //TODO AL FINAL RETORNAMOS AVIONBUSCADO
        for (Avion avion : aviones) {
            if (avion.getId() == id) {
                avionBuscado = avion;
                break;
            }
        }
        return avionBuscado;
    }

    @Override
    public void eliminarPorId(int id) {
        //TODO CREAMOS UNA VARIABLE AVIONAELIMINAR QUE VA A SER EL RESULTADO DE LLAMAR buscarPorId(id)
        Avion avionAEliminar = buscarPorId(id);
        //TODO REMOVEMOS EL AVION QUE ENCONTRAMOS DE LA LISTA DE AVIONES CON EL METODO REMOVE
        aviones.remove(avionAEliminar);
    }

    @Override
    public List<Avion> buscarTodos() {
        //TODO RETORNAMOS LA LISTA DE AVIONES QUE SIMULA TENER TODOS LOS AVIONES DE LA BASE DE DATOS
        return aviones;
    }
}
