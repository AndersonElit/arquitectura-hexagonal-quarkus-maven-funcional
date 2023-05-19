package com.reto.avanzado.sistema.banco.ports;

import com.reto.avanzado.sistema.banco.Cliente;
import io.smallrye.mutiny.Uni;

public interface ClientePort {
    Uni<Void> guardarCliente(Cliente cliente);
}
