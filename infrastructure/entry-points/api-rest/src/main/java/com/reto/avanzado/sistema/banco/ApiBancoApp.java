package com.reto.avanzado.sistema.banco;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class ApiBancoApp {
    public static void main(String... args) {
        Quarkus.run(args);
    }
}
