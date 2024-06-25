package com.packt.ventasmulticanal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPedido")
    private Integer idPedido;

    @Column(name = "numeroPedido", nullable = false)
    private int numeroPedido;

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "Pedido_Producto",
            joinColumns = @JoinColumn(name = "idPedido"),
            inverseJoinColumns = @JoinColumn(name = "idProducto")
    )
    private List<Producto> productos;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaPedido", nullable = false)
    private Date fechaPedido;
}

