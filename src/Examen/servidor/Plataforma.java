package Examen.servidor;

import java.io.Serializable;
import java.util.ArrayList;

public class Plataforma implements Serializable {
    private String cliente;
    private String plataforma;
    ArrayList<String> lista_series = new ArrayList<String>();
    ArrayList<String> lista_docus = new ArrayList<String>();

    private String tipocontenido;

    private String nombrecontenido;

    private String plataformaregistrado;

    private int notacontenido;

    private String añoproduccion;

    private int opcions=0;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public ArrayList<String> getLista_series() {
        return lista_series;
    }

    public void setLista_series(ArrayList<String> lista_series) {
        this.lista_series = lista_series;
    }

    public ArrayList<String> getLista_docus() {
        return lista_docus;
    }

    public void setLista_docus(ArrayList<String> lista_docus) {
        this.lista_docus = lista_docus;
    }

    public String getTipocontenido() {
        return tipocontenido;
    }

    public void setTipocontenido(String tipocontenido) {
        this.tipocontenido = tipocontenido;
    }

    public String getNombrecontenido() {
        return nombrecontenido;
    }

    public void setNombrecontenido(String nombrecontenido) {
        this.nombrecontenido = nombrecontenido;
    }

    public String getPlataformaregistrado() {
        return plataformaregistrado;
    }

    public void setPlataformaregistrado(String plataformaregistrado) {
        this.plataformaregistrado = plataformaregistrado;
    }

    public int getNotacontenido() {
        return notacontenido;
    }

    public void setNotacontenido(int notacontenido) {
        this.notacontenido = notacontenido;
    }

    public String getAñoproduccion() {
        return añoproduccion;
    }

    public void setAñoproduccion(String añoproduccion) {
        this.añoproduccion = añoproduccion;
    }

    public int getOpcions() {
        return opcions;
    }

    public void setOpcions(int opcions) {
        this.opcions = opcions;
    }

}
