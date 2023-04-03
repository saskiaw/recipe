package com.study.recipe.controller;

import com.study.recipe.data.Recipe;
import com.study.recipe.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;

        initRecipes();
    }

    private void initRecipes() {
        this.recipeService.initRecipes();
    }

    @GetMapping("/list")
    public List<Recipe> findAll(Model model){
        List<Recipe> recipes = this.recipeService.findAll();
        model.addAttribute("recipes", recipes);
        return recipes;
    }
}
