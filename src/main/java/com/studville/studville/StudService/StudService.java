package com.studville.studville.StudService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.studville.studville.Entity.Stud;
import com.studville.studville.Exceptions.StudNotFoundException;
import com.studville.studville.Repository.StudRepository;
import com.studville.studville.StudService.ServiceInterface.StudInterface;

@Service
public class StudService implements StudInterface{

    private StudRepository repository;

    public StudService(StudRepository repository) {
        this.repository = repository;
    }

    @Override
    public Stud addStud(Stud stud) {
       Optional<Stud> newStud = repository.findByEmail(stud.getEmail());

       if(newStud.isPresent()){
        throw new StudNotFoundException("Stud With Email" + stud.getEmail() + "Already Exists");
       }
       return repository.save(stud);  
    }


    @Override
    public List<Stud> getAllStuds() {
        return repository.findAll();
    }

    @Override
    public Stud findStudById(Long Id) {
      return repository.findById(Id)
      .orElseThrow(() -> new StudNotFoundException("Stud With Id" + Id + "Not Found"));

    }
/* 
    @Override
    public Optional<Stud> findStudByIdd(Long Id){
        return repository.findById(Id);
    }
        */

    @Override
    public Stud findStudByEmail(String email) {
        return repository.findByEmail(email)
        .orElseThrow(() -> new StudNotFoundException("Stud With Email Address" + email + "Not Found"));
    }



    @Override
    public Stud updateStud(Stud stud, Long id) {
       Stud existingStud = repository.findById(id)
        .orElseThrow(()->new StudNotFoundException("Stud Not Found...."));

        existingStud.setName(stud.getName());
        existingStud.setEmail(stud.getEmail());
        existingStud.setAge(stud.getAge());
        existingStud.setLocation(stud.getLocation());
        existingStud.setOccupation(stud.getOccupation());
        existingStud.setIncome(stud.getIncome());

      repository.save(existingStud);
      return existingStud;

    }

    @Override
    public void removeStud(Long id) {
       repository.deleteById(id);
    }
    
}
