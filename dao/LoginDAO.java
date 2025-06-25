package com.mycompany.projeto_poo2.dao;

import com.mycompany.projeto_poo2.dao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginDAO {

    public boolean autenticar(String nome_usuario, String senha) {
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND senha = ?";

        try (Connection conexao = Conexao.getConection();
             PreparedStatement pst = conexao.prepareStatement(sql)) {

            pst.setString(1, nome_usuario);
            pst.setString(2, senha);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // Se encontrou um usuário, retorna true
                return true;
            } else {
                // Usuário não encontrado
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao autenticar usuário: " + e.getMessage(),
                    "Erro de Login", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }
}
