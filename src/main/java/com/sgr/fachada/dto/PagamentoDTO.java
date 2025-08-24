package com.sgr.fachada.dto;

import java.util.Objects;

import com.sgr.negocio.base.Pagamento;
import com.sgr.negocio.base.PagamentoDinheiro;
import com.sgr.negocio.base.PagamentoCartao;
import com.sgr.negocio.base.PagamentoPix;

public class PagamentoDTO {
    public final int id;
    public final double valor;
    public final String tipo;

    public PagamentoDTO(Pagamento pagamento) {
        this.id = pagamento.getId();
        this.valor = pagamento.getValor();

        if (pagamento instanceof PagamentoDinheiro) {
            this.tipo = "Dinheiro";
        } else if (pagamento instanceof PagamentoCartao) {
            this.tipo = "Cartao";
        } else if (pagamento instanceof PagamentoPix) {
            this.tipo = "Pix";
        } else {
            this.tipo = "Desconhecido";
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagamentoDTO pagamento = (PagamentoDTO) o;
        return id == pagamento.id;
    }

    @Override
    public String toString() {
        return "Pagamento{"
            + "id=" + this.id + ","
            + "valor=" + this.valor + ","
            + "tipo=" + this.tipo
        + "}";
    }
}