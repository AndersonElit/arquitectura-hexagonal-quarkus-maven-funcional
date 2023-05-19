package com.reto.avanzado.sistema.banco.repositories.impl;

public class ClassWrapper<T> {
    private final Class<T> entityClass;

    public ClassWrapper(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

}
