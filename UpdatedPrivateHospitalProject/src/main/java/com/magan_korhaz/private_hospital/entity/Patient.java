package com.magan_korhaz.private_hospital.entity;

import jakarta.persistence.*;

@Entity // Ez jelzi a JPA-nak, hogy ez egy adatbázistábla
@Table(name = "patients") // Ez opcionális, de megadhatod az adatbázisban használandó táblanevet
public class Patient {

    @Id // Elsődleges kulcs megjelölése
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatikusan generált érték
    private Long id;

    @Column(nullable = false) // Ez a mező nem lehet null
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String diagnosis;

    // Getters és Setters
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}

