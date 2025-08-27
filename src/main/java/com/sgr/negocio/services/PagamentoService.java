package com.sgr.negocio.services;

import java.util.List;

import com.sgr.dados.PagamentoRepoCSV;
import com.sgr.negocio.base.Pagamento;
import com.sgr.negocio.base.PagamentoPix;
import com.sgr.negocio.base.PagamentoCartao;
import com.sgr.negocio.base.PagamentoDinheiro;
import com.sgr.negocio.exceptions.CampoInvalidoException;
import com.sgr.negocio.exceptions.ObjetoNaoEncontradoException;

public class PagamentoService {
    private PagamentoRepoCSV repo;

    public PagamentoService(PagamentoRepoCSV repo) {
        this.repo = repo;
    }

    public List<Pagamento> listar() {
        return repo.listar();
    }

    public void adicionar(double valor, String tipo) throws Exception {
        String mensagem = "";

        if (valor <= 0)
            mensagem = "Valor inválido.";
        else if (!tipo.equals("pix") && !tipo.equals("dinheiro") && !tipo.equals("cartao")) 
            mensagem = "Tipo não permitido (apenas pix, cartao ou dinheiro)";

        if (!mensagem.isEmpty()) throw new CampoInvalidoException(mensagem);

        int maior_id = 0;
        for (Pagamento p : repo.listar()) if (p.getId() > maior_id) maior_id = p.getId();       

        Pagamento p;
        if (tipo.equals("pix"))
            p = new PagamentoPix(maior_id + 1, valor);
        else if (tipo.equals("cartao"))
            p = new PagamentoCartao(maior_id + 1, valor);
        else // dinheiro
            p = new PagamentoDinheiro(maior_id + 1, valor);

        repo.adicionar(p);
        repo.salvar();
    }

    public void remover(int id) throws Exception {
        Pagamento pagamento =repo.getObjectByIdentifier(id);
        if (pagamento == null) throw new ObjetoNaoEncontradoException("Pagamento de id '" + id + "'");
        repo.remover(pagamento);
        repo.salvar();
    }
}