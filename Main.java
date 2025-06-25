package com.mycompany.projeto_poo2;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true); // ou FTela_Agendamento, Tela_Cadastro etc.
        });
    }
}
