package com.example.ttbbackpostgre.controller;

import com.example.ttbbackpostgre.entity.Client;
import com.example.ttbbackpostgre.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5050")
@RestController
public class ClientController {
    @Autowired
    private ClientService service;

    public ClientController(ClientService service){
        this.service=service;
    }

    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client client) {
        return service.saveClient(client);
    }

    @GetMapping("/ClientById/{id}")
    public Client findClientById(@PathVariable int id) {
        return service.getClientById(id);
    }

    @GetMapping("/client/{name}")
    public Client findClientByName(@PathVariable String name) {
        return service.getClientByName(name);
    }

    @PutMapping("/client/update")
    public Client updateClient(@RequestBody Client client) {
        return service.updateClient(client);
    }

    @DeleteMapping("/client/delete/{id}")
    public void deleteClient(@PathVariable int id) {
        service.deleteClient(id);
    }
}

