package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BaseDeDonneesTests {

    @MockBean
    private VoitureRepository voitureRepository;

    @Test
    void sauvegarderVoiture() {
        Voiture v = new Voiture("Renault", 12000);
        v.setId(1);

        when(voitureRepository.save(v)).thenReturn(v);

        Voiture resultat = voitureRepository.save(v);

        assertEquals("Renault", resultat.getMarque());
        assertEquals(12000, resultat.getPrix());
        verify(voitureRepository).save(v);
    }

    @Test
    void rechercherVoitureParId() {
        Voiture v = new Voiture("Peugeot", 18000);
        v.setId(2);

        when(voitureRepository.findById(2)).thenReturn(Optional.of(v));

        Optional<Voiture> resultat = voitureRepository.findById(2);

        assertTrue(resultat.isPresent());
        assertEquals("Peugeot", resultat.get().getMarque());
    }

    @Test
    void supprimerVoiture() {
        Voiture v = new Voiture("Citroën", 9000);
        v.setId(3);

        voitureRepository.delete(v);

        verify(voitureRepository).delete(v);
    }
}
