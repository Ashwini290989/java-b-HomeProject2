package see.ashwini.advanture.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {



    @Test
    void punch() {
        Resident resident = new Resident("Resident",12,3);
        Burglar burglar = new Burglar("Burglar",12,4);
        int health = burglar.getHealth();
         resident.punch(burglar);
         assertEquals(9,burglar.getHealth());
    }


    @Test
    void takeHit() {
        Resident resident = new Resident("Resident",12,3);
        Burglar burglar = new Burglar("Burglar",12,4);
        int health = burglar.getHealth();
        int damage = 5;
        burglar.takeHit(damage);
        assertEquals(health-damage,burglar.getHealth());

    }


    @Test
    void isConcious() {

        Resident resident = new Resident("Resident",12,3);
        Burglar burglar = new Burglar("Burglar",12,4);
        while (burglar.isConcious()) {
           resident.punch(burglar);
        }
        assertFalse(burglar.isConcious());
    }
}