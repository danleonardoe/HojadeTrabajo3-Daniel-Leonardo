/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestionrecursoshumanos;
import java.util.Scanner;
/**
 *
 * @author DANIE
 */
abstract class Empleado {
    protected String nombre;
    protected String id;
    protected double salarioBase;

    public Empleado(String nombre, String id, double salarioBase) {
        this.nombre = nombre;
        this.id = id;
        this.salarioBase = salarioBase;
    }

    public abstract double calcularSalario();

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Salario base: Q" + salarioBase);
    }
}

class EmpleadoAsalariado extends Empleado {

    public EmpleadoAsalariado(String nombre, String id, double salarioBase) {
        super(nombre, id, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return salarioBase;
    }
}

// Clase concreta EmpleadoPorHoras
class EmpleadoPorHoras extends Empleado {
    private double tarifaPorHora;
    private int horasTrabajadas;

    public EmpleadoPorHoras(String nombre, String id, double salarioBase, double tarifaPorHora, int horasTrabajadas) {
        super(nombre, id, salarioBase);
        this.tarifaPorHora = tarifaPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSalario() {
        return tarifaPorHora * horasTrabajadas;
    }
}

public class GestionRecursosHumanos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado("Daniel Leonardo", "0001", 6000);
        EmpleadoPorHoras empleadoPorHoras = new EmpleadoPorHoras("Jorge Campos", "0002", 5000, 20, 220);

        int opcion;

        do {
            System.out.println("\n|--- Menu de Gestion de Recursos Humanos ---|");
            System.out.println("1. Mostrar informacion del empleado asalariado");
            System.out.println("2. Calcular salario del empleado asalariado");
            System.out.println("3. Mostrar informacion del empleado por horas");
            System.out.println("4. Calcular salario del empleado por horas");
            System.out.println("5. Salir");
            System.out.print("Elija una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    empleadoAsalariado.mostrarInformacion();
                    break;
                case 2:
                    System.out.println("Salario del empleado asalariado: Q" + empleadoAsalariado.calcularSalario());
                    break;
                case 3:
                    empleadoPorHoras.mostrarInformacion();
                    break;
                case 4:
                    System.out.println("Salario del empleado por horas: Q" + empleadoPorHoras.calcularSalario());
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("La opcion no es valida. Por favor, elija una opcion entre 1 y 5.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}