package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {OperateurServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class OperateurTest {

    @MockBean
    private OperateurRepository operateurRepository;

    @Autowired
    private OperateurServiceImpl operateurService;

    @Test
    void testRetrieveAllOperateurs() {
        List<Operateur> operateurList = new ArrayList<>();
        when(operateurRepository.findAll()).thenReturn(operateurList);
        List<Operateur> actualRetrieveAllOperateursResult = operateurService.retrieveAllOperateurs();
        assertSame(operateurList, actualRetrieveAllOperateursResult);
        assertTrue(actualRetrieveAllOperateursResult.isEmpty());
        verify(operateurRepository).findAll();
    }

    @Test
    void testDeleteOperateur() {
        doNothing().when(operateurRepository).deleteById(any(Long.class));
        operateurService.deleteOperateur(123L);
        verify(operateurRepository).deleteById(any(Long.class));
    }
}
