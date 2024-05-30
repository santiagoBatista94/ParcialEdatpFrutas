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
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la fruta: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la categoría de la fruta: ");
                    String categoria = scanner.nextLine();

                    Fruta fruta = new Fruta(nombre, categoria);
                    arbol.insertarFruta(fruta);
                    System.out.println("Fruta insertada correctamente.");
                    break;
                case 2:
                    System.out.print("Ingrese la categoría de frutas a mostrar: ");
                    String categoriaMostrar = scanner.nextLine();
                    System.out.println("Frutas de la categoría " + categoriaMostrar + ":");
                    arbol.mostrarPorCategoria(categoriaMostrar);
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 3);

        scanner.close();
    }
    }

