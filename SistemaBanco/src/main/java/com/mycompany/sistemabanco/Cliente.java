/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabanco;

/**
 *
 * @author yuriz
 */
public class Cliente {
    private static int proximaSenha = 1;
    private String nome;
    private int anoNascimento;
    private int senha;

    public Cliente(String nome, int anoNascimento) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.senha = proximaSenha++;
    }

    public static int getProximaSenha() {
        return proximaSenha;
    }

    public static void setProximaSenha(int proximaSenha) {
        Cliente.proximaSenha = proximaSenha;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }
    
    

    public String getNome() {
        return nome;
    }

    public int getSenha() {
        return senha;
    }

    public boolean isPrioritario() {
        int anoAtual = java.time.LocalDate.now().getYear();
        int idade = anoAtual - anoNascimento;
        return idade > 65;
    }
}
