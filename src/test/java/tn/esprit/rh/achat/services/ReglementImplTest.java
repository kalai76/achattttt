package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.rh.achat.entities.Reglement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import org.junit.jupiter.api.TestMethodOrder;

import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ReglementImplTest {
    @Autowired
    IReglementService reglementService;
    @Test
    @Order(1)
    public void testRetrieveAllUsers() {
        List<Reglement> listEtudiants = reglementService.retrieveAllReglements();
        Assertions.assertEquals(0, listEtudiants.size());
    }
}
