package com.sgr.dados;

import com.sgr.util.Config;
import com.sgr.negocio.base.*;

import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class PedidoRepoCSV extends RepoCSV<Pedido> {
    private ClienteRepoCSV clienteRepo;
    private ItemRepoCSV itemRepo;
    private PagamentoRepoCSV pagamentoRepo;

    public PedidoRepoCSV(
        ClienteRepoCSV clienteRepo,
        ItemRepoCSV itemRepo,
        PagamentoRepoCSV pagamentoRepo
    ) throws Exception {
        super(Config.getConfig("csv_pedidos"));

        this.clienteRepo = clienteRepo;
        this.itemRepo = itemRepo;
        this.pagamentoRepo = pagamentoRepo;

    }

    public ClienteRepoCSV getClienteRepo() {
        return clienteRepo;
    }

    public ItemRepoCSV getItemRepo() {
        return itemRepo;
    }

    public PagamentoRepoCSV getPagamentoRepo() {
        return pagamentoRepo;
    }

    @Override
    public Pedido getObjectByIdentifier(int id) {
        for (Pedido p : listar()) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    @Override
    public Pedido getObjectByIdentifier(String identifier) {
        throw new UnsupportedOperationException("Pedido não tem ID textual");
    }

    @Override
    protected ArrayList<String> toLine(Pedido pedido) {
        ArrayList<String> line = new ArrayList<>();

        line.add(String.valueOf(pedido.getId()));
        line.add(String.valueOf(pedido.getCliente().getCpf()));

        String pagamentoStr = (pedido.getPagamento() == null) ? "" : String.valueOf(pedido.getPagamento().getId());

        line.add(pagamentoStr);

        String dataISO = pedido.getData().format(DateTimeFormatter.ISO_LOCAL_DATE);
        line.add(dataISO);

        String itensStr = pedido.getItens().stream()
            .map(item -> String.valueOf(item.getId()))
            .reduce((a, b) -> a + "-" + b)
            .orElse("");
        
        line.add(itensStr);

        return line;
    }

    @Override
    protected Pedido toObject(ArrayList<String> line) {
        int id = Integer.parseInt(line.get(0));

        String cpf = line.get(1);
        Cliente cliente = clienteRepo.getObjectByIdentifier(cpf);

        Pagamento pagamento = null;
        if (!line.get(2).isEmpty()) {
            pagamento = pagamentoRepo.getObjectByIdentifier(
                Integer.parseInt(line.get(2))
            );
        }

        LocalDate data = LocalDate.parse(line.get(3), DateTimeFormatter.ISO_LOCAL_DATE);

        Pedido pedido = new Pedido(
            id,
            cliente,
            data
        );

        pedido.setPagamento(pagamento);
        
        String itensStr = line.get(4);

        if (!itensStr.isEmpty()) {
            String[] ids = itensStr.split("-");

            for (String i : ids) {
                Item item = itemRepo.getObjectByIdentifier(
                    Integer.parseInt(i)
                );
                if (item != null) pedido.adicionarItem(item);
            }
        }

        return pedido;
    }

    @Override
    protected List<String> getHeaders() {
        String[] headers = {"id", "cliente", "pagamento", "data", "itens"};
        return List.of(headers);
    }
}