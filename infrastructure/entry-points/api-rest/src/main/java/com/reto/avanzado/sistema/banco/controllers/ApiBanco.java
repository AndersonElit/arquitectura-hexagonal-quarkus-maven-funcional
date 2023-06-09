package com.reto.avanzado.sistema.banco.controllers;

import com.reto.avanzado.sistema.banco.Cliente;
import com.reto.avanzado.sistema.banco.ports.ClientePort;
import io.smallrye.mutiny.Multi;
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
    public Uni<Cliente> saludo(Cliente cliente) {
        return clientePort.guardarCliente(cliente);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Uni<Cliente> buscarCliente(@PathParam("id") Long id) {
        return clientePort.buscarCliente(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Multi<Cliente> listarClientes() {
        return clientePort.listarClientes();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Uni<Cliente> editarCliente(@PathParam("id") Long id, Cliente cliente) {
        return clientePort.editarCliente(id, cliente);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Void> eliminarCliente(Long id) {
        return clientePort.eliminarCliente(id);
    }

}
