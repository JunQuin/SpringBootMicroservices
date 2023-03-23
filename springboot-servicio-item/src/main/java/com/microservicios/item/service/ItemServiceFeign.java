package com.microservicios.item.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicios.item.clientes.ProductoClienteRest;
import com.microservicios.item.models.Item;

@Service("serviceFeign")
public class ItemServiceFeign implements ItemService {

    private static final Logger LOGGER = LogManager.getLogger(ItemServiceFeign.class.getName()); 
    private static final Marker DEV_MESSAGE = MarkerManager.getMarker("DEV_MESSAGE");
    
    @Autowired
    private ProductoClienteRest clienteRest;

    @Override
    public List<Item> findAll() {
        LOGGER.log(Level.INFO, DEV_MESSAGE, "serviceFeign.findAll()");
        return clienteRest.listar().stream().map(p -> new Item(p,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        LOGGER.log(Level.INFO, DEV_MESSAGE, "serviceFeign.detalle()");
        return new Item(clienteRest.detalle(id),cantidad);
    }
    
}
