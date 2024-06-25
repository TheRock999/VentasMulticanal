
package com.packt.ventasmulticanal.service;

import com.packt.ventasmulticanal.models.Cliente;


import java.util.List;

public interface IClientService {
    List<Cliente> findAll();
    Cliente findById(Integer id);
    Cliente save(Cliente client);
    Cliente updateClient(Integer id, Cliente client);
    void deleteCliente(Integer id);
    Cliente createCliente(Cliente client);
}






