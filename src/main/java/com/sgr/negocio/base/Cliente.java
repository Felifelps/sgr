package com.sgr.negocio.base;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

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
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public String toString() {
        return "Cliente{"
            + "cpf=" + this.cpf + ","
            + "nome=" + this.nome
        + "}";
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}