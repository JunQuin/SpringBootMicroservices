package com.microservicios.item.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservicios.item.models.Item;
import com.microservicios.item.models.Producto;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {

    private static final Logger LOGGER = LogManager.getLogger(ItemServiceImpl.class.getName()); 
    private static final Marker DEV_MESSAGE = MarkerManager.getMarker("DEV_MESSAGE");

    @Autowired
    private RestTemplate clienteRest;

    @Override
    public List<Item> findAll() {
        LOGGER.log(Level.INFO, DEV_MESSAGE, "serviceRestTemplate.findAll()");
        List<Producto> productos = Arrays
                .asList(clienteRest.getForObject("http://microservio-productos/listar", Producto[].class));
        return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        LOGGER.log(Level.INFO, DEV_MESSAGE, "serviceRestTemplate.findById()");
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id",id.toString());
        Producto producto = clienteRest.getForObject("http://microservio-productos/listar/{id}", Producto.class, pathVariables);
        return new Item(producto, cantidad);
    }

}
