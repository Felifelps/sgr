package com.sgr.ui;

import com.sgr.fachada.Fachada;
import com.sgr.ui.menus.MenuPrincipal;

import java.util.*;

public class TerminalInterface {

    private static Scanner sc = new Scanner(System.in);
    private static MenuPrincipal menuPrincipal;
    private static Fachada fachada;

    public static void run() {
        try {
            if (fachada == null) {
                fachada = new Fachada();
            }
        } catch (Exception e) {
            System.out.println("Erro ao iniciar o projeto: " + e);
        }

        menuPrincipal = new MenuPrincipal(fachada);
        menuPrincipal.exibir();
    }   
}