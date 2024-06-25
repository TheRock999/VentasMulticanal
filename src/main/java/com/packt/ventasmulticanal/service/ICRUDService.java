package com.packt.ventasmulticanal.service;

import java.util.List;

public interface ICRUDService <T,ID>{
    T save(T t);
    T update(T t);
    T findById(ID id);
    List<T> findAll();
    void delete(ID id);
}
