package com.sgr.dados;

import com.sgr.negocio.base.Item;
import com.sgr.util.Config;

public class ItemRepoBinario extends RepoBinario<Item> {
    public ItemRepoBinario(String arquivo) throws Exception {
        super(arquivo);
    }

    @Override
    public Item getObjectByIdentifier(int id) {
        for (Item i : cache) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    @Override
    public Item getObjectByIdentifier(String identifier) {
        throw new UnsupportedOperationException("Item não tem ID textual");
    }
}
