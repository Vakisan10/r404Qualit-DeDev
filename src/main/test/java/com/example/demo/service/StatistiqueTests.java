package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StatistiqueTests2 {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Test
    void calculMoyenVoitureSeule() throws ArithmeticException {
        // Vérifie le comportement avec une seule voiture haut de gamme
        Echantillon echantillon = new Echantillon(1, 45000);
        when(statistiqueImpl.prixMoyen()).thenReturn(echantillon);

        Echantillon e = statistiqueImpl.prixMoyen();

        assertEquals(1, e.getNombreDeVoitures());
        assertEquals(45000, e.getPrixMoyen());
    }

    @Test
    void calculMoyenTroisVoitures() throws ArithmeticException {
        // Vérifie la moyenne sur un échantillon de 3 voitures
        Echantillon echantillon = new Echantillon(3, 22000);
        when(statistiqueImpl.prixMoyen()).thenReturn(echantillon);

        Echantillon e = statistiqueImpl.prixMoyen();

        assertEquals(3, e.getNombreDeVoitures());
        assertEquals(22000, e.getPrixMoyen());
    }

    @Test
    void calculMoyenGrandEchantillon() throws ArithmeticException {
        // Vérifie la moyenne sur un grand échantillon
        Echantillon echantillon = new Echantillon(50, 18500);
        when(statistiqueImpl.prixMoyen()).thenReturn(echantillon);

        Echantillon e = statistiqueImpl.prixMoyen();

        assertEquals(50, e.getNombreDeVoitures());
        assertEquals(18500, e.getPrixMoyen());
    }

    @Test
    void ajouterVoiturePeugeot() {
        // Vérifie que ajouter est bien appelé une fois avec une Peugeot
        Voiture v = new Voiture("Peugeot", 8500);
        statistiqueImpl.ajouter(v);
        verify(statistiqueImpl, times(1)).ajouter(v);
    }

    @Test
    void ajouterPlusieursVoituresVerifieChaque() {
        // Vérifie que chaque appel à ajouter est bien comptabilisé séparément
        Voiture v1 = new Voiture("Toyota", 12000);
        Voiture v2 = new Voiture("BMW", 35000);

        statistiqueImpl.ajouter(v1);
        statistiqueImpl.ajouter(v2);

        verify(statistiqueImpl, times(1)).ajouter(v1);
        verify(statistiqueImpl, times(1)).ajouter(v2);
    }

    @Test
    void prixMoyenEstPositif() throws ArithmeticException {
        // Vérifie que le prix moyen retourné est bien un nombre positif
        Echantillon echantillon = new Echantillon(5, 9999);
        when(statistiqueImpl.prixMoyen()).thenReturn(echantillon);

        Echantillon e = statistiqueImpl.prixMoyen();

        assertTrue(e.getPrixMoyen() > 0);
        assertTrue(e.getNombreDeVoitures() > 0);
    }
}