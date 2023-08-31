package com.ecommerce.microcommerce.web.dao;

import com.ecommerce.microcommerce.web.model.Client;

import java.util.List;

public interface ClientDao {

    List<Client> findAll();
    Client findById(int id);
    Client save(Client client);
    Client remove(int id);

    Client update(int id, Client client);

}
