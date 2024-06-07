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

        if (comparacion < 0) {
            nodo.setIzquierdo(insertarFrutaRecursivo(nodo.getIzquierdo(), fruta));// acida
            System.out.println("comp izq : " + comparacion + " Fruta a Insertar: " + fruta + " nodo: " + nodo.getFruta());
        } else if (comparacion > 0) { // dulce
            System.out.println("comp der : " + comparacion + " Fruta a Insertar: " + fruta + " nodo: " + nodo.getFruta());
            nodo.setDerecho(insertarFrutaRecursivo(nodo.getDerecho(), fruta));
        } else {
            System.out.println("comp med : " + comparacion + " Fruta a Insertar: " + fruta + " nodo: " + nodo.getFruta());
            nodo.setMedio(insertarFrutaRecursivo(nodo.getMedio(), fruta));// mixta
        }

        return nodo;
    }

//    public void buscarPorNombre(String nombre) {
//        buscarPorNombreRecursivo(raiz, nombre);
//    }
//
//    private void buscarPorNombreRecursivo(NodoTernario nodo, String nombre) {
//        if (nodo == null) {
//           
//            return;
//        }
//
//        if (nodo.getFruta().getNombre().equals(nombre)) {
////            System.out.println("La fruta "+ nodo.getFruta().getNombre() +" esta en la Categoria " + nodo.getFruta().getCategoria());
//            System.out.println("Se encontro en: "+nodo.getFruta());
//        }
////        System.out.println("Categoria buscada: " + categoria + " categoria Nodo: " + nodo.getFruta().getCategoria());
//        buscarPorNombreRecursivo(nodo.getIzquierdo(), nombre);
//        
//        buscarPorNombreRecursivo(nodo.getMedio(), nombre);
//
//        buscarPorNombreRecursivo(nodo.getDerecho(), nombre);
// 
//    }
    public void buscarPorNombre(String nombre) {
        boolean frutaEncontrada = buscarPorNombreRecursivo(raiz, nombre);

        if (!frutaEncontrada) {
            System.out.println("No se encontro ninguna fruta con el nombre especificado.");
        }
    }

    private boolean buscarPorNombreRecursivo(NodoTernario nodo, String nombre) {
        if (nodo == null) {
            return false;
        }

        if (nodo.getFruta().getNombre().equals(nombre)) {
            System.out.println("Se encontro en: " + nodo.getFruta());
            return true;
        }

        boolean izquierdo = buscarPorNombreRecursivo(nodo.getIzquierdo(), nombre);
        boolean medio = buscarPorNombreRecursivo(nodo.getMedio(), nombre);
        boolean derecho = buscarPorNombreRecursivo(nodo.getDerecho(), nombre);

        return izquierdo || medio || derecho;
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
