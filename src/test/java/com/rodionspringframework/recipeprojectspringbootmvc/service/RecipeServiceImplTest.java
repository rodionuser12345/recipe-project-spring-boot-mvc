package com.rodionspringframework.recipeprojectspringbootmvc.service;

import com.rodionspringframework.recipeprojectspringbootmvc.converters.RecipeDtoToRecipe;
import com.rodionspringframework.recipeprojectspringbootmvc.converters.RecipeToRecipeDto;
import com.rodionspringframework.recipeprojectspringbootmvc.domain.Recipe;
import com.rodionspringframework.recipeprojectspringbootmvc.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    final Long ID = 1L;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeDtoToRecipe dtoToEntityConverter;

    @Mock
    RecipeToRecipeDto entityToDtoConverter;

    RecipeServiceImpl recipeService;

    @BeforeEach
    void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository, dtoToEntityConverter, entityToDtoConverter);
    }

    @Test
    void getRecipesTest() throws Exception {

        Recipe recipe = new Recipe();
        Set<Recipe> recipeDataActual = new HashSet<>();
        recipeDataActual.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipeDataActual);

        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipeDataActual, recipes);

        verify(recipeRepository, times(1)).findAll();

    }

    @Test
    void getRecipesByIdTest() throws Exception {

        Recipe recipe = new Recipe();
        recipe.setId(ID);

        when(recipeRepository.findById(anyLong())).thenReturn(Optional.of(recipe));

        Recipe recipeActual = recipeService.findById(ID);

        assertNotNull(recipeActual);

        verify(recipeRepository, times(1)).findById(anyLong());

    }


}