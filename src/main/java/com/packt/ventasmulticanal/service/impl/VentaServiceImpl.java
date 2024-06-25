package com.packt.ventasmulticanal.service.impl;

import com.packt.ventasmulticanal.models.DetalleVenta;
import com.packt.ventasmulticanal.models.Venta;
import com.packt.ventasmulticanal.service.IVentaService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VentaServiceImpl implements IVentaService {

    // Valor predeterminado para el descuento (puede ser configurable o calculado dinámicamente)
    private static final double DESCUENTO_PORCENTAJE = 0.0;

    @Override
    public Venta createVenta(Venta venta) {
        return null;
    }

    @Override
    public void saveVenta(Venta venta) {

    }

    @Override
    public List<Venta> buscarVentasPorFecha(Date fechaInicio, Date fechaFin) {
        return null;
    }

    @Override
    public Venta findById(Integer idVenta) {
        return null;
    }

    @Override
    public Venta updateVenta(Integer idVenta, Venta venta) {
        return null;
    }

    @Override
    public void deleteVenta(Integer idVenta) {

    }

    @Override
    public Venta buscarVentaPorNumeroPedido(int numeroPedido) {
        return null;
    }

    @Override
    public Venta calcularTotales(Venta venta) {
        double total = 0;

        // Calcula el total sumando los productos de precio por cantidad
        for (DetalleVenta detalle : venta.getDetallesVenta()) {
            total += detalle.getPrecio() * detalle.getCantidad();
        }

        venta.setSubTotalVenta(total);

        // Cálculo de descuento (opcional)
        double descuento = calcularDescuento(total);
        venta.setDescuentoVenta(descuento);

        // Cálculo de total
        double totalFinal = total - descuento;  // Eliminado el cálculo de IVA
        venta.setTotalVenta(totalFinal);

        return venta;
    }

    // Método para calcular el descuento (puedes implementar tu lógica personalizada aquí)
    private double calcularDescuento(double total) {
        return total * DESCUENTO_PORCENTAJE;
    }
}
