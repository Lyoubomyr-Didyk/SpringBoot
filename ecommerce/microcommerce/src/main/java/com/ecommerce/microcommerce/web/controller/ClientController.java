

package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.web.dao.ClientDao;
import com.ecommerce.microcommerce.web.model.Client;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/clients")

@RestController
public class ClientController {

    private final ClientDao clientDao;


// 🍋 constructor ----------

    public ClientController(ClientDao clientDao){
        this.clientDao = clientDao;
    }


    @ApiOperation("Affiche tous les clients")
    @GetMapping       // Patern
    public List<Client> listClients() {
        return clientDao.findAll();
    }

    @ApiOperation("Affiche le client par son ID")
    @GetMapping("/{id}")   // Patern
    public Client getClientById(@PathVariable int id) {
        return clientDao.findById(id);
    }

    @ApiOperation("Ajoute un nouveau client")
    @PostMapping
    public void addClient(@RequestBody Client client) {
        clientDao.save(client);
    }

    @DeleteMapping("/{id}")
    public Client deleteClient(@PathVariable int id){

        return clientDao.remove(id);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable int id,@RequestBody Client client){
        Client updateClient = clientDao.update(id, client);
        return updateClient;
    }




}
