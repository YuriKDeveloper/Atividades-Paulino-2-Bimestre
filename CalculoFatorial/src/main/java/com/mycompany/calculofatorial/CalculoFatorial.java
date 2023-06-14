/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculofatorial;

import javax.swing.JOptionPane;

/**
 *
 * @author yuriz
 */
public class CalculoFatorial {
    public static void main(String[] args) {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe um número:"));
        long fatorial = calcularFatorial(numero);
        JOptionPane.showMessageDialog(null, "O fatorial de " + numero + " é: " + fatorial);
    }
    
   public static long calcularFatorial(int numero) {
       if(numero == 0 || numero == 1){
           return 1;
       }
       return numero * calcularFatorial(numero -1 );
   }

    
}
