package com.sgr.negocio.services;

import java.util.List;

import com.sgr.dados.PagamentoRepoCSV;
import com.sgr.negocio.base.Pagamento;

public class PagamentoService {
    private PagamentoRepoCSV repo;

    public PagamentoService(PagamentoRepoCSV repo) {
        this.repo = repo;
    }

    public List<Pagamento> listar() {
        return repo.listar();
    }
}