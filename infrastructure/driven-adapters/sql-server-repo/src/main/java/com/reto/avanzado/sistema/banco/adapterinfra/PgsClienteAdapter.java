package com.reto.avanzado.sistema.banco.adapterinfra;

import com.reto.avanzado.sistema.banco.Cliente;
import com.reto.avanzado.sistema.banco.entities.ClienteEntity;
import com.reto.avanzado.sistema.banco.mapper.Mapper;
import com.reto.avanzado.sistema.banco.repositories.GenericRepository;
import com.reto.avanzado.sistema.banco.repository.ClienteRepo;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class PgsClienteAdapter implements ClienteRepo {

    //private final ClienteRepository repository;
    private final GenericRepository<ClienteEntity> repository;

    @Override
    public Uni<Void> guardarCliente(Cliente cliente) {
        /*return repository.persist(Mapper.map(cliente, ClienteEntity.class))
                .map(entity -> Mapper.map(entity, Cliente.class));*/
        return repository.save(Mapper.map(cliente, ClienteEntity.class));
    }

}
