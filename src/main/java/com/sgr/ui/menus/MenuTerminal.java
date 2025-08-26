package com.sgr.ui.menus;

import com.sgr.fachada.Fachada;
import com.sgr.ui.TerminalUtils;

public abstract class MenuTerminal {
    protected String titulo;
    protected Fachada fachada;
    protected String mensagem = "";

    public MenuTerminal(Fachada fachada, String titulo) {
        this.titulo = titulo;
        this.fachada = fachada;
    }

    public void exibir() {
        while (true) {
            try {
                TerminalUtils.limparTela();
                
                System.out.println(titulo);
                exibirMensagem();

                mostrarOpcoes();
                
                int opcao = TerminalUtils.lerOpcao();
                if (!tratarOpcao(opcao)) return;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void exibirMensagem() {
        System.out.println(mensagem);
        mensagem = "";
    }

    protected abstract void mostrarOpcoes();
    protected abstract boolean tratarOpcao(int opcao);
}