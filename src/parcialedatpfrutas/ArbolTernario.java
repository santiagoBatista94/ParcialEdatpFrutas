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
            System.out.println("comp izq : " + comparacion + " Fruta a Insertar: " + fruta+ " nodo: " + nodo.getFruta());
        } else if (comparacion > 0) { // dulce
            System.out.println("comp der : " + comparacion + " Fruta a Insertar: " + fruta + " nodo: " + nodo.getFruta());
            nodo.setDerecho(insertarFrutaRecursivo(nodo.getDerecho(), fruta));
        } else {
            System.out.println("comp med : " + comparacion + " Fruta a Insertar: " + fruta + " nodo: " + nodo.getFruta());
            nodo.setMedio(insertarFrutaRecursivo(nodo.getMedio(), fruta));// mixta
        }

        return nodo;
    }
    

      public void mostrarPorNombre(String nombre) {
        mostrarPorNombreRecursivo(raiz, nombre);
    }

    private void mostrarPorNombreRecursivo(NodoTernario nodo, String nombre) {
        if (nodo == null) {
            return;
        }

        mostrarPorNombreRecursivo(nodo.getIzquierdo(), nombre);

        if (nodo.getFruta().getNombre().equals(nombre)) {
//            System.out.println("La fruta "+ nodo.getFruta().getNombre() +" esta en la Categoria " + nodo.getFruta().getCategoria());
            System.out.println(nodo.getFruta());
        }
//        System.out.println("Categoria buscada: " + categoria + " categoria Nodo: " + nodo.getFruta().getCategoria());

        mostrarPorNombreRecursivo(nodo.getMedio(), nombre);

        mostrarPorNombreRecursivo(nodo.getDerecho(), nombre);
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
