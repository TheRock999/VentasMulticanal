package com.packt.ventasmulticanal.controller;

import com.packt.ventasmulticanal.models.Venta;
import com.packt.ventasmulticanal.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    // Endpoint para crear una nueva venta
    @PostMapping
    public ResponseEntity<Venta> createVenta(@RequestBody Venta venta) {
        // Puedes realizar validaciones o lógica adicional antes de guardar la venta
        Venta nuevaVenta = ventaService.calcularTotales(venta);
        ventaService.saveVenta(nuevaVenta);
        return new ResponseEntity<>(nuevaVenta, HttpStatus.CREATED);
    }

    // Endpoint para buscar ventas por fecha
    @GetMapping("/buscarPorFecha")
    public ResponseEntity<List<Venta>> buscarVentasPorFecha(
            @RequestParam("fechaInicio") Date fechaInicio,
            @RequestParam("fechaFin") Date fechaFin) {
        List<Venta> ventas = ventaService.buscarVentasPorFecha(fechaInicio, fechaFin);
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }

    // **Endpoint para obtener una venta por ID:**

    @GetMapping("/{idVenta}")
    public ResponseEntity<Venta> getVenta(@PathVariable Integer idVenta) {
        Venta venta = ventaService.findById(idVenta);
        return ResponseEntity.ok(venta);
    }

    // **Endpoint para actualizar una venta:**

    @PutMapping("/{idVenta}")
    public ResponseEntity<Venta> updateVenta(@PathVariable Integer idVenta, @RequestBody Venta venta) {
        Venta updatedVenta = ventaService.updateVenta(idVenta, venta);
        return ResponseEntity.ok(updatedVenta);
    }

    // **Endpoint para eliminar una venta:**

    @DeleteMapping("/{idVenta}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Integer idVenta) {
        ventaService.deleteVenta(idVenta);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para buscar venta por número de pedido
    @GetMapping("/buscarPorNumeroPedido")
    public ResponseEntity<Venta> buscarVentaPorNumeroPedido(@RequestParam("numeroPedido") int numeroPedido) {
    Venta venta = ventaService.buscarVentaPorNumeroPedido(numeroPedido);
    return new ResponseEntity<>(venta, HttpStatus.OK);
}
// **Endpoint para calcular totales de una venta:**

     @PostMapping("/calcular-totales")
     public ResponseEntity<Venta> calcularTotales(@RequestBody Venta venta) {
     Venta ventaConTotales = ventaService.calcularTotales(venta);
     return ResponseEntity.ok(ventaConTotales);
    }
}