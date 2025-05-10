package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "donated_pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String age;
    private String breed;
    private String donationStatus;

    @Column(name = "donor")
    private String donor;

    @Column(name = "donor_username", nullable = false)
    private String donorUsername;

    // Getters and Setters
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDonationStatus() {
        return donationStatus;
    }

    public void setDonationStatus(String donationStatus) {
        this.donationStatus = donationStatus;
    }

    public String getDonor() {
        return donor;
    }

    public void setDonor(String donor) {
        this.donor = donor;
    }

    public String getDonorUsername() {
        return donorUsername;
    }

    public void setDonorUsername(String donorUsername) {
        this.donorUsername = donorUsername;
    }
}
