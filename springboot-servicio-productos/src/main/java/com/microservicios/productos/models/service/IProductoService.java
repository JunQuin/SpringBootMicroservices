package com.microservicios.productos.models.service;

import com.microservicios.productos.models.entity.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> findAll();

    public Producto findByID(Long id);
}
