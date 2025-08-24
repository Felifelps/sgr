package com.sgr.negocio.services;

import java.util.List;

import com.sgr.dados.ClienteRepoCSV;
import com.sgr.negocio.base.Cliente;

public class ClienteService {
    private ClienteRepoCSV repo;

    public ClienteService(ClienteRepoCSV repo) {
        this.repo = repo;
    }

    public List<Cliente> listar() {
        return repo.listar();
    }
}