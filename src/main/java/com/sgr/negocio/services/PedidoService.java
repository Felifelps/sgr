package com.sgr.negocio.services;

import java.util.List;
import java.time.LocalDate;

import com.sgr.dados.PedidoRepoCSV;
import com.sgr.negocio.base.Cliente;
import com.sgr.negocio.base.Item;
import com.sgr.negocio.base.Pedido;
import com.sgr.negocio.exceptions.CampoInvalidoException;
import com.sgr.negocio.exceptions.ObjetoNaoEncontradoException;

public class PedidoService {
    private PedidoRepoCSV repo;

    public PedidoService(PedidoRepoCSV repo) {
        this.repo = repo;
    }

    public void adicionar(String cpfCliente) throws Exception{
        Cliente cliente = repo.getClienteRepo().getObjectByIdentifier(cpfCliente);
    
        if (cliente == null) throw new ObjetoNaoEncontradoException("Cliente de cpf '" + cpfCliente + "'");
    
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

    public void adicionarItem(int idPedido, int idItem) throws Exception{
        Pedido pedido = repo.getObjectByIdentifier((idPedido));
        if (pedido == null) throw new ObjetoNaoEncontradoException("Pedido de id '" + idItem + "'");
        
        Item item = repo.getItemRepo().getObjectByIdentifier(idItem);
        if (item == null) throw new ObjetoNaoEncontradoException("Item de id '" + idItem + "'");

        pedido.adicionarItem(item);
        repo.salvar();
    }

    public Pedido verPedido(int idPedido)  throws Exception {
        Pedido pedido = repo.getObjectByIdentifier((idPedido));
        if (pedido == null) throw new ObjetoNaoEncontradoException("Pedido de id '" + idPedido + "'");
        return pedido;
    }
}