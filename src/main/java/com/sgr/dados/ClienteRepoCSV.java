package com.sgr.dados;

import com.sgr.config.Config;
import com.sgr.negocio.base.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepoCSV extends RepoCSV<Cliente> {

    public ClienteRepoCSV() throws Exception {
        super(Config.getConfig("csv_clientes"));
    }

    @Override
    protected Cliente getObjectByIdentifier(String cpf) {
        for (Cliente c : listar()) {
            if (c.getCpf().equals(cpf)) return c;
        }
        return null;
    }

    @Override
    protected Cliente getObjectByIdentifier(int identifier) {
        throw new UnsupportedOperationException("Cliente não tem ID numérico");
    }

    @Override
    protected ArrayList<String> toLine(Cliente cliente) {
        ArrayList<String> line = new ArrayList<>();

        line.add(cliente.getCpf());
        line.add(cliente.getNome());
        line.add(cliente.getTelefone());

        return line;
    }

    @Override
    protected Cliente toObject(ArrayList<String> line) {
        return new Cliente(
            line.get(0),
            line.get(1),
            line.get(2)
        );
    }

    @Override
    protected List<String> getHeaders() {
        String[] headers = {"cpf", "nome", "telefone"};
        return List.of(headers);
    }
}