package com.reto.avanzado.sistema.banco.config;

import com.reto.avanzado.sistema.banco.adapterusecase.ClienteAdapter;
import com.reto.avanzado.sistema.banco.ports.ClientePort;
import com.reto.avanzado.sistema.banco.repository.ClienteRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class BeanConfig {

    @Produces
    public ClientePort clientePort(ClienteRepo clienteRepo) {
        return new ClienteAdapter(clienteRepo);
    }

}
