package com.packt.ventasmulticanal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @Column(name = "nombreCliente", nullable = false, length = 50)
    private String nombreCliente;

    @Column(name = "apellidoCliente", nullable = false, length = 100)
    private String apellidoCliente;

    @Column(name = "cedulaCliente", nullable = false, length = 10)
    private String cedulaCliente;

    @Column(name = "telfCliente", nullable = false, length = 10)
    private String telfCliente;

    @Column(name = "correoCliente", nullable = false, length = 50)
    private String correoCliente;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Pedido> pedidos;
}

