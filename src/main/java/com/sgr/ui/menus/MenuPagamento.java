package com.sgr.ui.menus;

import java.util.List;

import com.sgr.fachada.Fachada;
import com.sgr.fachada.dto.PagamentoDTO;
import com.sgr.ui.TerminalUtils;

public class MenuPagamento extends MenuTerminal {

    public MenuPagamento(Fachada fachada) {
        super(fachada, "SGR - Pagamentos");
    }

    protected void mostrarOpcoes() {
        System.out.println("1. Adicionar Pagamento");
        System.out.println("2. Remover Pagamento");
        System.out.println("3. Listar Pagamentos");
        System.out.println("0. Sair");
    }

    protected boolean tratarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                // menuPedidos;
                break;
            case 2:
                // menuPagamento.exibir();
                break;
            case 3:
                listarPagamentos();
                break;
            case 0:
                return false;
            default:
                System.out.println("Opção inválida, tente novamente.");
                break;
        }
        return true;
    }

    private void listarPagamentos() {
        List<PagamentoDTO> pagamentos = fachada.listarPagamentos();
        
        if (pagamentos.isEmpty()) {
            System.out.println("Nenhum pagamento cadastrado.");
        } else {
            for (PagamentoDTO pagamento : pagamentos) {
                System.out.println(pagamento);
            }
        }
        
        TerminalUtils.esperarEnter();
    }
}