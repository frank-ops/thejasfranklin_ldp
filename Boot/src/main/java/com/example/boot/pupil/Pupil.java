package com.example.boot.pupil;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.Period;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
public class Pupil {

    @Id
    @SequenceGenerator(
            name="Pupil_sequence",
            sequenceName="Pupil_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "Pupil_sequence"
    )
    @Column(

            updatable = false
    )
    private Long id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    public Pupil() {

    }

    public int getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    @Transient
    private int age;
    private String email;

    public Pupil(String name, LocalDate dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public Pupil(Long id, String name, LocalDate dob,String email) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
