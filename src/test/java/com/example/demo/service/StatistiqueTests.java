package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StatistiqueTests {

    @Test
    void testMockito() {

        Statistique statistique = mock(Statistique.class);

        when(statistique.prixMoyen())
                .thenReturn(new Echantillon(3, 15000));

        Echantillon e = statistique.prixMoyen();

        assertEquals(3, e.getNombreDeVoitures());
        assertEquals(15000, e.getPrixMoyen());

        verify(statistique).prixMoyen();
    }

    @Test
    void testPrixMoyen() {

        StatistiqueImpl s = new StatistiqueImpl();

        s.ajouter(new Voiture("Renault", 12000));
        s.ajouter(new Voiture("Peugeot", 18000));
        s.ajouter(new Voiture("Citroën", 9000));

        Echantillon e = s.prixMoyen();

        assertEquals(3, e.getNombreDeVoitures());
        assertEquals(13000, e.getPrixMoyen());
    }

    @Test
    void testPrixMoyenException() {

        StatistiqueImpl s = new StatistiqueImpl();

        assertThrows(ArithmeticException.class,
                () -> s.prixMoyen());
    }

    @Test
    void testEchantillonSetters() {

        Echantillon e = new Echantillon();

        e.setNombreDeVoitures(5);
        e.setPrixMoyen(22000);

        assertEquals(5, e.getNombreDeVoitures());
        assertEquals(22000, e.getPrixMoyen());
    }

    @Test
    void testUneSeuleVoiture() {

        StatistiqueImpl s = new StatistiqueImpl();

        s.ajouter(new Voiture("Toyota", 20000));

        Echantillon e = s.prixMoyen();

        assertEquals(1, e.getNombreDeVoitures());
        assertEquals(20000, e.getPrixMoyen());
    }
}
