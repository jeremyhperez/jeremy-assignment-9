package com.coderscampus.assignment9.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Repository;

import com.coderscampus.assignment9.domain.Recipe;

@Repository
public class RecipeRepository {
	 private List<Recipe> recipes = new ArrayList<>();

	    public void loadRecipes() throws IOException {
	//    	Path filePath = Path.of("recipes.txt");
	        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
	                .setHeader()
	                .setSkipHeaderRecord(true)
	                .build();

	        try (CSVParser csvParser = new CSVParser(Files.newBufferedReader(Path.of("recipes.txt")), csvFormat)) {
	            for (CSVRecord record : csvParser) {
	                Recipe recipe = new Recipe();
	                recipe.setCookingMinutes(Integer.parseInt(record.get("Cooking Minutes")));
	                recipe.setDairyFree(Boolean.parseBoolean(record.get("Dairy Free")));
	                recipe.setGlutenFree(Boolean.parseBoolean(record.get("Gluten Free")));
	                recipe.setInstructions(record.get("Instructions"));
	                recipe.setPreparationMinutes(Double.parseDouble(record.get("Preparation Minutes")));
	                recipe.setPricePerServing(Double.parseDouble(record.get("Price Per Serving")));
	                recipe.setReadyInMinutes(Integer.parseInt(record.get("Ready In Minutes")));
	                recipe.setServings(Integer.parseInt(record.get("Servings")));
	                recipe.setSpoonacularScore(Double.parseDouble(record.get("Spoonacular Score")));
	                recipe.setTitle(record.get("Title"));
	                recipe.setVegan(Boolean.parseBoolean(record.get("Vegan")));
	                recipe.setVegetarian(Boolean.parseBoolean(record.get("Vegetarian")));

	                recipes.add(recipe);
	            }
	        }
	    }

	    public List<Recipe> getRecipes() {
	        return recipes;
	    }
}
