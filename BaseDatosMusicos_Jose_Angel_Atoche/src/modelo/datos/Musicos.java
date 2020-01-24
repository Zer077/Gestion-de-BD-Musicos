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
public class Musicos {

    private ArrayList<Musico> listamusicos = new ArrayList<>();

    public Musicos() {
    }

    public void aniadirMusico(Musico m) {

        listamusicos.add(m);
    }

    public Musico sacarMusico(int id) {
        for (int i = 0; i < listamusicos.size(); i++) {
            if (listamusicos.get(i).getId() == id) {

                return listamusicos.get(i);
            }

        }
        return null;

    }

    public void eliminarMusico(int id) {
        for (int i = 0; i < listamusicos.size(); i++) {
            if (listamusicos.get(i).getId() == id) {
                listamusicos.remove(i);

            }

        }

    }

}
