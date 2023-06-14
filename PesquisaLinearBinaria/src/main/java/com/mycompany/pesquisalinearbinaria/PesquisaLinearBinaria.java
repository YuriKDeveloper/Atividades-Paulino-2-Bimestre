/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pesquisalinearbinaria;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author yuriz
 */
public class PesquisaLinearBinaria {

       public static void main(String[] args) {
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de números a cadastrar:"));
        int[] numeros = new int[quantidade];

        for (int i = 0; i < quantidade; i++) {
            numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Informe o número #" + (i + 1) + ":"));
        }

           Arrays.sort(numeros);

        int opcao;
        do {
            String opcaoStr = JOptionPane.showInputDialog(
                    "=== Menu ===\n" +
                            "1 - Pesquisa Linear\n" +
                            "2 - Pesquisa Binária\n" +
                            "0 - Sair\n" +
                            "Digite a opção desejada:"
            );

            opcao = Integer.parseInt(opcaoStr);

            switch (opcao) {
                case 1:
                    int numeroLinear = Integer.parseInt(JOptionPane.showInputDialog("Informe o número a pesquisar (Pesquisa Linear):"));
                    pesquisarLinear(numeroLinear, numeros);
                    break;
                case 2:
                    int numeroBinario = Integer.parseInt(JOptionPane.showInputDialog("Informe o número a pesquisar (Pesquisa Binária):"));
                    pesquisarBinaria(numeroBinario, numeros);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo do programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Digite novamente.");
            }

        } while (opcao != 0);
    }

    private static void pesquisarLinear(int numero, int[] numeros) {
        boolean encontrado = false;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == numero) {
                JOptionPane.showMessageDialog(null, "Número encontrado na posição: " + i);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Número não encontrado.");
        }
    }

    private static void pesquisarBinaria(int numero, int[] numeros) {
        int inicio = 0;
        int fim = numeros.length - 1;
        boolean encontrado = false;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (numeros[meio] == numero) {
                JOptionPane.showMessageDialog(null, "Número encontrado na posição: " + meio);
                encontrado = true;
                break;
            }

            if (numeros[meio] < numero) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Número não encontrado.");
        }
    }
}
