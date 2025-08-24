package com.sgr.negocio.services;
package com.sgr.negocio.exceptions.CpfInUseException;
package com.sgr.negocio.exceptions.CampoInvalidoException;

import java.util.List;

import com.sgr.dados.ClienteRepoCSV;
import com.sgr.negocio.base.Cliente;

public class ClienteService {
    private ClienteRepoCSV repo;

    public ClienteService(ClienteRepoCSV repo) {
        this.repo = repo;
    }

    public List<Cliente> listar() {
        return repo.listar();
    }

    public void adicionar(Cliente cliente) throws CpfInUseException {
        if (cliente.getCpf() == null || cliente.getCpf().isEmpty()) {

        }

        if (repo.getObjectByIdentifier(cliente.getCpf()) != null) {
            throw new CpfInUseException();
        }
        repo.adicionar(cliente);
    }
}