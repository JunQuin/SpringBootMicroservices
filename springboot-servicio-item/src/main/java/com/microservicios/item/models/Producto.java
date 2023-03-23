package com.microservicios.item.models;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Producto {

    private Long id;
    private String Nombre;
    private Double precio;
    private Date createAt;
    private Integer port;

}
