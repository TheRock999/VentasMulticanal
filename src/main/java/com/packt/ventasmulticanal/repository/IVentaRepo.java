package com.packt.ventasmulticanal.repository;

import com.packt.ventasmulticanal.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface IVentaRepo extends JpaRepository<Venta, Integer> {

    List<Venta> findByFechaVenta(Date fechaVenta);

    Venta findByNumeroPedido(int numeroPedido);
}

