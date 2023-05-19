package com.reto.avanzado.sistema.banco.adapterinfra;

import com.reto.avanzado.sistema.banco.Cliente;
import com.reto.avanzado.sistema.banco.entities.ClienteEntity;
import com.reto.avanzado.sistema.banco.mapper.Mapper;
import com.reto.avanzado.sistema.banco.repositories.PgsClienteRepository;
import com.reto.avanzado.sistema.banco.repository.ClienteRepository;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class PgsClienteAdapter implements ClienteRepository {

    private final PgsClienteRepository repository;

    @Override
    public Multi<Cliente> listarClientes() {
        return Panache.withSession(() -> repository.findAll().list())
                .toMulti().flatMap(entities -> Multi.createFrom().iterable(entities))
                .map(entity -> Mapper.map(entity, Cliente.class));
    }

    @Override
    public Uni<Cliente> guardarCliente(Cliente cliente) {
        return Panache.withTransaction(() -> repository.persist(Mapper.map(cliente, ClienteEntity.class))
                .onItem()
                .transform(entity -> Mapper.map(entity, Cliente.class)));
    }

    @Override
    public Uni<Cliente> buscarCliente(Long id) {
        return Panache.withSession(() -> repository.findById(id).map(entity -> Mapper.map(entity, Cliente.class)));
    }

    @Override
    public Uni<Cliente> editarCliente(Long id, Cliente cliente) {
        return Panache.withTransaction(() -> repository.findById(id)
                .flatMap(entity -> {
                    cliente.setId(id);
                    Mapper.mapObjects(cliente, entity);
                    return repository.persist(entity)
                            .map(e -> Mapper.map(e, Cliente.class));
                }));
    }

    @Override
    public Uni<Void> eliminarCliente(Long id) {
        return Panache.withTransaction(() -> repository.findById(id)
                .flatMap(entity -> repository.delete(entity)));
    }

}
