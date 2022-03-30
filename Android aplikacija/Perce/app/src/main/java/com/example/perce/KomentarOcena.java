package com.example.perce;

public class KomentarOcena {
    int id;
    String ocenio;
    int ocenjena;
    String komentar;
    int ocena;

    public KomentarOcena(int id, String ocenio, int ocenjena, String komentar, int ocena) {
        this.id = id;
        this.ocenio = ocenio;
        this.ocenjena = ocenjena;
        this.komentar = komentar;
        this.ocena = ocena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOcenio() {
        return ocenio;
    }

    public void setOcenio(String ocenio) {
        this.ocenio = ocenio;
    }

    public int getOcenjena() {
        return ocenjena;
    }

    public void setOcenjena(int ocenjena) {
        this.ocenjena = ocenjena;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }
}
