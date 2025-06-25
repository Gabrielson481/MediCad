// ConsultaDAO.java
package com.mycompany.projeto_poo2.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.projeto_poo2.*;

public class ConsultaDAO {
    public void salvarConsulta(Consulta consulta) {
        String sql = "INSERT INTO consultas (nome_paciente, cpf_paciente, data_consulta, horario, nome_medico) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, consulta.getPaciente().getNome());
            stmt.setString(2, consulta.getPaciente().getCpf());
            stmt.setString(3, consulta.getData());
            stmt.setString(4, consulta.getHora());
            stmt.setString(5, consulta.getMedico().getNome());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Consulta> buscarHistoricoPorCpf(String cpf){
        List<Consulta> historico = new ArrayList<>();
        String sql = "SELECT data_consulta, horario, nome_medico, nome_paciente, cpf_paciente FROM consultas WHERE cpf_paciente = ?";

        try (Connection conn = Conexao.getConection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, cpf);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Paciente paciente = new Paciente(rs.getString("nome_paciente"), rs.getString("cpf_paciente"), "");

            Medico medico = new Medico(rs.getString("nome_medico"));
            Consulta consulta = new Consulta(rs.getString("data_consulta"), rs.getString("horario"), paciente, medico);
            historico.add(consulta);
        }
} catch (SQLException e) {
    e.printStackTrace();
}

return historico;
    }
}
