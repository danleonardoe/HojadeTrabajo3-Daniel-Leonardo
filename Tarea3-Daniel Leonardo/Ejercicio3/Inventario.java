/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.inventario;
import java.util.Scanner;

/**
 *
 * @author DANIE
 */
abstract class Producto {
    protected String nombre;
    protected double precio;
    protected int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Métodos abstractos
    public abstract void agregarCantidad(int cantidad);

    public abstract void vender(int cantidad);

    public void consultarInventario() {
        System.out.println("Producto: " + nombre);
        System.out.println("Cantidad disponible en inventario: " + cantidad);
    }
}

class Electronico extends Producto {
    // Constructor que invoca el constructor de la clase padre
    public Electronico(String nombre, double precio, int cantidad) {
        super(nombre, precio, cantidad);
    }

    // Implementación del método abstracto agregarCantidad
    @Override
    public void agregarCantidad(int cantidad) {
        this.cantidad += cantidad;
        System.out.println("Se han agregado " + cantidad + " unidades de " + nombre + " al inventario.");
    }

    // Implementación del método abstracto vender
    @Override
    public void vender(int cantidad) {
        if (this.cantidad >= cantidad) {
            this.cantidad -= cantidad;
            System.out.println("Se han vendido " + cantidad + " unidades de " + nombre + ".");
        } else {
            System.out.println("No hay suficiente inventario para vender " + cantidad + " unidades de " + nombre + ".");
        }
    }
}

public class Inventario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Electronico laptop = new Electronico("Laptop", 5999.99, 20);

        int opcion;

        do {
            System.out.println("\n--- Menu de Gestion de Inventario ---");
            System.out.println("1. Consultar inventario");
            System.out.println("2. Agregar cantidad al inventario");
            System.out.println("3. Vender producto");
            System.out.println("4. Salir");
            System.out.print("Elija una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    laptop.consultarInventario();
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a agregar: ");
                    int cantidadAgregar = scanner.nextInt();
                    laptop.agregarCantidad(cantidadAgregar);
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad a vender: ");
                    int cantidadVender = scanner.nextInt();
                    laptop.vender(cantidadVender);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor, elija una opcion entre 1 y 4.");
            }
        } while (opcion != 4);

        // Cerrar el Scanner
        scanner.close();
    }
}