package com.sgr.fachada.dto;

import java.util.Objects;

import com.sgr.negocio.base.Item;

public class ItemDTO {
    public final int id;
    public final String nome;
    public final double preco;
    public final String descricao;

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.nome = item.getNome();
        this.preco = item.getPreco();
        this.descricao = item.getDescricao();
    }

    public ItemDTO(int id, String nome, double preco, String descricao) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDTO item = (ItemDTO) o;
        return id == item.id;
    }

    @Override
    public String toString() {
        return "Item{"
            + "id=" + this.id + ","
            + "nome=" + this.nome
        + "}";
    }
}