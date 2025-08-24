package com.sgr.negocio.exceptions;

public class CampoInvalidoException extends Exception {

    private final String campo;

    public CampoInvalidoException(String campo, String mensagem) {
        super("Campo inválido [" + campo + "]: " + mensagem);
        this.campo = campo;
    }

    public String getCampo() {
        return campo;
    }
}
