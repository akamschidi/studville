package com.studville.studville.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.studville.studville.Entity.Stud;
import com.studville.studville.Entity.Stud;
import com.studville.studville.StudService.StudService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class StudController {
    private StudService service;

    public StudController(StudService service) {
        this.service = service;
    }

    @PostMapping("/newstud")
    public ResponseEntity<Stud> addStud(@RequestBody Stud stud) {
        Stud saveStud = service.addStud(stud);
        return new ResponseEntity<>(saveStud, HttpStatus.CREATED);
        }

    @GetMapping("/allstuds")
    public List<Stud> allStuds() {
        return service.getAllStuds();
    }

    @GetMapping("/stud/{id}")
    public ResponseEntity<Stud> findStudById(@PathVariable Long id) {
        Optional<Stud> studByID = service.findStudByID(id)
        return new ResponseEntity<>(studByID, HttpStatus.OK);
    }
    
    
    

    
}
