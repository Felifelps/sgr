package com.sgr.ui.menus;

import java.util.List;

import com.sgr.fachada.Fachada;
import com.sgr.fachada.dto.ClienteDTO;
import com.sgr.ui.TerminalUtils;

public class MenuCliente extends MenuTerminal {

    public MenuCliente(Fachada fachada) {
        super(fachada, "SGR - Clientes");
    }

    protected void mostrarOpcoes() {
        System.out.println("1. Adicionar Cliente");
        System.out.println("2. Remover Cliente");
        System.out.println("3. Listar Clientes");
        System.out.println("0. Sair");
    }

    protected boolean tratarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                adicionarCliente();
                break;
            case 2:
                removerCliente();
                break;
            case 3:
                listarClientes();
                break;
            case 0:
                return false;
            default:
                System.out.println("Opção inválida, tente novamente.");
                break;
        }
        return true;
    }

    private void listarClientes() {
        List<ClienteDTO> clientes = fachada.listarClientes();
        
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (ClienteDTO cliente : clientes) {
                System.out.println(cliente);
            }
        }
        
        TerminalUtils.esperarEnter();
    }

    private void adicionarCliente() {
        try {
            fachada.adicionarCliente(
                TerminalUtils.input("CPF: "),
                TerminalUtils.input("Nome: "),
                TerminalUtils.input("Telefone: ")
            );
            mensagem = "Cliente adicionado com sucesso!";
            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            TerminalUtils.esperarEnter();
        }
    }

    private void removerCliente() {
        try {
            fachada.removerCliente(
                TerminalUtils.input("CPF: ")
            );
            mensagem = "Cliente removido com sucesso!";
            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            TerminalUtils.esperarEnter();
        }
    }
}