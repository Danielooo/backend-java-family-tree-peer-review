import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    @Test
    void testAddOwner() {
        Person me = new Person("Daniel", "Wouter", "van Raffe", "Male", 35);

        Pet sparky = new Pet("Sparky", 10, "Dog");

        sparky.addOwner(me);

        assertEquals("Daniel", sparky.getOwners().getFirst().getName());
        assertEquals("Sparky", me.getPets().getFirst().getName());
    }
}