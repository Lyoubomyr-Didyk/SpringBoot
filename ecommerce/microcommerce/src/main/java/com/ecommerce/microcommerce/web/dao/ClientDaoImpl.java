// 🍏 cette classe est censée communiquer avec la base de données pour récupérer les produits
//    ou en ajouter. Nous allons simuler ce comportement en créant des produits en dur dans le code.


package com.ecommerce.microcommerce.web.dao;

import com.ecommerce.microcommerce.web.model.Client;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao{
    public static List<Client> clients = new ArrayList<>();

    static {
        try {
            clients.add(new Client(1, "Mario", "Fautrell", birthDay("1989-07-16"), 121545));
            clients.add(new Client(2, "Louis", "De Funes", birthDay("1964-04-11"), 326645));
            clients.add(new Client(3, "Sergio", "Gomes", birthDay("1979-01-26"), 120045));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Date birthDay(String date) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = sdf.parse(date);
        return dt;
    }

    @Override
    public List<Client> findAll(){
        return clients;
    }

    @Override
    public Client findById(int id){
        for (Client client : clients){
            if(client.getId() == id){
                return client;
            }
        }
        return null;
    }

    @Override
    public Client save(Client client){
        clients.add(client);
        return client;
    }

    @Override
    public Client remove(int id) {
        Client removeClient = findById(id);
        if(removeClient != null){
            clients.remove(removeClient);
        }
        return removeClient;
    }

    @Override
    public  Client update(int id, Client client){
        Client clientUpdate = findById(id);
        if(clientUpdate != null ){
            clientUpdate.setFirstName(client.getFirstName());
            clientUpdate.setLastName(client.getLastName());
            clientUpdate.setDateBirth(client.getDateBirth());
            clientUpdate.setDrivingLicenceNumber(client.getDrivingLicenceNumber());
        }
        return clientUpdate;
    }

}
