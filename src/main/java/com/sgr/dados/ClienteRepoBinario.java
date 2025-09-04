package com.sgr.dados;

import com.sgr.negocio.base.Cliente;

public class ClienteRepoBinario extends RepoBinario<Cliente> {
    public ClienteRepoBinario(String arquivo) throws Exception {
        super(arquivo);
    }

    @Override
    public Cliente getObjectByIdentifier(String cpf) {
        for (Cliente c : cache) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

       @Override
    public Cliente getObjectByIdentifier(int identifier) {
        throw new UnsupportedOperationException("Cliente não tem ID numérico");
    }
}
