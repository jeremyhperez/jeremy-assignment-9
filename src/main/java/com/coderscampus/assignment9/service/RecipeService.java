package com.coderscampus.assignment9.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.repository.RecipeRepository;

@Service
public class RecipeService {
    private final RecipeRepository repository;

    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public List<Recipe> getAllRecipes() {
        return repository.getRecipes();
    }

    public List<Recipe> getGlutenFreeRecipes() {
        return repository.getRecipes().stream()
                .filter(Recipe::getGlutenFree)
                .collect(Collectors.toList());
    }

    public List<Recipe> getVeganRecipes() {
        return repository.getRecipes().stream()
                .filter(Recipe::getVegan)
                .collect(Collectors.toList());
    }

    public List<Recipe> getVeganAndGlutenFreeRecipes() {
        return repository.getRecipes().stream()
                .filter(recipe -> recipe.getVegan() && recipe.getGlutenFree())
                .collect(Collectors.toList());
    }

    public List<Recipe> getVegetarianRecipes() {
        return repository.getRecipes().stream()
                .filter(Recipe::getVegetarian)
                .collect(Collectors.toList());
    }
}
