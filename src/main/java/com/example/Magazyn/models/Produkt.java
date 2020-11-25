package com.example.Magazyn.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Produkty")
public class Produkt {

    @Id
    int id_produktu;
    String nazwa;
    String marka;
    String model;
    double cena;
    int id_magazynu;

    public int getId_produktu() {
        return id_produktu;
    }

    public void setId_produktu(int id_produktu) {
        this.id_produktu = id_produktu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getId_magazynu() {
        return id_magazynu;
    }

    public void setId_magazynu(int id_magazynu) {
        this.id_magazynu = id_magazynu;
    }
}
