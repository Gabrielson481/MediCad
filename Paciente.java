package com.mycompany.projeto_poo2;

public class Paciente {
    private String nome;
    private String cpf;
    private String historicoMedico;

    public Paciente(String nome, String cpf, String historicoMedico) {
        this.nome = nome;
        this.cpf = cpf;
        this.historicoMedico = historicoMedico;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getHistoricoMedico() {
        return historicoMedico;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setHistoricoMedico(String historicoMedico) {
        this.historicoMedico = historicoMedico;
    }

    public String resumo() {
        return "Paciente: " + nome + ", CPF: " + cpf;
    }
}
