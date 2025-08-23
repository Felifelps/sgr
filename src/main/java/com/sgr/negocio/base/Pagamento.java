package com.sgr.negocio.base;

public abstract class Pagamento {
    protected int id;
    protected double valor;

    public Pagamento(int id, double valor) {
        this.id = id;
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClasse()) return false;
        Pagamento pagamento = (Pagamento) o;
        return id == pagamento.id;
    }

    public int getId() {
        return this.id;
    }

    public double getValor() {
        return this.valor;
    }

    public abstract void processarPagamento();
}