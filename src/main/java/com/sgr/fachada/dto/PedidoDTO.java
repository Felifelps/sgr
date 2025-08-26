package com.sgr.fachada.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

import com.sgr.negocio.base.Cliente;
import com.sgr.negocio.base.Item;
import com.sgr.negocio.base.Pagamento;
import com.sgr.negocio.base.Pedido;

public class PedidoDTO {
    public final int id;
    public final ClienteDTO cliente;
    public final List<ItemDTO> itens = new ArrayList<>();
    public final PagamentoDTO pagamento;
    public final LocalDate data;

    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.cliente = new ClienteDTO(pedido.getCliente());
        
        for (Item item : pedido.getItens()) {
            this.itens.add(new ItemDTO(item));
        }

        if (pedido.getPagamento() != null) {
            this.pagamento = new PagamentoDTO(pedido.getPagamento());
        } else {
            this.pagamento = null;
        }

        this.data = pedido.getData();
    }

    public PedidoDTO(int id, ClienteDTO cliente, LocalDate data, PagamentoDTO pagamento) {
        this.id = id;
        this.cliente = cliente;
        this.pagamento = pagamento;
        this.data = data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoDTO pedido = (PedidoDTO) o;
        return id == pedido.id;
    }

    @Override
    public String toString() {
        return "Pedido{"
            + "id=" + this.id + ","
            + "cliente=" + this.cliente + ","
            + "pagamento=" + this.pagamento + ","
            + "data=" + this.data + ","
            + "itens=" + this.itens
        + "}";
    }
} 