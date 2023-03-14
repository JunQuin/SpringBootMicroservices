package com.microservicios.productos.controllers;

import com.microservicios.productos.models.entity.Producto;
import com.microservicios.productos.models.service.IProductoService;
import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired

    private IProductoService iProductoService;

    private static final Logger LOGGER = LogManager.getLogger(ProductoController.class.getName());
    private static final Marker MY_MARKER = MarkerManager.getMarker("DEV_MESSAGE");

    @GetMapping("/listar")
    public List<Producto> listarTodos(){
        LOGGER.log(Level.INFO, MY_MARKER, "Entró a listar todos");
        return iProductoService.findAll();
    }

    @GetMapping("/listar/{id}")
    public Producto detalle(@PathVariable Long id){
        LOGGER.log(Level.INFO, MY_MARKER, "Entró a listar por id con el parametro: "+ id);
        return iProductoService.findByID(id);
    }

}
