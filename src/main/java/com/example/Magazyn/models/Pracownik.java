package com.example.Magazyn.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Pracownicy")
public class Pracownik  implements Comparable{

    @Id
    int pracownikId;
    String imie;
    String nazwisko;
    String dataZatrudnienia;
    int magazynId;
    String stanowisko;

    public int getMagazynId() {
        return magazynId;
    }

    public void setMagazynId(int magazynId) {
        this.magazynId = magazynId;
    }

    public int getPracownikId() {
        return pracownikId;
    }

    public void setPracownikId(int pracownikId) {
        this.pracownikId = pracownikId;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public String getDataZatrudnienia() {
        return dataZatrudnienia;
    }

    public void setDataZatrudnienia(String dataZatrudnienia) {
        this.dataZatrudnienia = dataZatrudnienia;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
