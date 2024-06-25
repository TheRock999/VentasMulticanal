package com.packt.ventasmulticanal.repository;

import com.packt.ventasmulticanal.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepo extends JpaRepository<Cliente, Integer> {
    // Puedes agregar métodos específicos según tus consultas personalizadas
    // Por ejemplo, buscar clientes por correo
    Cliente findByCorreoCliente(String correoCliente);
}
