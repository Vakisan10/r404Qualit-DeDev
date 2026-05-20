package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class VoitureTest {

    @BeforeAll
    void creerVoiture(){
        Voiture voiture1= new Voiture("Volkswagen",3800);
        voiture1.setId()==1;
        Voiture voiture2= new Voiture("Ferrari",18000);
        voiture2.setId()==2;
        }
    @Test
    void TestVoiture(){
        Assert.isTrue(voiture1.getPrix() ==3800,"Doit être 3800");
        Assert.isTrue(voiture1.getMarque().equals("Volkswagen"),"Doit être Volkswagen");
        Assert.isTrue(voiture1.getId().equals(1));
        Assert.isTrue(voiture2.getPrix() ==18000,"Doit être 18000");
        Assert.isTrue(voiture2.getMarque()== "Ferrari","Doit être Volkswagen");
        Assert.isFalse(voiture1.getId().equals(1));
        
    }

}
