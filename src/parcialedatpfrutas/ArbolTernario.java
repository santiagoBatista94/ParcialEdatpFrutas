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
import java.util.ArrayList;
import java.util.List;

public class ArbolTernario {

    private NodoTernario raiz;

    public ArbolTernario() {
        raiz = null;
    }

    public void insertarFruta(Fruta fruta) {
        raiz = insertarFrutaRecursivo(raiz, fruta);
    }

    private NodoTernario insertarFrutaRecursivo(NodoTernario nodo, Fruta fruta) {
        if (nodo == null) {
            return new NodoTernario(fruta);
        }

        if (fruta.getNombre().compareTo(nodo.getFruta().getNombre()) < 0) {
            nodo.setIzquierdo(insertarFrutaRecursivo(nodo.getIzquierdo(), fruta));
        } else if (fruta.getNombre().compareTo(nodo.getFruta().getNombre()) > 0) {
            nodo.setDerecho(insertarFrutaRecursivo(nodo.getDerecho(), fruta));
        } else {
            nodo.setMedio(insertarFrutaRecursivo(nodo.getMedio(), fruta));
        }

        return nodo;
    }

    public boolean buscarFruta(String nombre) {
        return buscarFrutaRecursivo(raiz, nombre);
    }

    private boolean buscarFrutaRecursivo(NodoTernario nodo, String nombre) {
        if (nodo == null) {
            return false;
        }

        if (nodo.getFruta().getNombre().equals(nombre)) {
            return true;
        } else if (nombre.compareTo(nodo.getFruta().getNombre()) < 0) {
            return buscarFrutaRecursivo(nodo.getIzquierdo(), nombre);
        } else if (nombre.compareTo(nodo.getFruta().getNombre()) > 0) {
            return buscarFrutaRecursivo(nodo.getDerecho(), nombre);
        } else {
            return buscarFrutaRecursivo(nodo.getMedio(), nombre);
        }
    }

    public void mostrarPorCategoria(String categoria) {
        mostrarPorCategoriaRecursivo(raiz, categoria);
    }

    private void mostrarPorCategoriaRecursivo(NodoTernario nodo, String categoria) {
        if (nodo == null) {
            return;
        }

        mostrarPorCategoriaRecursivo(nodo.getIzquierdo(), categoria);

        if (nodo.getFruta().getCategoria().equals(categoria)) {
            System.out.println(nodo.getFruta().getNombre());
        }

        mostrarPorCategoriaRecursivo(nodo.getMedio(), categoria);

        mostrarPorCategoriaRecursivo(nodo.getDerecho(), categoria);
    }
}
