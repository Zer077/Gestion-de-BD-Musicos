/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Inicio.Login;
import java.util.ArrayList;
import modelo.Mapeo;
import modelo.datos.Genero;
import modelo.datos.Grupo;
import modelo.datos.Musico;

/**
 *
 * @author jose_
 */
public class Controlador {

    private Mapeo map;

    public Controlador() {

    }

    /**
     * @return the map
     */
    public Mapeo getMap() {
        return map;
    }

    public Musico sacarMusico(int id) {
        return map.BuscarMusico(id);
    }

    public ArrayList<Musico> sacarMusicos() {

        return map.buscarTodosLosMusicos();
    }

    public void introducirMusico(Musico m) {
        map.InsertarMusico(m.getId(), m.getNombre(), m.getInstrumento(), m.getLugarnacimiento(), m.getFecha_nacimiento(), m.getFecha_muerte());
    }

    public void modificarMusico(Musico m) {
        map.ActualizarMusico(m.getId(), m.getNombre(), m.getInstrumento(), m.getLugarnacimiento(), m.getFecha_nacimiento(), m.getFecha_muerte());
    }

    public void eliminarMusico(int id) {
        map.EliminarMusico(id);
    }

    public Grupo sacarGrupo(int id) {
        return map.BuscarGrupo(id);

    }

    public ArrayList<Grupo> sacarGrupos() {
        return map.BuscarTodosGrupos();

    }

    public void introducirGrupo(Grupo g) {
        map.InsertarGrupo(g.getId(), g.getNombre(), g.getFormacion(), g.getDesintegracion());
    }

    public void modificarGrupo(Grupo g) {
        map.ActualizarGrupo(g.getId(), g.getNombre(), g.getFormacion(), g.getDesintegracion());
    }

    public void eliminarGrupo(int id) {
        map.EliminarGrupo(id);
    }

    public Genero sacarGenero(int id) {
        return map.BuscarGenero(id);
    }

    public ArrayList<Genero> sacarGeneros() {
        return map.BuscarTodosGeneros();
    }

    public void introducirGenero(Genero g) {
        map.InsertarGenero(g.getId(), g.getDescripcion());
    }

    public void modificarGenero(Genero g) {
        map.ActualizarGenero(g.getId(), g.getDescripcion());
    }

    public void eliminarGenero(int id) {
        map.EliminarGenero(id);

    }

    public void introducirGrupoMusico(int idgrupo, int idmusico, String instrumento, String inicio, String fin) {
        map.relacionMusicosGrupos(idgrupo, idmusico, instrumento, inicio, fin);

    }

    public void EliminaGrupoMusico(int idgrupo, int idmusico) {
        map.deleteMusicosGrupos(idgrupo, idmusico);

    }

    public void ActualizaGrupoMusico(int idgrupo, int idmusico, String instrumento, String inicio, String fin) {
        map.updateMusicosGrupos(idgrupo, idmusico, instrumento, inicio, fin);

    }

    public ArrayList<Grupo> sacarGrupoporMusico(int idmusico) {

        return map.buscarTodosLosGruposporMusico(idmusico);
    }

    public ArrayList<Musico> sacarMusicoporGrupo(int idgrupo) {

        return map.buscarTodosLosMusicosporGrupo(idgrupo);
    }

    public void relacionGrupoGenero(int idgenero, int idgrupo) {
        map.relacionGenerosGrupos(idgrupo, idgenero);
    }

    public void eliminaGrupoGenero(int idgenero, int idgrupo) {
        map.deleteGenerosGrupos(idgenero, idgrupo);
    }

    public ArrayList<Genero> sacarGrupoGeneros(int idgrupo) {
        return map.buscarGrupoGenero(idgrupo);

    }

    public ArrayList<String> sacarMusicoGrupo(int idgrupo, int idmusico) {
        return map.buscarelacionMusicoGrupos(idgrupo, idmusico);

    }

    /**
     * @param map the map to set
     */
    public void setMap(Mapeo map) {
        this.map = map;
    }
//Abre el LOGING

    public void start() {

        Login log = new Login(this);
        log.setVisible(true);

        map = new Mapeo(log.conexion);
    }

}
