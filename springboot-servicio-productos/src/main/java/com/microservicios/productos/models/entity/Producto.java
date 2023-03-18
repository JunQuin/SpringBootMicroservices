package com.microservicios.productos.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    @Serial
    private static final long serialVersionUID = -23088563348930186L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Double precio;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    private Integer port;
}
