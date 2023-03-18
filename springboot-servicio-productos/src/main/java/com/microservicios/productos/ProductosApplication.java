package com.microservicios.productos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ProductosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductosApplication.class, args);
    }

    private static final Logger LOGGER = LogManager.getLogger(ProductosApplication.class.getName()); //LOGGER UTILIZADO PARA MOSTRAR MENSAJES
}