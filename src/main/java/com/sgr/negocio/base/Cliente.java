package com.sgr.negocio.base;

import java.util.Objects;

public class Cliente {
    private String cpf;
    private String nome;
    private String telefone;

    public Cliente(String cpf, String nome, String telefone) {
        this.cpf = cpf;
        setNome(nome);
        setTelefone(telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.cpf);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClasse()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public String toString() {
        return "Cliente{"
            + "cpf=" + this.cpf
            + "nome=" + this.nome
        + "}";
    }

    public int getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}