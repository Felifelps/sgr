package com.sgr.negocio.base;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<Item> itens = new ArrayList<>();
    private Pagamento pagamento;
    private Date data;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        setCliente(cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClasse()) return false;
        Pedido pedido = (Pedido) o;
        return id == pedido.id;
    }

    @Override
    public String toString() {
        return "Pedido{"
            + "id=" + this.id
            + "cliente=" + this.cliente
            + "pagamento=" + this.pagamento
            + "data=" + this.data
            + "itens=" + this.itens
        + "}";
    }

    public int getId() {
        return this.id;
    }

    public List<Item> getItens() {
        return this.itens;
    }

    public void adicionarItem(Item item) {
        this.itens.add(item);
    }

    public void removerItem(Item item) {
        this.itens.remove(item);
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pagamento getPagamento() {
        return this.pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Date getData() {
        return this.data;
    }
} 