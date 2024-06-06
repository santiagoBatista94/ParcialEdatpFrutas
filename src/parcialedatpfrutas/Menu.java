/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialedatpfrutas;

import java.util.Scanner;

/**
 *
 * @author SANTIAGO
 */
public class Menu {

    private ArbolTernario arbol;

    public Menu() {
        arbol = new ArbolTernario();
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("=== Menú ===");
            System.out.println("1. Insertar Fruta");
            System.out.println("2. Mostrar Frutas por Categoría");
            System.out.println("3. buscar futa por nombre");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
//                    System.out.print("Ingrese el nombre de la fruta: ");
//                    String nombre = scanner.nextLine();
//                    System.out.print("Ingrese la categoría de la fruta: ");
//                    String categoria = scanner.nextLine();
//                    
                    /// a mano
                    Fruta fruta1 = new Fruta("anana", "dulce");
                    arbol.insertarFruta(fruta1);
                    Fruta fruta2 = new Fruta("naranja", "mixta");
                    arbol.insertarFruta(fruta2);
                    Fruta fruta3 = new Fruta("pera", "acida");
                    arbol.insertarFruta(fruta3);
                    Fruta fruta4 = new Fruta("banana", "mixta");
                    arbol.insertarFruta(fruta4);
                    Fruta fruta5 = new Fruta("melon", "dulce");
                    arbol.insertarFruta(fruta5);
                    Fruta fruta6 = new Fruta("manzana", "mixta");
                    arbol.insertarFruta(fruta6);
                    Fruta fruta7 = new Fruta("kiwi", "acida");
                    arbol.insertarFruta(fruta7);
                    Fruta fruta8 = new Fruta("zandia", "dulce");
                    arbol.insertarFruta(fruta8);
                    Fruta fruta9 = new Fruta("durazno", "dulce");
                    arbol.insertarFruta(fruta9);
                    Fruta fruta10 = new Fruta("limon", "acida");
                    arbol.insertarFruta(fruta10);
//
//                    Fruta fruta = new Fruta(nombre, categoria);
//                    arbol.insertarFruta(fruta);
//                    System.out.println("Fruta insertada correctamente.");
                    break;
                case 2:
                    System.out.print("Categoria: acida, dulce, mixta ");
                    String categoriaMostrar = scanner.nextLine();
                    System.out.println("Frutas de la categoría " + categoriaMostrar + ":");
                    arbol.mostrarPorCategoria(categoriaMostrar);
                    break;

                case 3:
                    System.out.print("Ingrese el nombre de la fruta a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    arbol.buscarFruta(nombreBuscar);

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}
