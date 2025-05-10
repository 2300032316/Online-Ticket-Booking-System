package com.example.demo.controller;

import com.example.demo.entity.Pet;
import com.example.demo.Service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/pets")
@CrossOrigin(origins = "http://localhost:5173")
public class PetController {
    @Autowired
    private PetService petService;

    @PostMapping("/donate")
    public ResponseEntity<?> donatePet(@RequestBody Pet pet) {
        try {
            System.out.println("Received pet donation: " + pet);
            Pet savedPet = petService.savePet(pet);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPet);
        } catch (Exception e) {
            System.err.println("Error saving pet: " + e.getMessage());
            e.printStackTrace();
            // Return a JSON response for errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Failed to save pet", "message", e.getMessage()));
        }
    }
}
