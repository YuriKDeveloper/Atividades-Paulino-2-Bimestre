/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculofibonnaci;

import javax.swing.JOptionPane;

/**
 *
 * @author yuriz
 */
public class CalculoFibonnaci {

   public static void main(String[] args) {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe um número:"));
        System.out.println("Sequência Fibonacci até o número " + numero + ":");
        for (int i = 0; i <= numero; i++) {
            int resultado = calcularFibonacci(i);
            System.out.print(resultado + " ");
        }
    }

    private static int calcularFibonacci(int numero) {
        if (numero == 0) {
            return 0;
        } else if (numero == 1) {
            return 1;
        } else {
            return calcularFibonacci(numero - 1) + calcularFibonacci(numero - 2);
        }
    }
}
