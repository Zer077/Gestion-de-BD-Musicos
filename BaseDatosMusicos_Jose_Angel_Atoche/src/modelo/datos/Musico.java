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
public class Musico {

    private int id;
    private String nombre;
    private String instrumento;
    private String lugarnacimiento;
    private String fecha_nacimiento;
    private String fecha_muerte = null;
    private ArrayList<Grupo> grupos;

    public Musico() {
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
     * @return the instrumento
     */
    public String getInstrumento() {
        return instrumento;
    }

    /**
     * @param instrumento the instrumento to set
     */
    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    /**
     * @return the lugarnacimiento
     */
    public String getLugarnacimiento() {
        return lugarnacimiento;
    }

    /**
     * @param lugarnacimiento the lugarnacimiento to set
     */
    public void setLugarnacimiento(String lugarnacimiento) {
        this.lugarnacimiento = lugarnacimiento;
    }

    /**
     * @return the fecha_nacimiento
     */
    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * @param fecha_nacimiento the fecha_nacimiento to set
     */
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * @return the fecha_muerte
     */
    public String getFecha_muerte() {
        return fecha_muerte;
    }

    /**
     * @param fecha2 the fecha_muerte to set
     */
    public void setFecha_muerte(String fecha2) {
        this.fecha_muerte = fecha2;
    }

    /**
     * @return the grupos
     */
    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    /**
     * @param grupos the grupos to set
     */
    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }

}
