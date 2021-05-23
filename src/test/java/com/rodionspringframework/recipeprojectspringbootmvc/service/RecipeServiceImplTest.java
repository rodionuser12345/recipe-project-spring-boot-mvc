package com.rodionspringframework.recipeprojectspringbootmvc.service;

import com.rodionspringframework.recipeprojectspringbootmvc.domain.Recipe;
import com.rodionspringframework.recipeprojectspringbootmvc.repositories.RecipeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void getRecipes() throws Exception {

        Recipe recipe = new Recipe();
        Set<Recipe> recipeDataActual = new HashSet<>();
        recipeDataActual.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipeDataActual);

        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipeDataActual, recipes);

        verify(recipeRepository,times(3)).findAll();

    }
}