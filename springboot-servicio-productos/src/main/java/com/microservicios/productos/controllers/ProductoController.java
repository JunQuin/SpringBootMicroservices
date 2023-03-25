package com.microservicios.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.productos.models.entity.Producto;
import com.microservicios.productos.service.IProductoService;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService iProductoService;

    @Value("${server.port}")
    private Integer port;

    private static final Logger LOGGER = LogManager.getLogger(ProductoController.class.getName());
    private static final Marker MY_MARKER = MarkerManager.getMarker("DEV_MESSAGE");

    @GetMapping("/listar")
    public List<Producto> listarTodos(){
        LOGGER.log(Level.INFO, MY_MARKER, "Entró a listar todos");
        return iProductoService.findAll().stream().peek(producto -> producto.setPort(port)).collect(Collectors.toList());
    }

    @GetMapping("/listar/{id}")
    public Producto detalle(@PathVariable Long id){
        LOGGER.log(Level.INFO, MY_MARKER, "Entró a listar por id con el parametro: "+ id);
        Producto producto = iProductoService.findByID(id);
        producto.setPort(port);
        return producto;
    }

}
