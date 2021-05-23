package com.rodionspringframework.recipeprojectspringbootmvc.repositories;

import com.rodionspringframework.recipeprojectspringbootmvc.domain.UnitOfMeasure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
class UnitOfMeasureRepositoryTest {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByDescriptionTeaspoon() throws Exception{

        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");

        Assertions.assertEquals("Teaspoon", teaspoon.get().getDescription());
    }

    @Test
    void findByDescriptionCup() throws Exception{

        Optional<UnitOfMeasure> cup = unitOfMeasureRepository.findByDescription("Cup");

        Assertions.assertEquals("Cup", cup.get().getDescription());
    }
}