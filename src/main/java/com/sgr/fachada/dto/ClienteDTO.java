package com.sgr.fachada.dto;

import java.util.Objects;

import com.sgr.negocio.base.Cliente;

public class ClienteDTO {
    public final String cpf;
    public final String nome;
    public final String telefone;

    public ClienteDTO(Cliente cliente) {
        this.cpf = cliente.getCpf();
        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
    }

    public ClienteDTO(String cpf, String nome, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.cpf);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteDTO cliente = (ClienteDTO) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public String toString() {
        return "Cliente{"
            + "cpf=" + this.cpf + ","
            + "nome=" + this.nome + ","
            + "telefone=" + this.telefone
        + "}";
    }
}