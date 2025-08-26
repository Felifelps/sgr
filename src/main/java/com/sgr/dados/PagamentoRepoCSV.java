package com.sgr.dados;

import com.sgr.util.Config;
import com.sgr.negocio.base.Pagamento;
import com.sgr.negocio.base.PagamentoPix;
import com.sgr.negocio.base.PagamentoCartao;
import com.sgr.negocio.base.PagamentoDinheiro;

import java.util.ArrayList;
import java.util.List;

public class PagamentoRepoCSV extends RepoCSV<Pagamento> {

    public PagamentoRepoCSV() throws Exception {
        super(Config.getConfig("csv_pagamentos"));
    }

    @Override
    public Pagamento getObjectByIdentifier(int id) {
        for (Pagamento p : listar()) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public Pagamento getObjectByIdentifier(String identifier) {
        throw new UnsupportedOperationException("Pagamento não tem ID textual");
    }

    @Override
    protected ArrayList<String> toLine(Pagamento pagamento) {
        ArrayList<String> line = new ArrayList<>();

        line.add(String.valueOf(pagamento.getId()));
        line.add(String.valueOf(pagamento.getValor()));

        String type = "";

        if (pagamento instanceof PagamentoPix) type = "pix";
        else if (pagamento instanceof PagamentoDinheiro) type = "dinheiro";
        else type = "cartao";
        
        line.add(type);

        return line;
    }

    @Override
    protected Pagamento toObject(ArrayList<String> line) {
        int id = Integer.parseInt(line.get(0));
        double valor = Double.parseDouble(line.get(1));

        switch (line.get(2)) {
            case "pix": return new PagamentoPix(id, valor);
            case "dinheiro": return new PagamentoDinheiro(id, valor);
            case "cartao": return new PagamentoCartao(id, valor);
            default: throw new IllegalArgumentException("Tipo de pagamento inválido: " + line.get(2));
        }    
    }

    @Override
    protected List<String> getHeaders() {
        String[] headers = {"id", "valor", "type"};
        return List.of(headers);
    }
}