package com.studville.studville.StudService.ServiceInterface;

import java.util.List;
import java.util.Optional;

import com.studville.studville.Entity.Stud;

public interface StudInterface {
    
    Stud addStud(Stud stud);
    List<Stud> getAllStuds();
    Optional<Stud> findStudById(Long Id);
    Optional<Stud> findStudByEmail(String email);
    Stud updateStud(Stud stud, Long id);
    void removeStud(Long id);
    
}
