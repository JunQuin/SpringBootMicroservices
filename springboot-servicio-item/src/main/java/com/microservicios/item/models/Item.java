package com.microservicios.item.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    
    private Producto producto;
    private Integer cantidad;

    /**
     * @return Total
     */
    // Al crear la instancia de ITEM se esta retornando el metodo getTotal
    public Double getTotal(){
        return producto.getPrecio() * cantidad.doubleValue();
    }

    public String getUwU() { return "UwU"; }
}
