package com.sgr.fachada;

import java.util.ArrayList;
import java.util.List;

import com.sgr.dados.*;
import com.sgr.negocio.base.*;
import com.sgr.negocio.services.*;
import com.sgr.fachada.dto.*;

public class Fachada {
    public static ClienteRepoCSV clienteRepo;
    public static ItemRepoCSV itemRepo;
    public static PagamentoRepoCSV pagamentoRepo;
    public static PedidoRepoCSV pedidoRepo;

    public static ClienteService clienteService;
    public static ItemService itemService;
    public static PagamentoService pagamentoService;
    public static PedidoService pedidoService;

    public Fachada() throws Exception {
        this.clienteRepo = new ClienteRepoCSV();
        this.clienteRepo.carregar();

        this.itemRepo = new ItemRepoCSV();
        this.itemRepo.carregar();

        this.pagamentoRepo = new PagamentoRepoCSV();
        this.pagamentoRepo.carregar();

        // Pedido por último pois requer os outros
        this.pedidoRepo = new PedidoRepoCSV(
            clienteRepo, itemRepo, pagamentoRepo
        );
        this.pedidoRepo.carregar();

        this.clienteService = new ClienteService(clienteRepo);
        this.itemService = new ItemService(itemRepo);
        this.pagamentoService = new PagamentoService(pagamentoRepo);
        this.pedidoService = new PedidoService(pedidoRepo);
    }

    public List<ClienteDTO> listarClientes() {
        return clienteService.listar()
            .stream()
            .map(ClienteDTO::new)
            .toList(); 
    }

    public List<PedidoDTO> listarPedidos() {
        return pedidoService.listar()
            .stream()
            .map(PedidoDTO::new)
            .toList(); 
    }

    public List<PagamentoDTO> listarPagamentos() {
        return pagamentoService.listar()
            .stream()
            .map(PagamentoDTO::new)
            .toList(); 
    }

    public List<ItemDTO> listarItens() {
        return itemService.listar()
            .stream()
            .map(ItemDTO::new)
            .toList(); 
    }
}