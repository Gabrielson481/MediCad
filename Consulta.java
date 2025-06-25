package com.mycompany.projeto_poo2;

public class Consulta {
    private String data;
    private String hora;
    private Paciente paciente;
    private Medico medico;

    public Consulta(String data, String hora, Paciente paciente, Medico medico) {
        this.data = data;
        this.hora = hora;
        this.paciente = paciente;
        this.medico = medico;
    }

    public void registrar() {
        System.out.println("Consulta registrada:");
        System.out.println("Médico: " + medico.getNome());
        System.out.println("Paciente: " + paciente.getNome() + ", CPF: " + paciente.getCpf());
        System.out.println("Data: " + data);
        System.out.println("Hora: " + hora);
    }

    public String resumo() {
        return "Consulta de " + paciente.getNome() +
                " com Dr(a). " + medico.getNome() +
                " em " + data + " às " + hora;
    }

    // Getters e Setters
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
