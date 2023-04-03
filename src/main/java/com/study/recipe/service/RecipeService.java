package com.study.recipe.service;

import com.study.recipe.data.Ingredients;
import com.study.recipe.data.Recipe;
import com.study.recipe.repository.IngredientsRepository;
import com.study.recipe.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientsRepository ingredientsRepository;

    public RecipeService(RecipeRepository recipeRepository, IngredientsRepository ingredientsRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientsRepository = ingredientsRepository;
    }

    public List<Recipe> findAll() {
        return this.recipeRepository.findAll();
    }

    public void initRecipes() {
        Recipe recipe = new Recipe();
        recipe.setName("Chicken curry");
        saveIngredient(recipe, "1 tbsp vegetable oil");
        saveIngredient(recipe, "1.2kg Coles RSPCA Approved Chicken Thigh Fillets, trimmed, cut into 4cm pieces");
        saveIngredient(recipe, "1 brown onion, halved, thinly sliced");
        saveIngredient(recipe, "2 garlic cloves, crushed");
        recipeRepository.save(recipe);

        recipe = new Recipe();
        recipe.setName("Savoury mince recipe for two");
        saveIngredient(recipe, "2 tsp olive oil ");
        saveIngredient(recipe, "1 small brown onion, finely chopped ");
        saveIngredient(recipe, "250g beef mince");
        saveIngredient(recipe, "1 tbsp instant beef gravy powder ");
        recipeRepository.save(recipe);

        recipe = new Recipe();
        recipe.setName("Chilli con carne nachos");
        saveIngredient(recipe, "1 avocado, peeled, stoned, mashed ");
        saveIngredient(recipe, "2 tbsp sour cream ");
        saveIngredient(recipe, "2 tsp chilli sauce ");
        saveIngredient(recipe, "Sliced jalapeño chilli, to serve ");
        recipeRepository.save(recipe);
    }

    private void saveIngredient(Recipe recipe, String name) {
        Ingredients ingredients = new Ingredients(name);
        ingredientsRepository.save(ingredients);
        recipe.getIngredients().add(ingredients);
    }
}
