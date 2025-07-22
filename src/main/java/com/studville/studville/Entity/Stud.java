package com.studville.studville.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "studville")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Stud {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "enter your first and last name")
    private String name;
    @Email(message = "add a value email address...")
    private String email;
    private int age;
    private String location;
    private String occupation;
    private Long income;

    
}
