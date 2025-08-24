package com.sgr.ui.menus;

import java.util.List;

import com.sgr.fachada.Fachada;
import com.sgr.fachada.dto.PedidoDTO;
import com.sgr.ui.TerminalUtils;

public class MenuPedido extends MenuTerminal {

    public MenuPedido(Fachada fachada) {
        super(fachada, "SGR - Pedidos");
    }

    protected void mostrarOpcoes() {
        System.out.println("1. Adicionar Pedido");
        System.out.println("2. Remover Pedido");
        System.out.println("3. Listar Pedidos");
        System.out.println("0. Sair");
    }

    protected boolean tratarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                // menuPedidos;
                break;
            case 2:
                // menuPedido.exibir();
                break;
            case 3:
                listarPedidos();
                break;
            case 0:
                return false;
            default:
                System.out.println("Opção inválida, tente novamente.");
                break;
        }
        return true;
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
}