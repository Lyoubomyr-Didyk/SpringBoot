

package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.web.dao.ClientDao;
import com.ecommerce.microcommerce.web.exceptions.LicenceException;
import com.ecommerce.microcommerce.web.model.Client;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/clients")

@RestController
public class ClientController {

    private final ClientDao clientDao;

    private RestOperations restTemplate = new RestTemplate();


// 🍋 ---- constructor ----

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
        exceptionLicence(client);

        clientDao.save(client);
    }

    @ApiOperation("Supprime le client par son ID")
    @DeleteMapping("/{id}")
    public Client deleteClient(@PathVariable int id){
        Client deleteClient = clientDao.remove(id);
        return deleteClient;
    }

    @ApiOperation("Modifie un nouveau client par son ID")
    @PutMapping("/{id}")
    public Client updateClient(@PathVariable int id,@RequestBody Client client){
        Client updateClient = clientDao.update(id, client);
        return updateClient;
    }



// 🍋 ---- methode ----

    public Boolean checkLicense(int licenceNumber){
        return restTemplate.getForObject( "http://localhost:8081/licenses/" + licenceNumber, Boolean.class);
    }

    public void exceptionLicence (Client client){
        int drivingLicence = client.getDrivingLicenceNumber();
        if(!checkLicense(drivingLicence)){
            throw new LicenceException("Non valid");
        }
    }


}
