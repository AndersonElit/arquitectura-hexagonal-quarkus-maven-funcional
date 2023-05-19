package com.reto.avanzado.sistema.banco.repository;

import com.reto.avanzado.sistema.banco.Cliente;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public interface ClienteRepository {
    Multi<Cliente> listarClientes();
    Uni<Cliente> guardarCliente(Cliente cliente);
    Uni<Cliente> buscarCliente(Long id);
    Uni<Cliente> editarCliente(Long id, Cliente cliente);
    Uni<Void> eliminarCliente(Long id);
}
