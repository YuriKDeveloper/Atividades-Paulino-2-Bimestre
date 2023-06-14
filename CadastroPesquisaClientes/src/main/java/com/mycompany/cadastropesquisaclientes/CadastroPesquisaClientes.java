/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cadastropesquisaclientes;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author yuriz
 */
public class CadastroPesquisaClientes {

    private static Cliente[] clientes;
    private static int quantidadeClientes;

    public static void main(String[] args) {
        quantidadeClientes = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de clientes a cadastrar:"));
        clientes = new Cliente[quantidadeClientes];

        for (int i = 0; i < quantidadeClientes; i++) {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do cliente #" + (i + 1) + ":"));
            String nome = JOptionPane.showInputDialog("Informe o nome do cliente #" + (i + 1) + ":");
            String dataNascimento = JOptionPane.showInputDialog("Informe a data de nascimento do cliente #" + (i + 1) + ":");
            String cpf = JOptionPane.showInputDialog("Informe o CPF do cliente #" + (i + 1) + ":");

            clientes[i] = new Cliente(codigo, nome, dataNascimento, cpf);
        }

        Arrays.sort(clientes);

        int codigoPesquisa = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do cliente a pesquisar:"));
        int indiceCliente = pesquisarBinaria(codigoPesquisa);

        if (indiceCliente != -1) {
            Cliente clienteEncontrado = clientes[indiceCliente];
            JOptionPane.showMessageDialog(null, "Cliente encontrado:\n\n" +
                    "Código: " + clienteEncontrado.getCodigo() + "\n" +
                    "Nome: " + clienteEncontrado.getNome() + "\n" +
                    "Data de Nascimento: " + clienteEncontrado.getDataNascimento() + "\n" +
                    "CPF: " + clienteEncontrado.getCPF());
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
        }
}
    
    private static int pesquisarBinaria(int codigoPesquisa) {
        int inicio = 0;
        int fim = quantidadeClientes - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (clientes[meio].getCodigo() == codigoPesquisa) {
                return meio;
            }

            if (clientes[meio].getCodigo() < codigoPesquisa) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }
}

