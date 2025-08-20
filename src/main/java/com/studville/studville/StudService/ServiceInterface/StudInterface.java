package com.studville.studville.StudService.ServiceInterface;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.studville.studville.Entity.Stud;

public interface StudInterface {
    
    Stud addStud(Stud stud);
    List<Stud> getAllStuds();
    Page<Stud> listAllstuds(Pageable pageable);
    Stud findStudById(Integer Id);
    Stud findStudByEmail(String email);
    Stud updateStud(Stud stud, Integer id);
    void removeStud(Integer id);
    
}
