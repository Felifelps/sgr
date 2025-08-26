package com.sgr.ui.menus;

import java.util.List;

import com.sgr.fachada.Fachada;
import com.sgr.fachada.dto.ItemDTO;
import com.sgr.ui.TerminalUtils;

public class MenuItem extends MenuTerminal {

    public MenuItem(Fachada fachada) {
        super(fachada, "SGR - Itens");
    }

    protected void mostrarOpcoes() {
        System.out.println("1. Adicionar Item");
        System.out.println("2. Remover Item");
        System.out.println("3. Listar Itens");
        System.out.println("0. Sair");
    }

    protected boolean tratarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                adicionarItem();
                break;
            case 2:
                removerItem();
                break;
            case 3:
                listarItens();
                break;
            case 0:
                return false;
            default:
                System.out.println("Opção inválida, tente novamente.");
                break;
        }
        return true;
    }

    private void listarItens() {
        List<ItemDTO> itens = fachada.listarItens();
        
        if (itens.isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
        } else {
            for (ItemDTO item : itens) {
                System.out.println(item);
            }
        }
        
        TerminalUtils.esperarEnter();
    }

    private void adicionarItem() {
        try {
            String nome = TerminalUtils.input("Nome: ");
            double preco = 0.0;
            while (true) {
                try {
                    preco = Double.parseDouble(TerminalUtils.input("Preço: "));
                    if (preco == 0.0) return;
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Digite um preço válido (ou 0 para cancelar)");
                }
            }
            fachada.adicionarItem(
                nome,
                preco,
                TerminalUtils.input("Descrição: ")
            );
            mensagem = "Item adicionado com sucesso!";
            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            TerminalUtils.esperarEnter();
        }
    }

    private void removerItem() {
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
            fachada.removerItem(id);
            mensagem = "Item removido com sucesso!";
            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            TerminalUtils.esperarEnter();
        }
    }
}