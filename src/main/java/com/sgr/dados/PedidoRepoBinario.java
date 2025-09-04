package com.sgr.dados;

import com.sgr.negocio.base.*;
import com.sgr.util.Config;

public class PedidoRepoBinario extends RepoBinario<Pedido> implements PedidoRepositorio {
    private Repositorio<Cliente> clienteRepo;
    private Repositorio<Item> itemRepo;
    private Repositorio<Pagamento> pagamentoRepo;

    public PedidoRepoBinario(
        String arquivo,
        Repositorio<Cliente> clienteRepo,
        Repositorio<Item> itemRepo,
        Repositorio<Pagamento> pagamentoRepo
    ) throws Exception {
        super(arquivo);
        this.clienteRepo = clienteRepo;
        this.itemRepo = itemRepo;
        this.pagamentoRepo = pagamentoRepo;
    }

    public Repositorio<Cliente> getClienteRepo() {
        return clienteRepo;
    }

    public Repositorio<Item> getItemRepo() {
        return itemRepo;
    }

    public Repositorio<Pagamento> getPagamentoRepo() {
        return pagamentoRepo;
    }

    @Override
    public Cliente getClienteByCpf(String cpf) {
        return clienteRepo.getObjectByIdentifier(cpf);
    }

    @Override
    public Item getItemById(int id) {
        return itemRepo.getObjectByIdentifier(id);
    }

    @Override
    public Pagamento getPagamentoById(int id) {
        return pagamentoRepo.getObjectByIdentifier(id);
    }

    @Override
    public Pedido getObjectByIdentifier(int id) {
        for (Pedido p : cache) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Pedido getObjectByIdentifier(String identifier) {
        throw new UnsupportedOperationException("Pedido não tem ID textual");
    }
}
