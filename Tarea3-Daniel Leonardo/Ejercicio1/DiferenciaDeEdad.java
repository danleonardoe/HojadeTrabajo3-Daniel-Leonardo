/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.diferenciadeedad;

import java.util.Scanner;

public class DiferenciaDeEdad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el anio en que nacio la primera persona: ");
        int anioNacimiento1 = scanner.nextInt();

        System.out.print("Ingrese el anio en que nacio la segunda persona: ");
        int anioNacimiento2 = scanner.nextInt();

        int diferenciaDeEdad = Math.abs(anioNacimiento1 - anioNacimiento2);

        if (anioNacimiento1 < anioNacimiento2) {
            System.out.println("La primera persona es mayor por " + diferenciaDeEdad + " anios.");
        } else if (anioNacimiento1 > anioNacimiento2) {
            System.out.println("La segunda persona es mayor por " + diferenciaDeEdad + " anios.");
        } else {
            System.out.println("Las dos personas tienen la misma edad.");
        }
        scanner.close();
    }
}