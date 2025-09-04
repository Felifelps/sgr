package com.sgr.dados;

import com.sgr.negocio.base.*;
import com.sgr.util.Config;

public class RepositorioFactory {
    public static Repositorio<Cliente> criarClienteRepo() throws Exception {
        String tipo = Config.getConfig("tipo");
        if ("csv".equalsIgnoreCase(tipo)) {
            return new ClienteRepoCSV(Config.getConfig("csv_clientes"));
        } else {
            return new ClienteRepoBinario(Config.getConfig("dat_clientes"));
        }
    }

    public static Repositorio<Item> criarItemRepo() throws Exception {
        String tipo = Config.getConfig("tipo");
        if ("csv".equalsIgnoreCase(tipo)) {
            return new ItemRepoCSV(Config.getConfig("csv_itens"));
        } else {
            return new ItemRepoBinario(Config.getConfig("dat_itens"));
        }
    }

    public static Repositorio<Pagamento> criarPagamentoRepo() throws Exception {
        String tipo = Config.getConfig("tipo");
        if ("csv".equalsIgnoreCase(tipo)) {
            return new PagamentoRepoCSV(Config.getConfig("csv_pagamentos"));
        } else {
            return new PagamentoRepoBinario(Config.getConfig("dat_pagamentos"));
        }
    }

    public static PedidoRepositorio criarPedidoRepo(
        Repositorio<Cliente> clienteRepo,
        Repositorio<Item> itemRepo,
        Repositorio<Pagamento> pagamentoRepo
    ) throws Exception {
        String tipo = Config.getConfig("tipo");
        if ("csv".equalsIgnoreCase(tipo)) {
            return new PedidoRepoCSV(Config.getConfig("csv_pedidos"), clienteRepo, itemRepo, pagamentoRepo);
        } else {
            return new PedidoRepoBinario(Config.getConfig("dat_pedidos"), clienteRepo, itemRepo, pagamentoRepo);
        }
    }
}
