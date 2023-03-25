package com.microservicios.productos.service;

import com.microservicios.productos.models.entity.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> findAll();
    Producto findByID(Long id);
}
