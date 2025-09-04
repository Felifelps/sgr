package com.sgr.negocio.base;

import java.io.Serializable;
import java.util.Objects;

public class PagamentoDinheiro extends Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;

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