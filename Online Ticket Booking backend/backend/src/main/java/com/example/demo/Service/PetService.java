package com.example.demo.Service;

import com.example.demo.entity.Pet;
import com.example.demo.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public Pet savePet(Pet pet) {
        System.out.println("Saving pet: " + pet);
        try {
            return petRepository.save(pet);
        } catch (Exception e) {
            System.err.println("Error saving pet: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}