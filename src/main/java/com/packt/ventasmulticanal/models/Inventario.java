package com.packt.ventasmulticanal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInventario;

    @Column(name = "cantidadDisponible", nullable = false)
    private double cantidadDisponible;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaActualizacion", nullable = false)
    private Date fechaActualizacion;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

}
