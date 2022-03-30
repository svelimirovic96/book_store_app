package com.example.perce;

import java.io.Serializable;

public class Knjiga implements Serializable {
    int id, broj_strana;
    String naziv, autor, godina_izdanja, opis;
    boolean promocija;
    int idSlika;

    public Knjiga(int id, int broj_strana, String naziv, String autor, String godina_izdanja, String opis, int idSlika, boolean promocija) {
        this.id = id;
        this.broj_strana = broj_strana;
        this.naziv = naziv;
        this.autor = autor;
        this.godina_izdanja = godina_izdanja;
        this.opis = opis;
        this.idSlika=idSlika;
        this.promocija = promocija;
    }

    public int getIdSlika() {
        return idSlika;
    }

    public void setIdSlika(int idSlika) {
        this.idSlika = idSlika;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBroj_strana() {
        return broj_strana;
    }

    public void setBroj_strana(int broj_strana) {
        this.broj_strana = broj_strana;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGodina_izdanja() {
        return godina_izdanja;
    }

    public void setGodina_izdanja(String godina_izdanja) {
        this.godina_izdanja = godina_izdanja;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public boolean isPromocija() {
        return promocija;
    }

    public void setPromocija(boolean promocija) {
        this.promocija = promocija;
    }
}
