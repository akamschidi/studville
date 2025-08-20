package com.studville.studville.StudServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.awaitility.core.AssertionCondition;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.studville.studville.Entity.Stud;
import com.studville.studville.Exceptions.StudNotFoundException;
import com.studville.studville.Repository.StudRepository;
import com.studville.studville.StudService.StudService;


@ExtendWith(MockitoExtension.class)
public class ServiceTest {
 
    @Mock
    StudRepository repository;

    @InjectMocks
    StudService service;

    

    @Test
    void AddStudShouldAddStudSuccessFully(){
        Stud stud = new Stud();
        stud.setId(1);
        stud.setName("Chelsea T");
        stud.setEmail("chelsea@gmail.com");
        stud.setAge(33);
        stud.setLocation("Abuja");
        stud.setOccupation("Forex Trader");
        stud.setIncome(600000);

        Mockito.when(repository.save(stud)).thenReturn(stud);

        Stud addStud = service.addStud(stud);

        assertEquals(stud.getId(), addStud.getId());
        assertEquals(stud.getName(), addStud.getName());
        assertEquals(stud.getAge(), addStud.getAge());
        assertEquals(stud.getOccupation(), addStud.getOccupation());

        assertNotNull(addStud);
        assertTrue(stud.getEmail()=="chelsea@gmail.com");
        assertTrue(stud.getId()== 1);
    }

        /*
         Running Test: 
         . Create a mock entity and create a sample entity.
         . Create a mock of what you want to happen if the entity is called using either when or given. 
         . Create a entity from the service class. ie, call the service method. 
         . use the mock to assert if the mock entity and the entity from the service class gives similar results. 
         */

         @Test
         void findByIdIsSuccessful(){
             Stud studd = new Stud();
        studd.setId(1);
        studd.setName("Chelsea T");
        studd.setEmail("chelsea@gmail.com");
        studd.setAge(33);
        studd.setLocation("Abuja");
        studd.setOccupation("Forex Trader");
        studd.setIncome(600000);
        
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(studd));
        
        Stud finddStud = service.findStudById(1);

        assertEquals(studd, finddStud);

         }


    @Test
    void findByIdNotSuccessfullThrowException(){
        //Stud studdd = new Stud();
        //studdd.setId(9);

      /* 
        Mockito.when(repository.findById(studID)).thenReturn(Optional.empty());

        StudNotFoundException thrown = Assertions.assertThrows(StudNotFoundException.class,
                                        () -> service.findStudById(9));
        
        assertEquals("Stud With ID 9 Not Found", thrown.getMessage());
    
        */

    

    }
}