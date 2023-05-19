package com.reto.avanzado.sistema.banco.repositories.impl;

import com.reto.avanzado.sistema.banco.repositories.GenericRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.reactive.mutiny.Mutiny;

@ApplicationScoped
public class GenericRepositoryImpl<T> implements GenericRepository<T> {

    private final Mutiny.SessionFactory sessionFactory;

    public GenericRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.sessionFactory = entityManagerFactory.unwrap(Mutiny.SessionFactory.class);
    }

    @Override
    public Uni<Void> save(T entity) {
        return sessionFactory.withTransaction((session, transaction) -> session.persist(entity));
    }

    @Override
    public <T> Uni<T> findById(Class<T> entityType, Long id) {
        return sessionFactory.withSession(session -> session.find(entityType, id));
    }

}
