package com.sgr.negocio.base;

public class PagamentoCartao extends Pagamento {
    @Override
    public void processarPagamento() {
        System.out.println(this.getValor(), "R$ pagos via cartão");
    }

    @Override
    public String toString() {
        return "PagamentoCartao{"
            + "id=" + this.id
            + "valor=" + this.valor
        + "}";
    }
}