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
// ordena por categoria  "ácida" ,"dulce", o "mixta"
        int comparacion = fruta.getCategoria().compareTo(nodo.getFruta().getCategoria());

        if (comparacion <0 ) {
            nodo.setIzquierdo(insertarFrutaRecursivo(nodo.getIzquierdo(), fruta));// acida
            System.out.println("comparacion izq : " + comparacion + "catergoria: " + fruta.getCategoria()+ "nodo: " + nodo.getFruta().getCategoria());
        } else if (comparacion > 0) { // dulce
            System.out.println("comparacion der : " + comparacion + "catergoria: " + fruta.getCategoria() + "nodo: " + nodo.getFruta().getCategoria());
            nodo.setDerecho(insertarFrutaRecursivo(nodo.getDerecho(), fruta));
        } else {
            System.out.println("comparacion medio : " + comparacion + "catergoria: " + fruta.getCategoria() + "nodo: " + nodo.getFruta().getCategoria());
            nodo.setMedio(insertarFrutaRecursivo(nodo.getMedio(), fruta));// mixta
        }

        return nodo;
    }
    
    public void buscarFruta(String nombre) {
        buscarFrutaRecursivo(raiz, nombre);
    }


    private void buscarFrutaRecursivo(NodoTernario nodo, String nombre) {
    Fruta frutaencontrada = new Fruta();
    int comparacion = 0;
    
    if (nodo == null) {
        System.out.println("La fruta no está en el mercado");
        return;
    }

    Fruta fruta = nodo.getFruta();
    if (fruta != null) {
        if (nombre.compareTo(fruta.getNombre()) == 0) {
            System.out.println("La fruta " + nombre + " se encontró en: " + nodo.getFruta().getCategoria());
        } else if (comparacion < 0) {
            buscarFrutaRecursivo(nodo.getIzquierdo(), nombre);
        } else {
            buscarFrutaRecursivo(nodo.getDerecho(), nombre);
        }
    } else {
        System.out.println("La fruta no tiene nombre");
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
//        System.out.println("Categoria buscada: " + categoria + " categoria Nodo: " + nodo.getFruta().getCategoria());

        mostrarPorCategoriaRecursivo(nodo.getMedio(), categoria);

        mostrarPorCategoriaRecursivo(nodo.getDerecho(), categoria);
    }
}
