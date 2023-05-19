package com.reto.avanzado.sistema.banco.controllers;

import com.reto.avanzado.sistema.banco.Cliente;
import com.reto.avanzado.sistema.banco.ports.ClientePort;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;

@Path("/ejemplo")
@RequiredArgsConstructor
public class ApiBanco {

    private final ClientePort clientePort;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Void> saludo(Cliente cliente) {
        return clientePort.guardarCliente(cliente);
    }
}
