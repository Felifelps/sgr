package com.sgr.dados;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class RepoBinario<T extends Serializable> implements Repositorio<T> {
    protected String arquivo;
    protected List<T> cache = new ArrayList<>();

    public RepoBinario(String arquivo) {
        this.arquivo = arquivo;
    }

    public void salvar() throws Exception {
        File file = new File(arquivo);

        if (file.getParentFile() != null) {
            file.getParentFile().mkdirs();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(cache);
        }
    }

    @SuppressWarnings("unchecked")
    public void carregar() throws Exception {
        File file = new File(arquivo);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                cache = (List<T>) ois.readObject();
            }
        }
    }

    public List<T> listar() {
        return cache;
    }

    public void adicionar(T obj) {
        cache.add(obj);
    }

    public void remover(T obj) {
        cache.remove(obj);
    }

    public abstract T getObjectByIdentifier(String identifier);
    public abstract T getObjectByIdentifier(int identifier);
}
