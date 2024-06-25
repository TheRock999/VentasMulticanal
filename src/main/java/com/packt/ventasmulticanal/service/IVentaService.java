package com.packt.ventasmulticanal.service;

import com.packt.ventasmulticanal.models.Venta;

import java.util.Date;
import java.util.List;

public interface IVentaService {

    Venta createVenta(Venta venta);

    void saveVenta(Venta venta);

    List<Venta> buscarVentasPorFecha(Date fechaInicio, Date fechaFin);

    Venta findById(Integer idVenta);

    Venta updateVenta(Integer idVenta, Venta venta);

    void deleteVenta(Integer idVenta);

    Venta buscarVentaPorNumeroPedido(int numeroPedido);

    Venta calcularTotales(Venta venta);
}


