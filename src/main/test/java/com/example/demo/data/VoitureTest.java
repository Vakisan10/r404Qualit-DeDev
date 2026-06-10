package com.example.demo.data;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VoitureTest {

    private static Voiture voiture1;
    private static Voiture voiture2;

    @BeforeAll
    static void creerVoiture() {
        voiture1 = new Voiture("Volkswagen", 3800);
        voiture1.setId(1);

        voiture2 = new Voiture("Ferrari", 18000);
        voiture2.setId(2);
    }

    @Test
    void testVoiture() {
        assertEquals(3800, voiture1.getPrix());
        assertEquals("Volkswagen", voiture1.getMarque());
        assertEquals(1, voiture1.getId());

        assertEquals(18000, voiture2.getPrix());
        assertEquals("Ferrari", voiture2.getMarque());
        assertEquals(2, voiture2.getId());
    }
}