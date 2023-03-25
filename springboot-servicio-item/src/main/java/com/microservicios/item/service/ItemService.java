package com.microservicios.item.service;

import java.util.List;

import com.microservicios.item.models.Item;

public interface ItemService {
    
    List<Item> findAll();
    Item findById(Long id, Integer cantidad);
}
