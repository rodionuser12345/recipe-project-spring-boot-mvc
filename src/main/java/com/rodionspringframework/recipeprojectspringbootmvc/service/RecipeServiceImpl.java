package com.rodionspringframework.recipeprojectspringbootmvc.service;

import com.rodionspringframework.recipeprojectspringbootmvc.converters.RecipeDtoToRecipe;
import com.rodionspringframework.recipeprojectspringbootmvc.converters.RecipeToRecipeDto;
import com.rodionspringframework.recipeprojectspringbootmvc.domain.Recipe;
import com.rodionspringframework.recipeprojectspringbootmvc.dto.RecipeDto;
import com.rodionspringframework.recipeprojectspringbootmvc.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@RequestMapping("/recipes")
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeDtoToRecipe dtoToEntityConverter;
    private final RecipeToRecipeDto entityToDtoConverter;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeDtoToRecipe dtoToEntityConverter, RecipeToRecipeDto entityToDtoConverter) {
        this.recipeRepository = recipeRepository;
        this.dtoToEntityConverter = dtoToEntityConverter;
        this.entityToDtoConverter = entityToDtoConverter;
    }

    @Override
    public Set<Recipe> getRecipes() {

        log.debug("I'm in the service");

        Set<Recipe> recipes = new HashSet<>();

        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);

        return recipes;
    }

    @Override
    public Recipe findById(Long id) {

        Optional<Recipe> recipe = recipeRepository.findById(id);

        if (recipe.isEmpty())
            throw new RuntimeException("Recipe is not found");

        return recipe.get();
    }

    @Override
    @Transactional
    public RecipeDto saveRecipe(RecipeDto recipeDto) {
        return entityToDtoConverter.convert(recipeRepository.save(Objects.requireNonNull(dtoToEntityConverter.convert(recipeDto))));

//        Recipe detachedRecipe = dtoToEntityConverter.convert(recipeDto);
//        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
//        log.debug("Saved recipeID: " + savedRecipe.getId());
//        RecipeDto toReturn = entityToDtoConverter.convert(savedRecipe);

    }


}
