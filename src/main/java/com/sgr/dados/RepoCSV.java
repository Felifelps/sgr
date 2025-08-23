package com.sgr.dados;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.util.*;
import java.io.*;

public abstract class RepoCSV<T> { // Tipo genérico T
    protected String arquivo;
    protected List<T> cache = new ArrayList<>();

    public RepoCSV(String arquivo) throws Exception{
        this.arquivo = arquivo;
    }

    // Métodos abstratos

    protected abstract ArrayList<String> toLine(T object);

    protected abstract T toObject(ArrayList<String> line);

    protected abstract List<String> getHeaders();

    protected abstract T getObjectByIdentifier(int identifier);
    protected abstract T getObjectByIdentifier(String identifier);

    public void salvar() throws Exception {
        // Inicializando o arquivo
        File file = new File(arquivo);

        // Setando a lista de linhas
        ArrayList<ArrayList<String>> linhas = new ArrayList<>();
        
        // Adiciona os headers
        linhas.add(new ArrayList<>(getHeaders()));
        
        // Transforma os objetos em cache para linhas
        for (T obj : cache) {
            linhas.add(toLine(obj));
        }

        // Garante que a pasta csv existe
        if (file.getParentFile() != null) {
            file.getParentFile().mkdirs();
        }
        
        // Reescreve tudo
        try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
            for (ArrayList<String> linha : linhas) {
                writer.writeNext(linha.toArray(new String[0]));
            }
        }
    }

    public void carregar() throws Exception {
        File file = new File(this.arquivo);
        
        // Se o arquivo existir, lê as linhas (pulando o header) e às converte num novo objeto
        if (file.exists()) {

            cache.clear();

            try (CSVReader reader = new CSVReader(new FileReader(file))) {
                List<String[]> todasLinhas = reader.readAll();
                for (int i = 1; i < todasLinhas.size(); i++) { // começa da linha 1
                    cache.add(toObject(new ArrayList<>(Arrays.asList(todasLinhas.get(i)))));
                }
            }
        }
    }

    public List<T> listar() {
        return cache;
    }

    public void adicionar(T obj) {
        cache.add(obj);
    }

    public void remover(T obj) {
        cache.remove(obj);
    }
}