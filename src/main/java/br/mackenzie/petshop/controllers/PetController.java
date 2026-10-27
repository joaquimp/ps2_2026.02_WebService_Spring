package br.mackenzie.petshop.controllers;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.mackenzie.petshop.entities.Pet;

@RestController 
public class PetController {
    private List<Pet> pets = new ArrayList<>();
    private int contador;

    public PetController() {
        contador = 0;
        pets.add(new Pet(contador++, "Pipoca", 6));
        pets.add(new Pet(contador++, "Café", 10));
        pets.add(new Pet(contador++, "Barney", 17));
        pets.add(new Pet(contador++, "Lili", 2));
    }

    @GetMapping ("/pets")
    public List<Pet> lerPets() {
        return pets;
    }
    
    @PostMapping("/pets")
    public Pet inserir(@RequestBody Pet novo) {
        novo.setId(contador++);
        pets.add(novo);
        return novo;
    }
}
