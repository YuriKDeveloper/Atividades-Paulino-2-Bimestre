/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemabanco;

import javax.swing.JOptionPane;

public class SistemaBanco {
    private static final int tam_fila = 100;
    private static Cliente[] filaPrioritaria = new Cliente[tam_fila];
    private static Cliente[] filaNormal = new Cliente[tam_fila];
    private static int indicePrioritaria = 0;
    private static int indiceNormal = 0;
    private static int contadorPrioritarios = 0;

    public static void main(String[] args) {
        int opcao;
        do {
            String opcaoStr = JOptionPane.showInputDialog(
                "=== Menu ===\n" +
                "1 - Adicionar cliente\n" +
                "2 - Chamar cliente\n" +
                "0 - Sair\n" +
                "Digite a opção desejada:"
            );

            opcao = Integer.parseInt(opcaoStr);

            switch (opcao) {
                case 1:
                    adicionarCliente();
                    break;
                case 2:
                    chamarCliente();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo do sistema...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Digite novamente.");
            }

        } while (opcao != 0);
    }

    private static void adicionarCliente() {
        String nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente:");
        int anoNascimento = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de nascimento do cliente:"));

        Cliente cliente = new Cliente(nomeCliente, anoNascimento);

        if (cliente.isPrioritario()) {
            adicionarClienteNaFila(cliente, filaPrioritaria, indicePrioritaria);
            indicePrioritaria++;
        } else {
            adicionarClienteNaFila(cliente, filaNormal, indiceNormal);
            indiceNormal++;
        }
    }

    private static void adicionarClienteNaFila(Cliente cliente, Cliente[] fila, int indice) {
        if (indice < tam_fila) {
            fila[indice] = cliente;
            JOptionPane.showMessageDialog(null, "Cliente " + cliente.getNome() + " adicionado à fila. Senha: " + cliente.getSenha());
        } else {
            JOptionPane.showMessageDialog(null, "A fila está cheia. Não é possível adicionar mais clientes.");
        }
    }

   private static void chamarCliente() {
    if (contadorPrioritarios < indiceNormal * 2 && indicePrioritaria > 0) {
        Cliente cliente = filaPrioritaria[0];
        deslocarFila(filaPrioritaria, indicePrioritaria);
        indicePrioritaria--;
        JOptionPane.showMessageDialog(null, "Cliente chamado: " + cliente.getNome() + " (Prioritário). Senha: " + cliente.getSenha());
        contadorPrioritarios++;
    } else if (indiceNormal > 0) {
        Cliente cliente = filaNormal[0];
        deslocarFila(filaNormal, indiceNormal);
        indiceNormal--;
        JOptionPane.showMessageDialog(null, "Cliente chamado: " + cliente.getNome() + " (Normal). Senha: " + cliente.getSenha());
        contadorPrioritarios = 0;
    } else {
        JOptionPane.showMessageDialog(null, "Não há clientes na fila para atendimento.");
    }
}

    private static void deslocarFila(Cliente[] fila, int indice) {
        for (int i = 0; i < indice - 1; i++) {
            fila[i] = fila[i + 1];
        }
        fila[indice - 1] = null;
    }
}
