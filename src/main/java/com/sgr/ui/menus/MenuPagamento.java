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
                adicionarPagamento();
                break;
            case 2:
                removerPagamento();
                break;
            case 3:
                listarPagamentos();
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

    private void adicionarPagamento() {
        try {
            double valor = 0.0;
            while (true) {
                try {
                    valor = Double.parseDouble(TerminalUtils.input("Valor: "));
                    if (valor == 0.0) return;
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Digite um valor válido (ou 0 para cancelar)");
                }
            }
            fachada.adicionarPagamento(
                valor,
                TerminalUtils.input("Tipo (pix,cartao,dinheiro): ")
            );
            mensagem = "Pagamento adicionado com sucesso!";
            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            TerminalUtils.esperarEnter();
        }
    }

    private void removerPagamento() {
        try {
            int id = 0;
            while (true) {
                try {
                    id = Integer.parseInt(TerminalUtils.input("Id: "));
                    if (id == 0) return;
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Digite um id válido (ou 0 para cancelar)");
                }
            }
            fachada.removerPagamento(id);
            mensagem = "Pagamento removido com sucesso!";
            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            TerminalUtils.esperarEnter();
        }
    }
}