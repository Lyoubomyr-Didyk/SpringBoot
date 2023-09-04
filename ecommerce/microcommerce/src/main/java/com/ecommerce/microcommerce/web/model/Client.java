package com.ecommerce.microcommerce.web.model;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFilter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


// @JsonFilter("monFiltreDynamique")  // commenter pour pouvoir utiliser les autres méthodes qui n'ont pas de filtres
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private Date dateBirth;
    private int drivingLicenceNumber ;



    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateBirth=" + dateBirth +
                ", drivingLicenceNumber=" + drivingLicenceNumber +
                '}';
    }


    //  🥎 -------- constructor ----------

    public Client(){};

    public Client (int id, String firstName, String lastName, Date dateBirth, int drivingLicenceNumber){

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateBirth = dateBirth;
        this.drivingLicenceNumber = drivingLicenceNumber;
    }


    //  🥎 -------- getter and setter ----------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public int getDrivingLicenceNumber() {
        return drivingLicenceNumber;
    }

    public void setDrivingLicenceNumber(int drivingLicenceNumber) {
        this.drivingLicenceNumber = drivingLicenceNumber;
    }
}




