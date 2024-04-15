package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pet {
    // VARIABLES

    private String name;
    private int age;
    private String species;
    private List<Person> owners = new ArrayList<>();

    // CONSTRUCTORS
    public Pet(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;

    }

    // FUNCTIONS
    public void addOwner(Person owner) {
        if (!owners.contains(owner)) {
            this.owners.add(owner);
            owner.addPet(this);
        } else {
            System.out.println(this.name + " is (already) added as " + owner.getName() + "'s pet");
        }
    }


    // GETTERS AND SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public List<Person> getOwners() {
        return this.owners;
    }
}
