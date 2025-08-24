package com.sgr.negocio.exceptions;

public class CpfInUseException extends Exception {
    public CpfInUseException() {
        super("CPF já está em uso.");
    }
}