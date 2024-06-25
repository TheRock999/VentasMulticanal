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

public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleVenta;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaVenta", nullable = false)
    private Date fechaVenta;

    @Column(name = "totalVenta", nullable = false)
    private double totalVenta;

    @Column(name = "descuentoVenta", nullable = false)
    private double descuentoVenta;

    @Column(name = "ivaVenta", nullable = false)
    private double ivaVenta;

    @Column(name = "precio", nullable = false)
    private double precio;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "correoCliente", nullable = false, length = 50)
    private String correoCliente;

    @ManyToOne
    @JoinColumn(name = "idVenta", nullable = false)
    private Venta venta;

}
