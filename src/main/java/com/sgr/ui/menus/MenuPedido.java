package com.sgr.ui.menus;

import java.util.List;

import com.sgr.fachada.Fachada;
import com.sgr.fachada.dto.ClienteDTO;
import com.sgr.fachada.dto.ItemDTO;
import com.sgr.fachada.dto.PagamentoDTO;
import com.sgr.fachada.dto.PedidoDTO;
import com.sgr.ui.TerminalUtils;

public class MenuPedido extends MenuTerminal {

    public MenuPedido(Fachada fachada) {
        super(fachada, "SGR - Pedidos");
    }

    protected void mostrarOpcoes() {
        System.out.println("1. Adicionar pedido");
        System.out.println("2. Listar pedidos");
        System.out.println("3. Adicionar itens a pedido");
        System.out.println("4. Remover itens de pedido");
        System.out.println("5. Associar pagamento ao pedido");
        System.out.println("6. Ver pedido");
        System.out.println("0. Voltar");

    }

    protected boolean tratarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                adicionarPedido();
                break;
            case 2:
                listarPedidos();
                break;
            case 3:
                adicionarItensAPedido();
                break;
            case 4:
                removerItensDePedido();
                break;
            case 5:
                associarPagamentoAPedido();
                break;
            case 6:
                verPedido();
                break;
            case 0:
                return false;
            default:
                System.out.println("Opção inválida, tente novamente.");
                TerminalUtils.esperarEnter();
                break;
        }
        return true;
    }

    private void adicionarPedido() {
        try {
            List<ClienteDTO> clientes = fachada.listarClientes();
        
            if (clientes.isEmpty()) {
                mensagem = "Nenhum cliente cadastrado.";
                return;
            }

            for (ClienteDTO cliente : clientes) {
                System.out.println(cliente);
            }

            fachada.adicionarPedido(
                TerminalUtils.input("Cpf do Cliente: ")
            );

            mensagem = "Pedido adicionado com sucesso!";
            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            TerminalUtils.esperarEnter();
        }
    }

    private void listarPedidos() {
        List<PedidoDTO> pedidos = fachada.listarPedidos();
        
        if (pedidos.isEmpty()) {
            mensagem = "Nenhum pedido cadastrado.";
            return;
        }

        for (PedidoDTO pedido : pedidos) {
            System.out.println(pedido);
        }
        
        TerminalUtils.esperarEnter();
    }

    private void adicionarItensAPedido() {
        PedidoDTO pedido = verPedido();
        if (pedido == null) return;

        List<ItemDTO> itens = fachada.listarItens();
        
        if (itens.isEmpty()) {
            mensagem = "Nenhum item cadastrado.";
            return;
        }
        System.out.println("Itens disponíveis");

        for (ItemDTO item : itens) {
            System.out.println(item);
        }

        while (true) {
            try {
                int id = Integer.parseInt(
                    TerminalUtils.input("Digite o id do item (0 para sair): "));
                if (id == 0) break;
                fachada.adicionarItemPedido(pedido.id, id);
                mensagem = "Item(ns) adicionado(s) com sucesso";
            } catch (NumberFormatException e) {
                System.out.println("Id não válido.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void removerItensDePedido() {
        PedidoDTO pedido = verPedido();
        if (pedido == null) return;
        
        if (pedido.itens.isEmpty()) {
            mensagem = "Nenhum item associado ao pedido.";
            return;
        }
        System.out.println("Itens do pedido " + pedido.id);

        for (ItemDTO item : pedido.itens) {
            System.out.println(item);
        }

        while (true) {
            try {
                int id = Integer.parseInt(
                    TerminalUtils.input("Digite o id do item (0 para sair): "));
                if (id == 0) break;
                fachada.removerItemPedido(pedido.id, id);
                mensagem = "Item(ns) removido(s) com sucesso";
            } catch (NumberFormatException e) {
                System.out.println("Id não válido.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void associarPagamentoAPedido() {
        PedidoDTO pedido = verPedido();
        if (pedido == null) return;

        if (pedido.pagamento != null) {
            mensagem = "Um pagamento já foi associado a esse pedido";
            return;
        }

        List<PagamentoDTO> pagamentos = fachada.listarPagamentos();
        
        if (pagamentos.isEmpty()) {
            mensagem = "Nenhum pagamento cadastrado.";
            return;
        }
        System.out.println("Pagamentos disponíveis");

        for (PagamentoDTO pagamento : pagamentos) {
            System.out.println(pagamento);
        }

        while (true) {
            try {
                int id = Integer.parseInt(
                    TerminalUtils.input("Digite o id do pagamento (0 para sair): "));
                if (id == 0) break;
                fachada.associarPagamentoAPedido(pedido.id, id);
                mensagem = "Pagamento associado com sucesso";
                return;
            } catch (NumberFormatException e) {
                System.out.println("Id não válido.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private PedidoDTO verPedido() {
        while (true) {
            try {
                int id = Integer.parseInt(
                    TerminalUtils.input("Digite o id do pedido (0 para sair): "));
                if (id == 0) return null;
                return fachada.verPedido(id);
            } catch (NumberFormatException e) {
                System.out.println("Id não válido.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}