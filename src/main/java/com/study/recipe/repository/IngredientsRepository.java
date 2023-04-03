package com.study.recipe.repository;

import com.study.recipe.data.Ingredients;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsRepository extends ListCrudRepository<Ingredients, Long> {
}
