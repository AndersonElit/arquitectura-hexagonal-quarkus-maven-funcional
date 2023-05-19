package com.reto.avanzado.sistema.banco.adapterusecase;

import com.reto.avanzado.sistema.banco.Cliente;
import com.reto.avanzado.sistema.banco.ports.ClientePort;
import com.reto.avanzado.sistema.banco.repository.ClienteRepository;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClienteAdapter implements ClientePort {

    private final ClienteRepository clienteRepo;

    @Override
    public Multi<Cliente> listarClientes() {
        return clienteRepo.listarClientes();
    }

    @Override
    public Uni<Cliente> guardarCliente(Cliente cliente) {
        return clienteRepo.guardarCliente(cliente);
    }

    @Override
    public Uni<Cliente> buscarCliente(Long id) {
        return clienteRepo.buscarCliente(id);
    }

    @Override
    public Uni<Cliente> editarCliente(Long id, Cliente cliente) {
        return clienteRepo.editarCliente(id, cliente);
    }

    @Override
    public Uni<Void> eliminarCliente(Long id) {
        return clienteRepo.eliminarCliente(id);
    }

}
