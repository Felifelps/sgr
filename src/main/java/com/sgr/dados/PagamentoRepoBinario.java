package com.sgr.dados;

import com.sgr.negocio.base.Pagamento;
import com.sgr.util.Config;

public class PagamentoRepoBinario extends RepoBinario<Pagamento> {
    public PagamentoRepoBinario(String arquivo) throws Exception {
        super(arquivo);
    }

    @Override
    public Pagamento getObjectByIdentifier(int id) {
        for (Pagamento p : cache) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Pagamento getObjectByIdentifier(String identifier) {
        throw new UnsupportedOperationException("Pagamento não tem ID textual");
    }
}
