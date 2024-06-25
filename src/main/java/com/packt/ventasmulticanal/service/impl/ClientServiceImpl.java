package com.packt.ventasmulticanal.service.impl;

import com.packt.ventasmulticanal.models.Cliente;
import com.packt.ventasmulticanal.repository.IClientRepo;
import com.packt.ventasmulticanal.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    private IClientRepo clientRepo;

    @Override
    public List<Cliente> findAll() {
        return clientRepo.findAll();
    }

    @Override
    public Cliente findById(Integer id) {
        return clientRepo.findById(id).orElse(null);
    }

    @Override
    public Cliente save(Cliente client) {
        return clientRepo.save(client);
    }

    @Override
    public Cliente updateClient(Integer id, Cliente client) {
        Cliente existingClient = clientRepo.findById(id).orElse(null);
        if (existingClient != null) {
            // Actualizar los campos del cliente existente con los valores proporcionados
            existingClient.setNombreCliente(client.getNombreCliente());
            existingClient.setApellidoCliente(client.getApellidoCliente());
            // Otros campos...
            return clientRepo.save(existingClient);
        }
        return null; // Devolver null si el cliente no existe
    }

    @Override
    public void deleteCliente(Integer id) {
        clientRepo.deleteById(id);
    }

    @Override
    public Cliente createCliente(Cliente client) {
        return clientRepo.save(client);
    }
}
