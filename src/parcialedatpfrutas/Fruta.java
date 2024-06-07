/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialedatpfrutas;

/**
 *
 * @author SANTIAGO
 */
public class Fruta {
    private String nombre;
    private String categoria; // Puede ser "dulce", "ácida" o "mixta"

    public Fruta(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public Fruta() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "(" +nombre + " , " + categoria + ")";
    }
}
