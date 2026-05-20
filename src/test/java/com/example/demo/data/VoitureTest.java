package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class VoitureTest {

    @BeforeAll
    void creerVoiture(){
        Voiture voiture= new Voiture("Volkswagen",3800)
        }
    @Test
    void TestVoiture(){
        Assert.istrue(voiture.getPrix() ==3800,"Doit être 3800")
        Assert.isTrue(voiture.getMarque().equals("Volkswagen"),"Doit être Volkswagen")

    }

}
