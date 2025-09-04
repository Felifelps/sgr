package com.sgr.dados;

import java.util.List;

public interface Repositorio<T> {
    void adicionar(T obj);
    void remover(T obj);
    List<T> listar();
    
    void salvar() throws Exception;
    void carregar() throws Exception;

    T getObjectByIdentifier(String id);
    T getObjectByIdentifier(int id);
}

