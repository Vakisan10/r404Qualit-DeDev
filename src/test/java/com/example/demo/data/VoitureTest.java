package com.example.demo.data;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VoitureTest {

    private static Voiture voiture1;
    private static Voiture voiture2;
    private static Voiture voiture3;

    @BeforeAll
    static void creerVoitures() {
        voiture1 = new Voiture("Renault", 12000);
        voiture1.setId(1);

        voiture2 = new Voiture("Peugeot", 18000);
        voiture2.setId(2);

        voiture3 = new Voiture("Toyota", 25000);
        voiture3.setId(3);
    }

    @Test
    void testVoitures() {
        assertEquals(12000, voiture1.getPrix());
        assertEquals("Renault", voiture1.getMarque());
        assertEquals(1, voiture1.getId());

        assertEquals(18000, voiture2.getPrix());
        assertEquals("Peugeot", voiture2.getMarque());
        assertEquals(2, voiture2.getId());

        assertEquals(25000, voiture3.getPrix());
        assertEquals("Toyota", voiture3.getMarque());
        assertEquals(3, voiture3.getId());
    }

    @Test
    void testToString() {
        assertNotNull(voiture1.toString());
        assertTrue(voiture1.toString().contains("Renault"));
    }
}
