/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.datos;

import java.util.ArrayList;

/**
 *
 * @author jose_
 */
public class Grupo {

    private int id;
    private String nombre;
    private String formacion;
    private String desintegracion = null;
    private ArrayList<Musico> musicos;

    public Grupo() {
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the formacion
     */
    public String getFormacion() {
        return formacion;
    }

    /**
     * @param formacion the formacion to set
     */
    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }

    /**
     * @return the desintegracion
     */
    public String getDesintegracion() {
        return desintegracion;
    }

    /**
     * @param desintegracion the desintegracion to set
     */
    public void setDesintegracion(String desintegracion) {
        this.desintegracion = desintegracion;
    }

    /**
     * @return the musicos
     */
    public ArrayList<Musico> getMusicos() {
        return musicos;
    }

    /**
     * @param musicos the musicos to set
     */
    public void setMusicos(ArrayList<Musico> musicos) {
        this.musicos = musicos;
    }

}
