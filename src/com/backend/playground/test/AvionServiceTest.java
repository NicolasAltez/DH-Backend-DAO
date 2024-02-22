package com.backend.playground.test;

import com.backend.playground.dao.impl.AvionDaoH2Impl;
import com.backend.playground.dao.impl.AvionDaoMemoriaImpl;
import com.backend.playground.entity.Avion;
import com.backend.playground.services.AvionService;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AvionServiceTest {

    private AvionService avionService;

    @Test
    public void registrarAvion() throws SQLException {
        //TODO INICIALIZAMOS EL SERVICIO CON UNA IMPLEMENTACION DE DAO H2
        avionService = new AvionService(new AvionDaoH2Impl());

        //TODO CREAMOS UN AVION, QUE VA A SER ENVIADO COMO PARAMETRO AL METODO REGISTRAR AVION
        Avion avion = new Avion("PEPITO", "747", "LV-BFR", LocalDate.now());

        //TODO CREAMOS UNA VARIABLE AL CUAL LE ASIGNAMOS EL VALOR DEL RESULTADO DE LLAMAR avionService.registrarAvion(avion)
        Avion avionRegistrado = avionService.registrarAvion(avion);

        //TODO VERIFICAMOS QUE EL AVION REGISTRADO NO SEA NULO
        assertNotNull(avionRegistrado);

        //TODO VERIFICAMOS QUE LOS ATRIBUTOS DEL AVION REGISTRADO SEAN IGUALES A LOS ATRIBUTOS DEL AVION QUE REGISTRAMOS
        assertEquals(avion.getMarca(), avionRegistrado.getMarca());
        assertEquals(avion.getModelo(), avionRegistrado.getModelo());
        assertEquals(avion.getMatricula(), avionRegistrado.getMatricula());
        assertEquals(avion.getFechaEntradaServicio(), avionRegistrado.getFechaEntradaServicio());
    }

    @Test
    public void buscarTodosLosAviones(){
        //TODO INICIALIZAMOS EL SERVICIO CON UNA IMPLEMENTACION DE DAO H2
        avionService = new AvionService(new AvionDaoH2Impl());

        //TODO CREAMOS UNA LISTA DE AVIONES, QUE VA A SER EL RESULTADO DE LLAMAR avionService.buscarTodosLosAviones()
        List<Avion> listaDeAviones = avionService.buscarTodosLosAviones();

        //TODO VERIFICAMOS QUE LA LISTA DE AVIONES NO SEA NULA
        assertNotNull(listaDeAviones);

        //TODO VERIFICAMOS QUE LA LISTA DE AVIONES TENGA 2 ELEMENTOS, PREVIAMENTE INGRESADOS EN EL SCRIPT create.sql
        assertEquals(2, listaDeAviones.size());
    }

    @Test
    public void buscarAvionPorId(){
        //TODO INICIALIZAMOS EL SERVICIO CON UNA IMPLEMENTACION DE DAO H2
        avionService = new AvionService(new AvionDaoH2Impl());

        //TODO CREAMOS UN AVION, QUE VA A SER EL RESULTADO DE LLAMAR avionService.buscarAvionPorId(1)
        Avion avion = avionService.buscarAvionPorId(1);

        //TODO VERIFICAMOS QUE EL AVION NO SEA NULO
        assertNotNull(avion);

        //TODO VERIFICAMOS QUE EL ID DEL AVION SEA 1
        assertEquals(1, avion.getId());
    }


    //TODO ----------------------------------- TESTS PARA LA IMPLEMENTACION DE MEMORIA -----------------------------------



    @Test
    public void registrarAvionEnMemoria() throws SQLException {
        //TODO INICIALIZAMOS EL SERVICIO CON UNA IMPLEMENTACION DE DAO MEMORIA
        avionService = new AvionService(new AvionDaoMemoriaImpl(new ArrayList<>()));

        //TODO CREAMOS UN AVION, QUE VA A SER ENVIADO COMO PARAMETRO AL METODO REGISTRAR AVION
        Avion avion = new Avion("PEPITO", "747", "LV-BFR", LocalDate.now());

        //TODO CREAMOS UNA VARIABLE AL CUAL LE ASIGNAMOS EL VALOR DEL RESULTADO DE LLAMAR avionService.registrarAvion(avion) DE LA IMPLEMENTACION EN MEMORIA
        Avion avionRegistrado = avionService.registrarAvion(avion);

        //TODO VERIFICAMOS QUE EL AVION REGISTRADO NO SEA NULO
        assertNotNull(avionRegistrado);

        //TODO VERIFICAMOS QUE LOS ATRIBUTOS DEL AVION REGISTRADO SEAN IGUALES A LOS ATRIBUTOS DEL AVION QUE REGISTRAMOS
        assertEquals(avion.getMarca(), avionRegistrado.getMarca());
        assertEquals(avion.getModelo(), avionRegistrado.getModelo());
        assertEquals(avion.getMatricula(), avionRegistrado.getMatricula());
        assertEquals(avion.getFechaEntradaServicio(), avionRegistrado.getFechaEntradaServicio());
    }

    @Test
    public void buscarAvionPorIdEnMemoria() throws SQLException {
        //TODO INICIALIZAMOS EL SERVICIO CON UNA IMPLEMENTACION DE DAO MEMORIA
        avionService = new AvionService(new AvionDaoMemoriaImpl(new ArrayList<>()));

        //TODO CREAMOS UN AVION, QUE VA A SER ENVIADO COMO PARAMETRO AL METODO REGISTRAR AVION
        Avion avion = new Avion(3,"PEPITO", "747", "LV-BFR", LocalDate.now());
        avionService.registrarAvion(avion);

        //TODO CREAMOS UNA VARIABLE AL CUAL LE ASIGNAMOS EL VALOR DEL RESULTADO DE LLAMAR avionService.buscarAvionPorId(3) DE LA IMPLEMENTACION EN MEMORIA
        Avion avionEncontrado = avionService.buscarAvionPorId(3);

        //TODO VERIFICAMOS QUE EL AVION ENCONTRADO NO SEA NULO
        assertNotNull(avionEncontrado);

        //TODO VERIFICAMOS QUE LOS ATRIBUTOS DEL AVION ENCONTRADO SEAN IGUALES A LOS ATRIBUTOS DEL AVION QUE REGISTRAMOS
        assertEquals(avion.getId(), avionEncontrado.getId());
        assertEquals(avion.getMarca(), avionEncontrado.getMarca());
    }

    @Test
    public void buscarTodosLosAvionesEnMemoria() throws SQLException {

        //TODO INICIALIZAMOS EL SERVICIO CON UNA IMPLEMENTACION DE DAO MEMORIA
        avionService = new AvionService(new AvionDaoMemoriaImpl(new ArrayList<>()));

        //TODO CREAMOS UN AVION, QUE VA A SER ENVIADO COMO PARAMETRO AL METODO REGISTRAR AVION
        Avion avion = new Avion(3,"PEPITO", "747", "LV-BFR", LocalDate.now());
        avionService.registrarAvion(avion);

        //TODO CREAMOS UNA LISTA DE AVIONES, QUE VA A SER EL RESULTADO DE LLAMAR avionService.buscarTodosLosAviones() DE LA IMPLEMENTACION EN MEMORIA
        List<Avion> avionList = avionService.buscarTodosLosAviones();

        //TODO VERIFICAMOS QUE LA LISTA DE AVIONES NO SEA NULA
        assertNotNull(avionList);
        assertEquals(1, avionList.size());
    }

    @Test
    public void eliminarAvionPorIdEnMemoria() throws SQLException {
        avionService = new AvionService(new AvionDaoMemoriaImpl(new ArrayList<>()));
        Avion avion = new Avion(3,"PEPITO", "747", "LV-BFR", LocalDate.now());
        avionService.registrarAvion(avion);
        avionService.eliminarAvionPorId(3);
        Avion avionEliminado = avionService.buscarAvionPorId(3);
        assertNull(avionEliminado);
    }


}