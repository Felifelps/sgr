package com.sgr.negocio.base;

public class PagamentoPix extends Pagamento {
    @Override
    public void processarPagamento() {
        System.out.println(this.getValor(), "R$ pagos em pix");
    }

    @Override
    public String toString() {
        return "PagamentoPix{"
            + "id=" + this.id
            + "valor=" + this.valor
        + "}";
    }
}