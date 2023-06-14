/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.somarecursiva;

/**
 *
 * @author yuriz
 */
public class SomaRecursiva {
    
    public static void main(String[] args) {
        
        int resultado = somaRecursiva(0, 50);
        System.out.println("Resultado: " + resultado);
    }

    private static int somaRecursiva(int inicio, int fim) {
        if (inicio == fim) {
            return inicio;
        } else {
            return inicio + somaRecursiva(inicio + 1, fim);
        }
    }
}