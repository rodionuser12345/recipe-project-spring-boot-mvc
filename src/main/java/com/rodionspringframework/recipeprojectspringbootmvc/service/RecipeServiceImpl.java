package com.rodionspringframework.recipeprojectspringbootmvc.service;

import com.rodionspringframework.recipeprojectspringbootmvc.domain.Recipe;
import com.rodionspringframework.recipeprojectspringbootmvc.repositories.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Service
@RequestMapping("/recipes")
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {

        Set<Recipe> recipes = new HashSet<>();

        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);

        return recipes;
    }
}
