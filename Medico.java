package com.mycompany.projeto_poo2;

public class Medico extends Usuario {
    private String horario;

    public Medico(String nome, String senha, String horario) {
        super(nome, senha);
        this.horario = horario;
    }
    
    public Medico(String nome) {
        super(nome, "");  
        this.horario = "";
    }
    public void visualizarAgenda() {
        System.out.println("Agenda do médico " + nome_usuario + ": " + horario);
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
