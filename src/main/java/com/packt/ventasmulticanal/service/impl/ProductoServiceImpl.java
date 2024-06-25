package com.packt.ventasmulticanal.service.impl;

import com.packt.ventasmulticanal.models.Producto;
import com.packt.ventasmulticanal.repository.IProductoRepo;
import com.packt.ventasmulticanal.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {

    private final IProductoRepo productoRepo;

    @Autowired
    public ProductoServiceImpl(IProductoRepo productoRepo) {
        this.productoRepo = productoRepo;
    }

    @Override
    public List<Producto> findAll() {
        return productoRepo.findAll();
    }

    @Override
    public Producto findById(Integer id) {
        return (Producto) productoRepo.findById(id).orElse(null);
    }

    @Override
    public Producto save(Producto producto) {
        productoRepo.save(producto);
        return producto;
    }

    @Override
    public Producto update(Producto producto) {
        // Lógica de actualización, podrías agregar validaciones, etc.
        return productoRepo.save(producto);
    }

    @Override
    public void delete(Integer id) {
        productoRepo.deleteById(id);
    }
}

