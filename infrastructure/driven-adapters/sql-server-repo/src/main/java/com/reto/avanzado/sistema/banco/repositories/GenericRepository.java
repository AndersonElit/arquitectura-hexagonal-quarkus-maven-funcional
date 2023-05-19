package com.reto.avanzado.sistema.banco.repositories;

import io.smallrye.mutiny.Uni;

public interface GenericRepository<T> {
    Uni<Void> save(T entity);
    <T> Uni<T> findById(Class<T> entity, Long id);
}
