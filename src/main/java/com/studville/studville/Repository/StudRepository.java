package com.studville.studville.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studville.studville.Entity.Stud;


@Repository
public interface StudRepository extends JpaRepository<Stud, Long> {

    Optional<Stud> findByEmail(String email);
    Optional<Stud> findByName(String name);
    
}
