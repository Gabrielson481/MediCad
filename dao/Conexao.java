/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_poo2.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane; 

public class Conexao {

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/POO2";
    private static final String USUARIO = "postgres";         // ou outro usuário do PostgreSQL
    private static final String SENHA = "fera123ga";     // a senha que você usa no pgAdmin


    public static Connection getConection() {
        Connection conexao = null;
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o driver JDBC: " + e.getMessage(), "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados: " + e.getMessage(), "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return conexao; 
    }

    public static void fecharConexao(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão com o banco de dados fechada.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão com o banco de dados: " + e.getMessage(), "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }
}