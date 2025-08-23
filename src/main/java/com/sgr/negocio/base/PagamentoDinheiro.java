package com.sgr.negocio.base;

import java.util.Objects;

public class PagamentoDinheiro extends Pagamento {
    
    public PagamentoDinheiro(int id, double valor) {
        super(id, valor);
    }
    
    @Override
    public void processarPagamento() {
        System.out.println(this.getValor() + "R$ pagos em dinheiro");
    }

    @Override
    public String toString() {
        return "PagamentoDinheiro{"
            + "id=" + this.id + ","
            + "valor=" + this.valor
        + "}";
    }
}