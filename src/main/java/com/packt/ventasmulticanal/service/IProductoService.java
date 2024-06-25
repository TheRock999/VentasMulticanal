package com.packt.ventasmulticanal.service;

import com.packt.ventasmulticanal.models.Producto;

import java.util.List;

public interface IProductoService extends ICRUDService<Producto, Integer> {
    List<Producto> findAll();

    Producto findById(Integer id);

    Producto save(Producto producto);

    Producto update(Producto producto);

    void delete(Integer id);
}
