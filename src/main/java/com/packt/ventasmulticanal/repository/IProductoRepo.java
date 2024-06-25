package com.packt.ventasmulticanal.repository;

import com.packt.ventasmulticanal.models.Producto;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepo extends IGenericRepo<Producto, Integer> {
}

