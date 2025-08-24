package com.sgr.negocio.services;

import java.util.List;

import com.sgr.dados.ItemRepoCSV;
import com.sgr.negocio.base.Item;

public class ItemService {
    private ItemRepoCSV repo;

    public ItemService(ItemRepoCSV repo) {
        this.repo = repo;
    }

    public List<Item> listar() {
        return repo.listar();
    }
}