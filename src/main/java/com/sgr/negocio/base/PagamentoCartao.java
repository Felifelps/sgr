package com.sgr.negocio.base;

import java.util.Objects;

public class PagamentoCartao extends Pagamento {

    public PagamentoCartao(int id, double valor) {
        super(id, valor);
    }

    @Override
    public void processarPagamento() {
        System.out.println(this.getValor() + "R$ pagos via cartão");
    }

    @Override
    public String toString() {
        return "PagamentoCartao{"
            + "id=" + this.id + ","
            + "valor=" + this.valor
        + "}";
    }
}