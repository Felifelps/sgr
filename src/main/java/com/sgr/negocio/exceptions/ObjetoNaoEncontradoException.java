package com.sgr.negocio.exceptions;

public class ObjetoNaoEncontradoException extends Exception {

    public ObjetoNaoEncontradoException(String objeto) {
        super(objeto + " não encontrado.");
    }
}
