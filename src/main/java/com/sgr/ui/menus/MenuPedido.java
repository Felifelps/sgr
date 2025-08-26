package com.sgr.ui.menus;

import java.util.List;

import com.sgr.fachada.Fachada;
import com.sgr.fachada.dto.ClienteDTO;
import com.sgr.fachada.dto.ItemDTO;
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
                break;
        }
        return true;
    }

    private void adicionarPedido() {
        try {
            List<ClienteDTO> clientes = fachada.listarClientes();
        
            if (clientes.isEmpty()) {
                System.out.println("Nenhum cliente cadastrado.");
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
            System.out.println("Nenhum pedido cadastrado.");
        } else {
            for (PedidoDTO pedido : pedidos) {
                System.out.println(pedido);
            }
        }
        
        TerminalUtils.esperarEnter();
    }

    private void adicionarItensAPedido() {
        PedidoDTO pedido;
        while (true) {
            try {
                int id = Integer.parseInt(
                    TerminalUtils.input("Digite o id do pedido (0 para sair): "));
                if (id == 0) return;
                pedido = fachada.verPedido(id);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Id não válido.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        List<ItemDTO> itens = fachada.listarItens();
        
        if (itens.isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
            return;
        }

        for (ItemDTO item : itens) {
            System.out.println(item);
        }

        while (true) {
            try {
                int id = Integer.parseInt(
                    TerminalUtils.input("Digite o id do item (0 para sair): "));
                if (id == 0) break;
                fachada.adicionariItemAPedido(pedido.id, id);
            } catch (NumberFormatException e) {
                System.out.println("Id não válido.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void removerItensDePedido() {

    }

    private void associarPagamentoAPedido() {

    }

    private void verPedido() {

    }
}