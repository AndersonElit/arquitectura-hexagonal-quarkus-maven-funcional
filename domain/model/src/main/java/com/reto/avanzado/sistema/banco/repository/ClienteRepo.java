package com.reto.avanzado.sistema.banco.repository;

import com.reto.avanzado.sistema.banco.Cliente;
import io.smallrye.mutiny.Uni;

public interface ClienteRepo {
    Uni<Void> guardarCliente(Cliente cliente);
}
