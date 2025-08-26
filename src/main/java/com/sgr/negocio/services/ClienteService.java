package com.sgr.negocio.services;

import java.util.List;

import com.sgr.negocio.exceptions.CpfInUseException;
import com.sgr.negocio.exceptions.CampoInvalidoException;
import com.sgr.negocio.base.Cliente;
import com.sgr.dados.ClienteRepoCSV;

public class ClienteService {
    private ClienteRepoCSV repo;

    public ClienteService(ClienteRepoCSV repo) {
        this.repo = repo;
    }

    public List<Cliente> listar() {
        return repo.listar();
    }

    public void adicionar(Cliente cliente) throws Exception {
        String campo = "";
        String mensagem = "";

        if (cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
            campo = "CPF";
            mensagem = "CPF vazio ou indefinido.";
        } else if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            campo = "Nome";
            mensagem = "Nome vazio ou indefinido.";
        } else if (cliente.getTelefone() == null || cliente.getTelefone().isEmpty()) {
            campo = "Telefone";
            mensagem = "Telefone vazio ou indefinido.";
        }

        if (!campo.isEmpty()) {
            throw new CampoInvalidoException(campo, mensagem);
        }

        if (repo.getObjectByIdentifier(cliente.getCpf()) != null) {
            throw new CpfInUseException();
        }

        repo.adicionar(cliente);
    }
}