package com.sgr.negocio.services;

import java.util.List;

import com.sgr.negocio.exceptions.CpfInUseException;
import com.sgr.negocio.exceptions.CampoInvalidoException;
import com.sgr.negocio.exceptions.ObjetoNaoEncontradoException;
import com.sgr.negocio.base.Cliente;
import com.sgr.dados.ClienteRepoCSV;
import com.sgr.util.Validador;

public class ClienteService {
    private ClienteRepoCSV repo;

    public ClienteService(ClienteRepoCSV repo) {
        this.repo = repo;
    }

    public List<Cliente> listar() {
        return repo.listar();
    }

    public void adicionar(String cpf, String nome, String telefone) throws Exception {
        String mensagem = "";

        if (cpf == null || cpf.isEmpty())
            mensagem = "CPF vazio ou indefinido.";
        else if (!Validador.validarCPF(cpf))
            mensagem = "CPF inválido. Digite apenas os números.";
        else if (nome == null || nome.isEmpty())
            mensagem = "Nome vazio ou indefinido.";
        else if (!Validador.validarNome(nome))
            mensagem = "Nome inválido.";
        else if (telefone == null || telefone.isEmpty())
            mensagem = "Telefone vazio ou indefinido.";
        else if (!Validador.validarTelefone(telefone))
            mensagem = "Telefone inválido. Digite apenas os números, com DDD.";

        if (!mensagem.isEmpty()) throw new CampoInvalidoException(mensagem);

        if (repo.getObjectByIdentifier(cpf) != null) throw new CpfInUseException();

        Cliente cliente = new Cliente(cpf, nome, telefone);
        repo.adicionar(cliente);
        repo.salvar();
    }

    public void remover(String cpf) throws Exception {
        Cliente cliente = repo.getObjectByIdentifier(cpf);
        if (cliente == null) throw new ObjetoNaoEncontradoException("Cliente de cpf '" + cpf + "'");
        repo.remover(cliente);
        repo.salvar();
    }
}