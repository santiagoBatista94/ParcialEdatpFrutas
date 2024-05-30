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

public class NodoTernario {
    private Fruta fruta;
     private NodoTernario izquierdo;
    private NodoTernario medio;
    private NodoTernario derecho;

     public NodoTernario(Fruta fruta) {
        this.fruta = fruta;
        izquierdo = null;
        medio = null;
        derecho = null;
    }
    public Fruta getFruta() {
        return fruta;
    }

    public void setFruta(Fruta fruta) {
        this.fruta = fruta;
    }

    public NodoTernario getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoTernario izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoTernario getMedio() {
        return medio;
    }

    public void setMedio(NodoTernario medio) {
        this.medio = medio;
    }

    public NodoTernario getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoTernario derecho) {
        this.derecho = derecho;
    }

    
    

    
    }
