package com.sgr.negocio.services;

import java.util.List;
import java.time.LocalDate;

import com.sgr.dados.PedidoRepositorio;
import com.sgr.negocio.base.Cliente;
import com.sgr.negocio.base.Item;
import com.sgr.negocio.base.Pagamento;
import com.sgr.negocio.base.Pedido;
import com.sgr.negocio.exceptions.CampoInvalidoException;
import com.sgr.negocio.exceptions.ObjetoNaoEncontradoException;

public class PedidoService {
    private PedidoRepositorio repo;

    public PedidoService(PedidoRepositorio repo) {
        this.repo = repo;
    }

    public void adicionar(String cpfCliente) throws Exception {
        Cliente cliente = repo.getClienteByCpf(cpfCliente);
    
        if (cliente == null) throw new ObjetoNaoEncontradoException(
            "Cliente de cpf '" + cpfCliente + "'");
    
        int maior_id = 0;
        for (Pedido p : repo.listar()) if (p.getId() > maior_id) maior_id = p.getId();   

        repo.adicionar(
            new Pedido(maior_id + 1, cliente, LocalDate.now())
        );
        repo.salvar();
    }

    public List<Pedido> listar() {
        return repo.listar();
    }

    public void adicionarItem(int idPedido, int idItem) throws Exception {
        Pedido pedido = repo.getObjectByIdentifier((idPedido));
        if (pedido == null) throw new ObjetoNaoEncontradoException(
            "Pedido de id '" + idPedido + "'");
        
        Item item = repo.getItemById(idItem);
        if (item == null) throw new ObjetoNaoEncontradoException(
            "Item de id '" + idItem + "'");

        pedido.adicionarItem(item);
        repo.salvar();
    }

    public void removerItem(int idPedido, int idItem) throws Exception {
        Pedido pedido = repo.getObjectByIdentifier((idPedido));
        if (pedido == null) throw new ObjetoNaoEncontradoException(
            "Pedido de id '" + idPedido + "'");
        
        Item item = repo.getItemById(idItem);
        if (item == null) throw new ObjetoNaoEncontradoException(
            "Item de id '" + idItem + "'");

        pedido.removerItem(item);
        repo.salvar();
    }

    public void associarPagamentoAPedido(int idPedido, int idPagamento) throws Exception {
        Pedido pedido = repo.getObjectByIdentifier((idPedido));
        if (pedido == null) throw new ObjetoNaoEncontradoException(
            "Pedido de id '" + idPedido + "'");
        
        Pagamento pagamento = repo.getPagamentoById(idPagamento);
        if (pagamento == null) throw new ObjetoNaoEncontradoException(
            "Pagamento de id '" + idPagamento + "'");

        pedido.setPagamento(pagamento);
        repo.salvar();
    }

    public Pedido verPedido(int idPedido) throws Exception {
        Pedido pedido = repo.getObjectByIdentifier((idPedido));
        if (pedido == null) throw new ObjetoNaoEncontradoException(
            "Pedido de id '" + idPedido + "'");
        return pedido;
    }
}