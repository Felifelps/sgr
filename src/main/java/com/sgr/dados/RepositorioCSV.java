package com.sgr.dados;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.util.*;
import java.io.*;

public abstract class RepositorioCSV<T> { // Tipo genérico T
    protected String arquivo;

    public RepositorioCSV(String arquivo) {
        this.arquivo = arquivo;
    }

    // Métodos abstratos pra cada conversão

    protected abstract ArrayList<String>> toLine(T object);

    protected abstract T toObject(ArrayList<String>> line);

    public void salvar(T obj) throws Exception {
        // Inicializando o arquivo
        File file = new File(arquivo)

        // Setando a lista de linhas
        ArrayList<ArrayList<String>> linhas = new ArrayList<>();

        // Se o arquivo existir, lê tudo
        if (file.exists()) {
            // Tenta criar um reader pra esse arquivo, senão solta uma exceção
            try (CSVReader reader = new CSVReader(new FileReader(file))) {
                String[] linha;
                // Enquanto houverem linhas, adiciona nas linhas
                while ((linha = reader.readNext()) != null) {
                    linhas.add(new ArrayList<>(List.of(linha)));
                }
            }
        }
        
        // Transforma o objeto em linha
        linhas.add(toLine(obj));

        // Reescreve tudo
        try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
            for (ArrayList<String> linha : linhas) {
                writer.writeNext(linha.toArray(new String[0]));
            }
        }

    }
}