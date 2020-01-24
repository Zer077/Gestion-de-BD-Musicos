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
public class Grupos {

    private ArrayList<Grupo> listagrupos = new ArrayList<>();

    public Grupos() {
    }

    public void aniadirGrupo(Grupo m) {

        listagrupos.add(m);
    }

    public Grupo sacarGrupo(int id) {
        for (int i = 0; i < listagrupos.size(); i++) {
            if (listagrupos.get(i).getId() == id) {

                return listagrupos.get(i);
            }

        }
        return null;

    }

    public void eliminarGrupo(int id) {
        for (int i = 0; i < listagrupos.size(); i++) {
            if (listagrupos.get(i).getId() == id) {
                listagrupos.remove(i);

            }

        }

    }

}
