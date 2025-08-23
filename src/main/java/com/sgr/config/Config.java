package com.sgr.config;

import java.io.*;
import java.util.Properties;

public class Config {
    /* Properties é subclasse de HashMap
    Salva dados no estilo chave:valor e
    pode ler e escrever em arquivos */

    private static Properties props = new Properties();
    private static final String CONFIG_FILE = "config.properties";

    static { // Bloco estático pra inicializar props ao carregar a classe
        try {
            File file = new File(CONFIG_FILE);

            if (!file.exists()) {
                // Cria o arquivo
                file.createNewFile();

                // Seta as propriedades padrão
                props.setProperty("csv_clientes", "csv/clientes.csv");
                props.setProperty("csv_itens", "csv/itens.csv");
                props.setProperty("csv_pagamentos", "csv/pagamentos.csv");
                props.setProperty("csv_pedidos", "csv/pedidos.csv");

                // Guarda as alterações novas
                try (FileOutputStream out = new FileOutputStream(file)) {
                    props.store(out, "Default Settings");
                }
            } else {
                // Carrega as propriedades do arquivo
                try (FileInputStream in = new FileInputStream(file)) {
                    props.load(in);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getConfig(String chave) {
        return props.getProperty(chave);
    }
}