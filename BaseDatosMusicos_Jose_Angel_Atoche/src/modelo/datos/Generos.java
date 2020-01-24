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
public class Generos {

    private ArrayList<Genero> listageneros = new ArrayList<>();

    public Generos() {
    }

    public void aniadirGenero(Genero m) {

        listageneros.add(m);
    }

    public Genero sacarGenero(int id) {
        for (int i = 0; i < listageneros.size(); i++) {
            if (listageneros.get(i).getId() == id) {

                return listageneros.get(i);
            }

        }
        return null;

    }

    public void eliminarGenero(int id) {
        for (int i = 0; i < listageneros.size(); i++) {
            if (listageneros.get(i).getId() == id) {
                listageneros.remove(i);

            }

        }

    }

}
