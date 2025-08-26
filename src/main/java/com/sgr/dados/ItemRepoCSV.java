package com.sgr.dados;

import com.sgr.util.Config;
import com.sgr.negocio.base.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemRepoCSV extends RepoCSV<Item> {

    public ItemRepoCSV() throws Exception {
        super(Config.getConfig("csv_itens"));
    }

    @Override
    public Item getObjectByIdentifier(int id) {
        for (Item i : listar()) {
            if (i.getId() == id) return i;
        }
        return null;
    }

    @Override
    public Item getObjectByIdentifier(String identifier) {
        throw new UnsupportedOperationException("Item não tem ID textual");
    }

    @Override
    protected ArrayList<String> toLine(Item item) {
        ArrayList<String> line = new ArrayList<>();

        line.add(String.valueOf(item.getId()));
        line.add(item.getNome());
        line.add(String.valueOf(item.getPreco()));
        line.add(item.getDescricao());

        return line;
    }

    @Override
    protected Item toObject(ArrayList<String> line) {
        return new Item(
            Integer.parseInt(line.get(0)),
            line.get(1),
            Double.parseDouble(line.get(2)),
            line.get(3)
        );
    }

    @Override
    protected List<String> getHeaders() {
        String[] headers = {"id", "nome", "preco", "descricao"};
        return List.of(headers);
    }
}