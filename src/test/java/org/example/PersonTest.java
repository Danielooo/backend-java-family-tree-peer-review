package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person me = new Person("Daniel", "Wouter", "van Raffe", "Male", 35);

    Person dad = new Person("John", "van Raffe", "Male", 65);

    Person mom = new Person("Yolanda", "van Raffe", "Female", 63);

    Person sister = new Person("Amber", "van Raffe",  "Female", 30);

    Pet sparky = new Pet("Sparky", 10, "Dog");

    Person grandma = new Person("Beppie", "de Jong", "Female", 90);

    @Test
    void addPet() {
        me.addPet(sparky);

        assertEquals("Sparky", me.getPets().getFirst().getName());
        assertEquals("Dog", me.getPets().getFirst().getSpecies());

        assertEquals("Daniel", sparky.getOwners().getFirst().getName());
    }

    @Test
    void addChild() {
        Person person = new Person("Jan", "de Jong", "Male", 40);
        Person child = new Person("Kiddo", "de Jong", "Male", 12);

        // expected > actual
        // assertEquals(child.getName(), "Kiddo");
        assertEquals(child.getName(), "Kiddo");
    }

    @Test
    void getGrandChildren() {
        Person grandparent = new Person("Geertruida", "de Vries", "Female", 100);
        Person kid = new Person("Simon", "de Vries", "Male", 60);
        Person grandkid = new Person("Splinter", "de Vries", "Male", 16);

        kid.addChild(grandkid);
        kid.addParent(grandparent);

        assertEquals("Splinter",  grandparent.getGrandChildren().get(0).getName());
    }


    @Test
    void addParent() {
        me.addParent(dad);

        assertEquals("John", me.getFather().getName());
        assertEquals("Daniel", dad.getChildren().getFirst().getName());
    }

    @Test
    void testAddChild() {
        dad.addChild(me);

        assertEquals("Daniel", dad.getChildren().getFirst().getName());
        assertEquals("John", me.getFather().getName());
    }

    @Test
    void addSibling() {
        me.addSibling(sister);

        assertEquals("Amber", me.getSiblings().getFirst().getName());
        assertEquals("Daniel", sister.getSiblings().getFirst().getName());
    }
}