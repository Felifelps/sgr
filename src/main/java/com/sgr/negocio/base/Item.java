package com.sgr.negocio.base;

public class Item {
    private int id;
    private String nome;
    private double preco;
    private String descricao;

    public Item(int id, String nome, double preco, String descricao) {
        this.id = id;
        setNome(nome);
        setPreco(preco);
        setDescricao(descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClasse()) return false;
        Item item = (Item) o;
        return id == item.id;
    }

    @Override
    public String toString() {
        return "Item{"
            + "id=" + this.id
            + "nome=" + this.nome
        + "}";
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return this.nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return this.nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}