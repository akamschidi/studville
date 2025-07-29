package com.studville.studville.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.studville.studville.Entity.Stud;
import com.studville.studville.StudService.StudService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;





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
/* 
    @GetMapping("/allstuds")
    public List<Stud> allStuds() {
        return service.getAllStuds();
    }
*/
//use pageable to split the list of all data into smaller chunks of data to optimize and increase speed. 
    @GetMapping("/allstuds")
    public ResponseEntity<Page<Stud>> listAllStuds(Pageable pageable){
        Page<Stud> allStuds = service.listAllstuds(pageable);
        return ResponseEntity.ok(allStuds);
    }

    @GetMapping("/stud/{id}")
    public ResponseEntity<Stud> findStudById(@PathVariable Long id) {
       Stud studByID = service.findStudById(id);
        return  ResponseEntity.ok(studByID);
    }
    
    
     @GetMapping("/studs/{email}")
    public ResponseEntity<Stud> findStudByEmail(@PathVariable String email) {
       Stud studByEmail = service.findStudByEmail(email);
        return  ResponseEntity.ok(studByEmail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stud> updateStud(@PathVariable Long id, @RequestBody Stud stud) {
        Stud studUpdate = service.updateStud(stud, id);
         return ResponseEntity.ok(studUpdate);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> removeStud(@PathVariable Long id){
     service.removeStud(id);
     return ResponseEntity.noContent().build();
    }
    
    
    

    
}
