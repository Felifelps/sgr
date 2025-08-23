package com.sgr.ui;

import com.sgr.dados.*;
import com.sgr.negocio.base.*;

import java.util.*;

public class TerminalInterface {

    public static void run() {
        try {
            ClienteRepoCSV clienteRepo = new ClienteRepoCSV();
            clienteRepo.carregar();
            ItemRepoCSV itemRepo = new ItemRepoCSV();
            itemRepo.carregar();
            PagamentoRepoCSV pagamentoRepo = new PagamentoRepoCSV();
            pagamentoRepo.carregar();

            PedidoRepoCSV pedidoRepo = new PedidoRepoCSV(
                clienteRepo,
                itemRepo,
                pagamentoRepo
            );
            pedidoRepo.carregar();
            
            Cliente cliente = clienteRepo.listar().get(0);
            Item item1 = itemRepo.listar().get(0);
            Item item2 = itemRepo.listar().get(1);
            Pagamento pagamento = pagamentoRepo.listar().get(0);

            Pedido pedido = new Pedido(
                1,
                cliente,
                new Date()
            );

            //pedido.adicionarItem(item1);
            //pedido.adicionarItem(item2);
            pedido.setPagamento(pagamento);

            pedidoRepo.adicionar(pedido);

            List<Pedido> pedidos = pedidoRepo.listar();

            for (Pedido o : pedidos) {
                System.out.println(o);
            }

            //pedidoRepo.salvar();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}