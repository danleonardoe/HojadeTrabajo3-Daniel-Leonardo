/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.libro;
import java.util.Scanner;
/**
 *
 * @author DANIE
 */
public class Libro {
    private String titulo;
    private String autor;
    private boolean disponible;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true; // Por defecto, el libro está disponible
    }

    public void prestar() {
        if (disponible) {
            disponible = false; 
            System.out.println("El libro \"" + titulo + "\" se ha prestado.");
        } else {
            System.out.println("El libro \"" + titulo + "\" no esta disponible para prestamo :c.");
        }
    }

    public void devolver() {
        disponible = true; 
        System.out.println("El libro \"" + titulo + "\" ha sido devuelto de manera correcta.");
    }

    public void consultarDisponibilidad() {
        if (disponible) {
            System.out.println("El libro \"" + titulo + "\" esta disponible para prestamo :3.");
        } else {
            System.out.println("El libro \"" + titulo + "\" no esta disponible para prestamo :c.");
        }
    }

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

        Libro libro1 = new Libro("Harry Potter y el Caliz de Fuego", "J.K. Rowling");

        int opcion;

        do {
            System.out.println("\n--- Menu de Gestion de Biblioteca ---");
            System.out.println("1. Consultar disponibilidad del libro");
            System.out.println("2. Prestar libro");
            System.out.println("3. Devolver libro");
            System.out.println("4. Salir");
            System.out.print("Elija una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    libro1.consultarDisponibilidad();
                    break;
                case 2:
                    libro1.prestar();
                    break;
                case 3:
                    libro1.devolver();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("La Opcion no es valida. Por favor, elija una opcion entre 1 y 4.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}