package com.microservicios.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservicios.item.models.Producto;

@FeignClient(name = "microservicio-productos")
public interface ProductoClienteRest {

    @GetMapping("/listar")
    List<Producto> listar();
    
    @GetMapping("/listar/{id}")
    Producto detalle(@PathVariable Long id);
}
