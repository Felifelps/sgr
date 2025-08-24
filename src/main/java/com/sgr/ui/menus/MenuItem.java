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
                // menuPedidos;
                break;
            case 2:
                // menuItem.exibir();
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
}