package com.sgr.ui;

import java.util.Scanner;

public class TerminalUtils {
    private static Scanner sc = new Scanner(System.in);

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int lerOpcao() {
        while (true) {
            System.out.print("Digite uma opção: ");
            String entrada = sc.nextLine().trim();

            if (entrada.isEmpty()) {
                System.out.println("Digite novamente.");
                continue;
            }

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número.");
            }
        }
    }

    public static void esperarEnter() {
        System.out.println("Pressione Enter para continuar...");
        sc.nextLine();
    }

    public static void fecharScanner() {
        sc.close();
    }
}