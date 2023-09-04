

package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.web.dao.ClientDao;
import com.ecommerce.microcommerce.web.model.Client;
import com.ecommerce.microcommerce.web.exceptions.LicenceException;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;

import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.net.URI;

@RequestMapping("/clients")

@RestController
public class ClientController {
    @Autowired

    private final ClientDao clientDao;

    private RestOperations restTemplate = new RestTemplate();


// 🍋 ---- constructor ----

    public ClientController(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

// -----------------------


    @ApiOperation("Affiche tous les clients")
    @GetMapping
    public List<Client> listClients() {
        List<Client> clients = clientDao.findAll();
        return clients;
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
    public void deleteClient(@PathVariable int id){
        clientDao.deleteById(id);
    }

    @ApiOperation("Modifie un nouveau client par son ID")
    @PutMapping("/{id}")
    public Client updateClient(@PathVariable int id, @RequestBody Client client){
        client.setId(id);
        Client updateClient = clientDao.save(client);
        return updateClient;
    }


 //  🍋 ---- methode ----

    public Boolean checkLicense(int licenceNumber){
        return restTemplate.getForObject( "http://localhost:8081/licenses/" + licenceNumber, Boolean.class);
    }


    public void exceptionLicence (Client client){
        int drivingLicence = client.getDrivingLicenceNumber();
        if(!checkLicense(drivingLicence)){
            throw new LicenceException("License driving non valid");
        }
    }
}
