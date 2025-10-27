package com.dawan.atelier_implementation.interfaces.resource;

public abstract class Animal {
    protected int pattes;
    protected String nom;
    protected int age;

    protected Animal(int pattes, String nom, int age) {
        this.pattes = pattes;
        this.nom = nom;
        this.age = age;
    }

    public int getPattes() {
        return pattes;
    }

    public void setPattes(int pattes) {
        this.pattes = pattes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
