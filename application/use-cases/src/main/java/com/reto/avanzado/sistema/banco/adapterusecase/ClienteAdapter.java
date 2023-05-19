package com.reto.avanzado.sistema.banco.adapterusecase;

import com.reto.avanzado.sistema.banco.Cliente;
import com.reto.avanzado.sistema.banco.ports.ClientePort;
import com.reto.avanzado.sistema.banco.repository.ClienteRepository;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClienteAdapter implements ClientePort {

    private final ClienteRepository clienteRepo;

    @Override
    public Uni<Void> guardarCliente(Cliente cliente) {
        return clienteRepo.guardarCliente(cliente);
    }

}
