package com.sgr.negocio.base;

public class PagamentoDinheiro extends Pagamento {
    @Override
    public void processarPagamento() {
        System.out.println(this.getValor(), "R$ pagos em dinheiro");
    }

    @Override
    public String toString() {
        return "PagamentoDinheiro{"
            + "id=" + this.id
            + "valor=" + this.valor
        + "}";
    }
}