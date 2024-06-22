package org.dio.designpatterns.persistence.controller;


import org.dio.designpatterns.persistence.model.Client;
import org.dio.designpatterns.persistence.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientRestController {


    @Autowired
    ClientService clientService;



    @GetMapping
    public ResponseEntity <Iterable<Client>> findAllByID () {

        return ResponseEntity.ok(clientService.buscarTodosClientes());

    }

    @PostMapping ("/insert")
    public ResponseEntity <Client> insert (@RequestBody Client cliente) {


        clientService.inserirClient(cliente);
        return ResponseEntity.ok(cliente);

    }


    @GetMapping ("/{id}")
    public ResponseEntity <Client> findById (@PathVariable long id) {


        return ResponseEntity.ok(clientService.buscarPorId(id));


    }

    @PutMapping ("/update/{id}")
    public void updateClient (@PathVariable long id, @RequestBody Client client) {


        clientService.atualizarClient(id, client);


    }

    @DeleteMapping ("delete/{id}")
    public void deleteClient (@PathVariable long id) {
        clientService.deletarClient(id);

    }


}
