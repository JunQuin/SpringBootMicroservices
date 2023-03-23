package com.microservicios.item.controllers;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.item.models.Item;
import com.microservicios.item.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ItemController {
    
    @Autowired
    // @Qualifier("serviceRestTemplate")//DEFINO CUAL SERVICO CONSUMIRA MI CONTROLLER
    @Qualifier("serviceFeign")
    private ItemService itemService;
    
    private static final Logger LOGGER = LogManager.getLogger(ItemController.class.getName()); 
    private static final Marker DEV_MESSAGE = MarkerManager.getMarker("DEV_MESSAGE");
    
    @GetMapping("/listar")
    public List<Item> listar(){
        LOGGER.log(Level.INFO, DEV_MESSAGE, "Recurso utilizado: /listar");
        return itemService.findAll();
    }

    @GetMapping("/listar/{id}/cantidad/{cantidad}")
    public Item detalle(@PathVariable long id, @PathVariable Integer cantidad){
        LOGGER.log(Level.INFO, DEV_MESSAGE, "Recurso utilizado: /listar/{id}/cantidad/{cantidad}");
        return itemService.findById(id, cantidad);
    }
}
