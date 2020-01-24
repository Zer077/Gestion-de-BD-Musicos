/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.datos.Generos;
import modelo.datos.Genero;
import modelo.datos.Grupos;
import modelo.datos.Musico;
import modelo.datos.Musicos;
import modelo.datos.Grupo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jose_
 */
public class Mapeo {

    ConexionBD m;
    Grupos grupos = new Grupos();
    Generos generos = new Generos();
    Musicos musicos = new Musicos();

    public Mapeo(ConexionBD c) {
        m = c;

    }

    //Sentencias de Musicos
    public Musico BuscarMusico(int id) {

        Musico musico = new Musico();
        try {
            m.abrirConexion();
            ResultSet resultado = m.ejecutarSQL("SELECT * FROM `musico` WHERE `idmusico`= '" + id + "';");
            if (m.numRegistros() != 0) {
                resultado.next();
                musico.setId(resultado.getInt(1));
                musico.setNombre(resultado.getString(2));
                musico.setInstrumento(resultado.getString(3));
                musico.setLugarnacimiento(resultado.getString(4));
                musico.setFecha_nacimiento(resultado.getString(5));
                System.out.println(resultado.getString(5));
                musico.setFecha_muerte(resultado.getString(6));

            }
            m.cerrarConexion();

        } catch (SQLException ex) {
            System.out.println("error");
        }

        return musico;

    }

    public void EliminarMusico(int id) {

        try {
            m.abrirConexion();
            m.ejecutarUpdate("DELETE FROM `musico` WHERE `idmusico`='" + id + "'");
            musicos.eliminarMusico(id);
            m.cerrarConexion();
        } catch (Exception e) {
        }

    }

    public void ActualizarMusico(int id, String nombre, String instrumento, String lugarnacimeinto, String fecha, String fecha2) {
        //formato fecha 2019-10-01
        m.abrirConexion();
        if (fecha2 != null) {
            m.ejecutarUpdate("UPDATE `musico` SET  `nombre`='" + nombre + "', `instrumento`='" + instrumento + "', `lugarnacimiento`='" + lugarnacimeinto + "', `fechanacimiento`='" + fecha + "', `fechamuerte`='" + fecha2 + "' WHERE `musico`.`idmusico`='" + id + "'");
            musicos.eliminarMusico(id);
            musicos.aniadirMusico(BuscarMusico(id));

        } else {
            m.ejecutarUpdate("UPDATE `musico` SET  `nombre`='" + nombre + "', `instrumento`='" + instrumento + "', `lugarnacimiento`='" + lugarnacimeinto + "', `fechanacimiento`='" + fecha + "' WHERE `musico`.`idmusico`='" + id + "'");
            musicos.eliminarMusico(id);
            musicos.aniadirMusico(BuscarMusico(id));
        }

        m.cerrarConexion();

    }

    public void InsertarMusico(int id, String nombre, String instrumento, String lugarnacimiento, String fecha, String fecha2) {
        m.abrirConexion();
        if (fecha2 != null) {
            m.ejecutarUpdate("INSERT INTO `musico` (`idmusico`, `nombre`, `instrumento`, `lugarnacimiento`, `fechanacimiento`, `fechamuerte`) VALUES ('" + id + "', '" + nombre + "', '" + instrumento + "', '" + lugarnacimiento + "', '" + fecha + "', '" + fecha2 + "');");
            musicos.aniadirMusico(BuscarMusico(id));

        } else {
            m.ejecutarUpdate("INSERT INTO `musico` (`idmusico`, `nombre`, `instrumento`, `lugarnacimiento`, `fechanacimiento`, `fechamuerte`) VALUES ('" + id + "', '" + nombre + "', '" + instrumento + "', '" + lugarnacimiento + "', '" + fecha + "', " + "NULL" + ");");
            musicos.aniadirMusico(BuscarMusico(id));
        }
        m.cerrarConexion();
    }

    public ArrayList buscarTodosLosMusicos() {
        ArrayList<Musico> resultados = new ArrayList();

        m.abrirConexion();
        ResultSet resultado = m.ejecutarSQL("SELECT * FROM `musico`");
        try {
            while (resultado.next()) {
                Musico musico = new Musico();
                musico.setId(resultado.getInt(1));
                musico.setNombre(resultado.getString(2));
                musico.setInstrumento(resultado.getString(3));
                musico.setLugarnacimiento(resultado.getString(4));
                musico.setFecha_nacimiento(resultado.getString(5));
                musico.setFecha_muerte(resultado.getString(6));
                resultados.add(musico);
                musico.setGrupos(buscarTodosLosGruposporMusico(resultado.getInt(1)));
                musicos.aniadirMusico(musico);
            }

            m.cerrarConexion();
        } catch (SQLException e) {
        }
        return resultados;

    }

    //Sentencias de Grupos
    public Grupo BuscarGrupo(int id) {
        Grupo grupo = new Grupo();

        try {
            m.abrirConexion();
            ResultSet resultado = m.ejecutarSQL("SELECT * FROM `grupo` WHERE `idgrupo` = '" + id + "' ;");
            if (m.numRegistros() != 0) {
                resultado.next();
                grupo.setId(resultado.getInt(1));
                grupo.setNombre(resultado.getString(2));
                grupo.setFormacion(resultado.getString(3));
                grupo.setDesintegracion(resultado.getString(4));
                grupo.setMusicos(buscarTodosLosMusicosporGrupo(grupo.getId()));

            }
            m.cerrarConexion();

        } catch (SQLException ex) {
            System.out.println("error");
        }

        return grupo;

    }

    //Devuelve todos los grupos de la BD
    public ArrayList<Grupo> BuscarTodosGrupos() {

        ArrayList<Grupo> resultados = new ArrayList();

        m.abrirConexion();
        ResultSet resultado = m.ejecutarSQL("SELECT * FROM `grupo`");
        try {
            while (resultado.next()) {
                Grupo grupo = new Grupo();
                grupo.setId(resultado.getInt(1));
                grupo.setNombre(resultado.getString(2));
                grupo.setFormacion(resultado.getString(3));
                grupo.setDesintegracion(resultado.getString(4));
                resultados.add(grupo);
                grupo.setMusicos(buscarTodosLosMusicosporGrupo(resultado.getInt(1)));
                grupos.aniadirGrupo(grupo);

            }
            m.cerrarConexion();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return resultados;

    }

    //Elimina un grupo de la BD
    public void EliminarGrupo(int id) {
        m.abrirConexion();
        m.ejecutarUpdate("DELETE FROM `grupo` WHERE `idgrupo`= '" + id + "'");
        m.cerrarConexion();
        grupos.eliminarGrupo(id);
    }

    public void ActualizarGrupo(int id, String nombre, String formacion, String desintegracion) {
        m.abrirConexion();
        if (desintegracion != null) {
            m.ejecutarUpdate("UPDATE `grupo` SET `nombre`='" + nombre + "', `formacion`='" + formacion + "', `desintegracion`= '" + desintegracion + "' WHERE `idgrupo`= '" + id + "';");

            grupos.eliminarGrupo(id);
            grupos.aniadirGrupo(BuscarGrupo(id));

        } else {
            m.ejecutarUpdate("UPDATE `grupo` SET `nombre`='" + nombre + "', `formacion`='" + formacion + "' WHERE `idgrupo`= '" + id + "';");
            grupos.eliminarGrupo(id);
            grupos.aniadirGrupo(BuscarGrupo(id));
        }
        m.cerrarConexion();

    }

    public void InsertarGrupo(int id, String nombre, String formacion, String desintegracion) {
        m.abrirConexion();
        if (desintegracion != null) {
            m.ejecutarUpdate("INSERT INTO `grupo` (`idgrupo`, `nombre`, `formacion`, `desintegracion`) VALUES ('" + id + "', '" + nombre + "', '" + formacion + "', '" + desintegracion + "')");
            grupos.eliminarGrupo(id);
            grupos.aniadirGrupo(BuscarGrupo(id));
        } else {
            m.ejecutarUpdate("INSERT INTO `grupo` (`idgrupo`, `nombre`, `formacion`, `desintegracion`) VALUES ('" + id + "', '" + nombre + "', '" + formacion + "'," + "NULL" + ")");
            grupos.eliminarGrupo(id);
            grupos.aniadirGrupo(BuscarGrupo(id));

        }
        m.cerrarConexion();

    }

    //Sentencias de Genero
    public Genero BuscarGenero(int id) {
        Genero genero = new Genero();

        try {
            m.abrirConexion();
            ResultSet result = m.ejecutarSQL("SELECT * FROM `genero` WHERE `idgenero` = '" + id + "'");
            if (m.numRegistros() != 0) {
                result.next();
                genero.setId(result.getInt(1));
                genero.setDescripcion(result.getString(2));
            }
            m.cerrarConexion();

        } catch (SQLException ex) {
            System.out.println("error");
        }

        return genero;

    }

    public void EliminarGenero(int id) {
        m.abrirConexion();
        m.ejecutarUpdate("DELETE FROM `genero` WHERE `idgenero`='" + id + "'");
        generos.eliminarGenero(id);
        m.cerrarConexion();

    }

    public void ActualizarGenero(int id, String descripcion) {
        m.abrirConexion();
        m.ejecutarUpdate("UPDATE `genero` SET  `descripcion`='" + descripcion + "' WHERE `idgenero`='" + id + "' ;");
        generos.eliminarGenero(id);
        generos.aniadirGenero(BuscarGenero(id));
        m.cerrarConexion();
    }

    public void InsertarGenero(int id, String descripcion) {
        m.abrirConexion();
        m.ejecutarUpdate("INSERT INTO `genero` (`idgenero`, `descripcion`) VALUES ('" + id + "', '" + descripcion + "');");
        grupos.eliminarGrupo(id);
        generos.aniadirGenero(BuscarGenero(id));
        m.cerrarConexion();
    }

    public ArrayList BuscarTodosGeneros() {
        ArrayList<Genero> resultados = new ArrayList();

        m.abrirConexion();
        ResultSet result = m.ejecutarSQL("SELECT * FROM `genero`");
        try {
            while (result.next()) {
                Genero genero = new Genero();
                genero.setId(result.getInt(1));
                genero.setDescripcion(result.getString(2));
                resultados.add(genero);
                generos.aniadirGenero(genero);
            }

            m.cerrarConexion();
        } catch (SQLException e) {
        }
        return resultados;
    }

    //Sentencias de relacion Musicos y Grupos
    public ArrayList<Musico> buscarTodosLosMusicosporGrupo(int id) {

        //busca a todos los musicos que están en un grupo
        ArrayList<Musico> resultados = new ArrayList();

        m.abrirConexion();

        ResultSet resultado = m.ejecutarSQL("SELECT * FROM `musicosgrupos` WHERE `idgrupo`= '" + id + "'");

        try {
            while (resultado.next()) {
                resultados.add(BuscarMusico(resultado.getInt(2)));

            }

            m.cerrarConexion();
        } catch (SQLException e) {
        }

        return resultados;

    }

    //Busca todos los grupos en los que está un musico
    public ArrayList<Grupo> buscarTodosLosGruposporMusico(int id) {

        ArrayList<Grupo> resultados = new ArrayList();

        m.abrirConexion();
        ResultSet resultado = m.ejecutarSQL("SELECT * FROM `musicosgrupos` WHERE `idmusico`= '" + id + "'");

        try {
            while (resultado.next()) {
                resultados.add(BuscarGrupo(resultado.getInt(1)));

            }

            m.cerrarConexion();
        } catch (SQLException e) {
        }

        return resultados;

    }

    public ArrayList<String> buscarelacionMusicoGrupos(int idgrupo, int idmusico) {

        ArrayList<String> resultado1 = new ArrayList();
        m.abrirConexion();
        ResultSet resultado = m.ejecutarSQL("SELECT * FROM `musicosgrupos` WHERE `idmusico`= '" + idmusico + "' AND `idgrupo`= '" + idgrupo + "'");

        try {
            while (resultado.next()) {
                resultado1.add(resultado.getString(3));
                resultado1.add(resultado.getString(4));
                resultado1.add(resultado.getString(5));

            }

            m.cerrarConexion();
        } catch (SQLException e) {
        }

        return resultado1;

    }

    public void relacionMusicosGrupos(int idgrupo, int idmusico, String instrumento, String fechainicio, String fechafin) {
        m.abrirConexion();
        if (fechafin != null) {
            System.out.println("INSERT INTO `musicosgrupos`(`idgrupo`, `idmusico`, `instrumento`, `fechainicio`, `fechafin`) VALUES ('" + idgrupo + "','" + idmusico + "','" + instrumento + "','" + fechainicio + "','" + fechafin + "');");
            m.ejecutarUpdate("INSERT INTO `musicosgrupos`(`idgrupo`, `idmusico`, `instrumento`, `fechainicio`, `fechafin`) VALUES ('" + idgrupo + "','" + idmusico + "','" + instrumento + "','" + fechainicio + "','" + fechafin + "');");

        } else {
            System.out.println("INSERT INTO `musicosgrupos`(`idgrupo`, `idmusico`, `instrumento`, `fechainicio`, `fechafin`) VALUES ('" + idgrupo + "','" + idmusico + "','" + instrumento + "','" + fechainicio + "'," + "NULL" + ");");
            m.ejecutarUpdate("INSERT INTO `musicosgrupos`(`idgrupo`, `idmusico`, `instrumento`, `fechainicio`, `fechafin`) VALUES ('" + idgrupo + "','" + idmusico + "','" + instrumento + "','" + fechainicio + "'," + "NULL" + ");");

        }
        m.cerrarConexion();

    }

    public void updateMusicosGrupos(int idgrupo, int idmusico, String instrumento, String fechainicio, String fechafin) {
        m.abrirConexion();
        if (fechafin == null) {
            m.ejecutarUpdate("UPDATE `musicosgrupos` SET `instrumento` = '" + instrumento + "', `fechainicio` = '" + fechainicio + "', `fechafin` = '" + "NULL" + "' WHERE `musicosgrupos`.`idgrupo` = " + idgrupo + " AND `musicosgrupos`.`idmusico` = " + idmusico + ";");

        } else {
            m.ejecutarUpdate("UPDATE `musicosgrupos` SET `instrumento` = '" + instrumento + "', `fechainicio` = '" + fechainicio + "', `fechafin` = '" + fechafin + "' WHERE `musicosgrupos`.`idgrupo` = " + idgrupo + " AND `musicosgrupos`.`idmusico` = " + idmusico + ";");

        }

        m.cerrarConexion();

    }

    public void deleteMusicosGrupos(int idgrupo, int idmusico) {
        m.abrirConexion();

        m.ejecutarUpdate("DELETE FROM `musicosgrupos` WHERE `idmusico`='" + idmusico + "' AND `idgrupo`='" + idgrupo + "'");

        m.cerrarConexion();

    }

    //Sentencias de relacion Grupo y genero
    public void deleteGenerosGrupos(int idgenero, int idgrupo) {

        m.abrirConexion();
        m.ejecutarUpdate("DELETE FROM `generosgrupo` WHERE `idgenero`=" + idgenero + " AND `idgrupo`=" + idgrupo + "");
        m.cerrarConexion();

    }

    public void relacionGenerosGrupos(int idgrupo, int idgenero) {

        m.abrirConexion();
        m.ejecutarUpdate("INSERT INTO `generosgrupo` (`idgrupo`, `idgenero`) VALUES ('" + idgrupo + "', '" + idgenero + "')");
        m.cerrarConexion();

    }

    public void updateGenerosGrupos(int idgrupo, int idgenero) {

        m.abrirConexion();
        m.ejecutarUpdate("UPDATE `generosgrupo` SET(`idgrupo`, `idgenero`) VALUES ('" + idgrupo + "','" + idgenero + "');");
        m.cerrarConexion();

    }

    public ArrayList<Genero> buscarGrupoGenero(int idgrupo) {

        ArrayList<Genero> resultados = new ArrayList();

        m.abrirConexion();
        ResultSet result = m.ejecutarSQL("SELECT * FROM `generosgrupo` WHERE `idgrupo`=" + idgrupo + "");
        try {
            while (result.next()) {
                Genero genero = new Genero();
                genero = BuscarGenero(result.getInt(2));
                resultados.add(genero);

            }

            m.cerrarConexion();
        } catch (SQLException e) {
        }
        return resultados;

    }

}
