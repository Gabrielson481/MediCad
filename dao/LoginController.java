package com.mycompany.projeto_poo2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginController {

    // Método para cadastrar novo usuário no banco
    public void cadastrarUsuario(String nome_usuario, String senha) {
        String sql = "INSERT INTO usuarios (nome_usuario, senha) VALUES (?, ?)";

        try (Connection conexao = Conexao.getConection();
             PreparedStatement pst = conexao.prepareStatement(sql)) {

            pst.setString(1, nome_usuario);
            pst.setString(2, senha);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e.getMessage());
        }
    }

    // Método para autenticar usuário
    public boolean autenticar(String nome_usuario, String senha) {
        String sql = "SELECT * FROM usuarios WHERE nome_usuario = ? AND senha = ?";

        try (Connection conexao = Conexao.getConection();
             PreparedStatement pst = conexao.prepareStatement(sql)) {

            pst.setString(1, nome_usuario);
            pst.setString(2, senha);

            ResultSet rs = pst.executeQuery();

            return rs.next(); // Retorna true se encontrou o usuário

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao autenticar: " + e.getMessage());
            return false;
        }
    }
}
