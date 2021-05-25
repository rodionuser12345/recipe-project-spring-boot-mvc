package com.rodionspringframework.recipeprojectspringbootmvc.service;

import com.rodionspringframework.recipeprojectspringbootmvc.domain.Recipe;
import com.rodionspringframework.recipeprojectspringbootmvc.dto.RecipeDto;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeDto saveRecipe(RecipeDto recipeDto);
}
