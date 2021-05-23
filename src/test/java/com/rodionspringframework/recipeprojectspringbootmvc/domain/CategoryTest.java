package com.rodionspringframework.recipeprojectspringbootmvc.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;

    @BeforeEach
    void setUp() {
        category = new Category();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getId() {

        Long id = 4l;

        category.setId(id);

        assertEquals(id,category.getId());
    }

    @Test
    void getDescription() {
    }

    @Test
    void getRecipes() {
    }
}