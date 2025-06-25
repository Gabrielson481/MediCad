package com.mycompany.projeto_poo2;

public class Usuario {
    protected String nome_usuario;
    protected String senha;

    public Usuario(String nome, String senha) {
        this.nome_usuario = nome;
        this.senha = senha;
    }

    public boolean login(String nome, String senha) {
        return this.nome_usuario.equals(nome) && this.senha.equals(senha);
    }

    public String getNome() {
        return nome_usuario;
    }

    public void setNome(String nome) {
        this.nome_usuario = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
