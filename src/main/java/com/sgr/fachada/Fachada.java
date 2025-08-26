package com.sgr.fachada;

import java.util.ArrayList;
import java.util.List;

import com.sgr.dados.*;
import com.sgr.negocio.base.*;
import com.sgr.negocio.services.*;
import com.sgr.fachada.dto.*;

public class Fachada {
    public ClienteRepoCSV clienteRepo;
    public ItemRepoCSV itemRepo;
    public PagamentoRepoCSV pagamentoRepo;
    public PedidoRepoCSV pedidoRepo;

    public ClienteService clienteService;
    public ItemService itemService;
    public PagamentoService pagamentoService;
    public PedidoService pedidoService;

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

    public void adicionarCliente(String cpf, String nome, String telefone) throws Exception {
        clienteService.adicionar(cpf, nome, telefone);
    }

    public void adicionarItem(String nome, double preco, String descricao) throws Exception {
        itemService.adicionar(nome, preco, descricao);
    }

    public void adicionarPagamento(double valor, String tipo) throws Exception {
        pagamentoService.adicionar(valor, tipo);
    }

    public void adicionarPedido(String cpfCliente) throws Exception {
        pedidoService.adicionar(cpfCliente);
    }

    public void adicionariItemAPedido(int idPedido, int idItem) throws Exception {
        pedidoService.adicionarItem(idPedido, idItem);
    }

    public PedidoDTO verPedido(int idPedido) throws Exception {
        return new PedidoDTO(pedidoService.verPedido(idPedido));
    }

    public void removerCliente(String cpf) throws Exception {
        clienteService.remover(cpf);
    }

    public void removerItem(int id) throws Exception {
        itemService.remover(id);
    }

    public void removerPagamento(int id) throws Exception {
        pagamentoService.remover(id);
    }
}