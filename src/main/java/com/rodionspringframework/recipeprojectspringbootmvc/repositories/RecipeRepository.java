package com.rodionspringframework.recipeprojectspringbootmvc.repositories;

import com.rodionspringframework.recipeprojectspringbootmvc.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
