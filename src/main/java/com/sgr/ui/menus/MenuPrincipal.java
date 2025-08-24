package com.sgr.ui.menus;

import com.sgr.fachada.Fachada;
import com.sgr.ui.TerminalUtils;

public class MenuPrincipal extends MenuTerminal {
    private MenuPedido menuPedido;
    private MenuCliente menuCliente;
    private MenuItem menuItem;
    private MenuPagamento menuPagamento;

    public MenuPrincipal(Fachada fachada) {
        super(fachada, "SGR");

        menuPedido = new MenuPedido(fachada);
        menuCliente = new MenuCliente(fachada);
        menuItem = new MenuItem(fachada);
        menuPagamento = new MenuPagamento(fachada);
    }

    protected void mostrarOpcoes() {
        System.out.println("1. Pedidos");
        System.out.println("2. Clientes");
        System.out.println("3. Itens");
        System.out.println("4. Pagamentos");
        System.out.println("0. Sair");
    }

    protected boolean tratarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                menuPedido.exibir();
                break;
            case 2:
                menuCliente.exibir();
                break;
            case 3:
                menuItem.exibir();
                break;
            case 4:
                menuPagamento.exibir();
                break;
            case 0:
                System.out.println("Saindo...");
                TerminalUtils.fecharScanner();
                return false;
            default:
                System.out.println("Opção inválida, tente novamente.");
                break;
        }
        return true;
    }
}