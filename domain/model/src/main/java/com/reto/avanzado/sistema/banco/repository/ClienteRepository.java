package com.reto.avanzado.sistema.banco.repository;

import com.reto.avanzado.sistema.banco.Cliente;
import io.smallrye.mutiny.Uni;

public interface ClienteRepository {
    Uni<Void> guardarCliente(Cliente cliente);
    Uni<Cliente> buscarCliente(Long id);
}
