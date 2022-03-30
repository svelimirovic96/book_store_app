package com.example.perce;

import java.io.Serializable;

public class Korisnik implements Serializable {
    String ime;
    String prezime;
    String telefon;
    String adresa;
    String kor_ime;
    String lozinka;

    public Korisnik(String ime, String prezime, String telefon, String adresa, String kor_ime, String lozinka) {
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
        this.adresa = adresa;
        this.kor_ime = kor_ime;
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getKor_ime() {
        return kor_ime;
    }

    public void setKor_ime(String kor_ime) {
        this.kor_ime = kor_ime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
}
