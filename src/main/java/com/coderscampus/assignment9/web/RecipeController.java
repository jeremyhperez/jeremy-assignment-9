package com.coderscampus.assignment9.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.service.RecipeService;

@RestController
public class RecipeController {
    private final RecipeService service;

    public RecipeController(RecipeService service) {
        this.service = service;
    }

    @GetMapping("/all-recipes")
    public List<Recipe> getAllRecipes() {
        return service.getAllRecipes();
    }

    @GetMapping("/gluten-free")
    public List<Recipe> getGlutenFreeRecipes() {
        return service.getGlutenFreeRecipes();
    }

    @GetMapping("/vegan")
    public List<Recipe> getVeganRecipes() {
        return service.getVeganRecipes();
    }

    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> getVeganAndGlutenFreeRecipes() {
        return service.getVeganAndGlutenFreeRecipes();
    }

    @GetMapping("/vegetarian")
    public List<Recipe> getVegetarianRecipes() {
        return service.getVegetarianRecipes();
    }
}
