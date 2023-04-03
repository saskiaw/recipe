package com.study.recipe.repository;

import com.study.recipe.data.Recipe;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends ListCrudRepository<Recipe, Long> {
}
