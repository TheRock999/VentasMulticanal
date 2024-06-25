package com.packt.ventasmulticanal.controller;

import com.packt.ventasmulticanal.models.Cliente;
import com.packt.ventasmulticanal.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/clientes")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> clientes = clientService.findAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public <Cliente> ResponseEntity<Cliente> findById(@PathVariable("id") Integer id) {
        Cliente foundClient = (Cliente) clientService.findById(id);
        if (foundClient != null) {
            return new ResponseEntity<>(foundClient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Cliente> createClient(@RequestBody Cliente client) {
        Cliente newClient = clientService.createCliente(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }




    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateClient(@PathVariable("id") Integer id,
                                                @RequestBody Cliente client) {
        Cliente updatedClient = clientService.updateClient(id, client);
        if (updatedClient != null) {
            return new ResponseEntity<>(updatedClient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        clientService.deleteCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

