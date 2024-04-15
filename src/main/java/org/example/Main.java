package org.example;

public class Main {
    public static void main(String[] args) {

        Person me = new Person("Daniel", "Wouter", "van Raffe", "Male", 35);

        Person dad = new Person("John", "van Raffe", "Male", 65);

        Person mom = new Person("Yolanda", "van Raffe", "Female", 63);

        Person sister = new Person("Amber", "van Raffe",  "Female", 30);

        Pet sparky = new Pet("Sparky", 10, "Dog");

        Person grandma = new Person("Beppie", "de Jong", "Female", 90);


        // add my siblings
        me.addSibling(sister);

        // add my parents
        me.addParent(dad);
        me.addParent(mom);

        // add parent to my sibling
        sister.addParent(dad);
        sister.addParent(mom);

        // add my pets
        me.addPet(sparky);

        // add parents to my mom
        mom.addParent(grandma);

        // print all the grandchildren in console
        grandma.printGrandChildren();
    }
}