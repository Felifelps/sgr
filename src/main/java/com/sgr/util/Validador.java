package com.sgr.util;

public class Validador {

    public static boolean validarCPF(String cpf) {
        // Só os números
        return cpf != null && cpf.matches("\\d{11}");
    }

    public static boolean validarNome(String nome) {
        // Mínimo dois caracteres, letras e espaços
        return nome != null && nome.matches("[A-Za-zÀ-ÿ ']{2,}");
    }

    public static boolean validarTelefone(String telefone) {
        // 10 ou 11 números (DDD incluso)
        return telefone != null && telefone.matches("\\d{10,11}");
    }
}