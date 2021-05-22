package com.rodionspringframework.recipeprojectspringbootmvc.controllers;

import com.rodionspringframework.recipeprojectspringbootmvc.domain.Category;
import com.rodionspringframework.recipeprojectspringbootmvc.domain.UnitOfMeasure;
import com.rodionspringframework.recipeprojectspringbootmvc.repositories.CategoryRepository;
import com.rodionspringframework.recipeprojectspringbootmvc.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "index"})
    public String getIndexPage() {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat ID is " + categoryOptional.get().getId() + " (" + categoryOptional.get().getDescription() + ")");
        System.out.println("UOM ID is " + unitOfMeasureOptional.get().getId() + " (" + unitOfMeasureOptional.get().getDescription() + ")");

        return "index";
    }
}
