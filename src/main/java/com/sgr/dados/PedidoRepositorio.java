package com.sgr.dados;

import com.sgr.negocio.base.Cliente;
import com.sgr.negocio.base.Item;
import com.sgr.negocio.base.Pagamento;
import com.sgr.negocio.base.Pedido;

public interface PedidoRepositorio extends Repositorio<Pedido> {
    Cliente getClienteByCpf(String cpf);
    Item getItemById(int id);
    Pagamento getPagamentoById(int id);
}
