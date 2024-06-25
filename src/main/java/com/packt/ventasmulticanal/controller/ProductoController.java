package com.packt.ventasmulticanal.controller;

import com.packt.ventasmulticanal.models.Producto;
import com.packt.ventasmulticanal.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> findAll() {
        return new ResponseEntity<>(productoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> findById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(productoService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Producto> save(@RequestBody Producto producto) {
        Producto savedProduct = productoService.save(producto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Producto> update(@RequestBody Producto producto) {
        return new ResponseEntity<>(productoService.update(producto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        productoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

