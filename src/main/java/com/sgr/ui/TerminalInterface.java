package com.sgr.ui;

import com.sgr.fachada.Fachada;

import java.util.*;

public class TerminalInterface {

    private static final Scanner sc = new Scanner(System.in);
    private static final Fachada fachada = new Fachada();
    private static String currentPage;

    public static void run() {
        while (true) {
            try {
                limparTela();

                currentPage = "";

                mostrarTitulo();
                mostrarOpcoesMenuPadrao();

                int opcao = lerOpcao();

                switch (opcao) {
                    case 1 -> menuPedidos();
                    case 2 -> {
                        currentPage = "Clientes";
                        menuClientes();
                    }
                    case 3 -> {
                        currentPage = "Itens";
                        menuItens();
                    }
                    case 4 -> {
                        currentPage = "Pagamentos";
                        menuPagamentos();
                    }
                    case 0 -> {
                        System.out.println("Saindo...");
                        sc.close();
                        return;
                    }
                    default -> System.out.println("Opção inválida, tente novamente.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void menuPedidos() {
        while (true) {
            limparTela();

            currentPage = "Pedidos";
            
            mostrarOpcoesMenuPedido();

            
        }
    }

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public static int lerOpcao() {
        System.out.print("Escolha uma opção: ");
        while (!sc.hasNextInt()) {
            System.out.println("Entrada inválida. Digite um número.");
            sc.next();
            System.out.print("Escolha outra opção: ");
        }
        return sc.nextInt();
    }

    public static void mostrarTitulo() {
        System.out.print("Sistema de Gestão de Restaurante");
        if (!currentPage.isEmpty()) System.out.print("- " + currentPage);
        System.out.println();
    }

    public static void mostrarOpcoesMenuPadrao() {
        System.out.println("1. Pedidos");
        System.out.println("2. Clientes");
        System.out.println("3. Itens");
        System.out.println("4. Pagamentos");
        System.out.println("0. Sair");
    }
    
    public static void mostrarOpcoesMenuPedido() {
        System.out.println("1. Adicionar Pedido");
        System.out.println("2. Remover Pedido");
        System.out.println("3. Listar Pedidos");
        System.out.println("0. Voltar");
    }

    public static void mostrarOpcoesMenuItem() {
        System.out.println("1. Adicionar Item");
        System.out.println("2. Remover Item");
        System.out.println("3. Listar Itens");
        System.out.println("0. Voltar");
    }

    public static void mostrarOpcoesMenuCliente() {
        System.out.println("1. Adicionar Cliente");
        System.out.println("2. Remover Cliente");
        System.out.println("3. Listar Clientes");
        System.out.println("0. Voltar");
    }

    public static void mostrarOpcoesMenuPagamento() {
        System.out.println("1. Adicionar Pagamento");
        System.out.println("2. Remover Pagamento");
        System.out.println("3. Listar Pagamentos");
        System.out.println("0. Voltar");
    }
}