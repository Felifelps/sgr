package com.sgr.negocio.base;

import java.util.Objects;

public class PagamentoPix extends Pagamento {

    public PagamentoPix(int id, double valor) {
        super(id, valor);
    }

    @Override
    public void processarPagamento() {
        System.out.println(this.getValor() + "R$ pagos em pix");
    }

    @Override
    public String toString() {
        return "PagamentoPix{"
            + "id=" + this.id + ","
            + "valor=" + this.valor
        + "}";
    }
}