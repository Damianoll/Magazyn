package com.example.Magazyn.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection = "Magazyn")
public class Magazyn {

    @Id
    int idMagazynu;
    String nazwa;
    String adres;

    public int getIdMagazynu() {
        return idMagazynu;
    }

    public void setIdMagazynu(int idMagazynu) {
        this.idMagazynu = idMagazynu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
