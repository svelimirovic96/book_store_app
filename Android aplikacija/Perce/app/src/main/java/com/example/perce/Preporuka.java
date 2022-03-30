package com.example.perce;

public class Preporuka {
    int id;
    String primalac;
    int knjiga_id;
    String posiljalac;

    public Preporuka(int id, String primalac, int knjiga_id, String posiljalac) {
        this.id = id;
        this.primalac = primalac;
        this.knjiga_id = knjiga_id;
        this.posiljalac = posiljalac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrimalac() {
        return primalac;
    }

    public void setPrimalac(String primalac) {
        this.primalac = primalac;
    }

    public int getKnjiga_id() {
        return knjiga_id;
    }

    public void setKnjiga_id(int knjiga_id) {
        this.knjiga_id = knjiga_id;
    }

    public String getPosiljalac() {
        return posiljalac;
    }

    public void setPosiljalac(String posiljalac) {
        this.posiljalac = posiljalac;
    }
}
