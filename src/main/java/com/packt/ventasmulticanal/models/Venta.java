package com.packt.ventasmulticanal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaVenta", nullable = false)
    private Date fechaVenta;

    @Column(name = "totalVenta", nullable = false)
    private double totalVenta;

    @Column(name = "subTotalVenta", nullable = false)
    private double subTotalVenta;

    @Column(name = "descuentoVenta", nullable = false)
    private double descuentoVenta;

    @Column(name = "numeroPedido", nullable = false)
    private int numeroPedido;

    // Relación con DetalleVenta
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetalleVenta> detallesVenta;
}
