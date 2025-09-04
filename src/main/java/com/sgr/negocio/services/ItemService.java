package com.sgr.negocio.services;

import java.util.List;

import com.sgr.dados.Repositorio;
import com.sgr.negocio.base.Item;
import com.sgr.negocio.exceptions.CampoInvalidoException;
import com.sgr.negocio.exceptions.ObjetoNaoEncontradoException;
import com.sgr.util.Validador;

public class ItemService {
    private Repositorio<Item> repo;

    public ItemService(Repositorio<Item> repo) {
        this.repo = repo;
    }

    public List<Item> listar() {
        return repo.listar();
    }

    public void adicionar(String nome, double preco, String descricao) throws Exception {
        String mensagem = "";

        if (preco <= 0)
            mensagem = "Preço inválido.";
        else if (nome == null || nome.isEmpty())
            mensagem = "Nome vazio ou indefinido.";
        else if (!Validador.validarNome(nome))
            mensagem = "Nome inválido.";
        else if (descricao == null || descricao.isEmpty())
            mensagem = "Descrição vazia ou indefinida.";

        if (!mensagem.isEmpty()) throw new CampoInvalidoException(mensagem);

        int maior_id = 0;
        for (Item i : repo.listar()) if (i.getId() > maior_id) maior_id = i.getId();       

        repo.adicionar(
            new Item(maior_id + 1, nome, preco, descricao)
        );
        repo.salvar();
    }

    public void remover(int id) throws Exception {
        Item item = repo.getObjectByIdentifier(id);
        if (item == null) throw new ObjetoNaoEncontradoException("Item de id '" + id + "'");
        repo.remover(item);
        repo.salvar();
    }
}