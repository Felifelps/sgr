package com.sgr.negocio.services;

import java.util.List;

import com.sgr.dados.PedidoRepoCSV;
import com.sgr.negocio.base.Pedido;

public class PedidoService {
    private PedidoRepoCSV repo;

    public PedidoService(PedidoRepoCSV repo) {
        this.repo = repo;
    }

    public List<Pedido> listar() {
        return repo.listar();
    }
}