package com.rodionspringframework.recipeprojectspringbootmvc.converters;

import com.rodionspringframework.recipeprojectspringbootmvc.domain.Category;
import com.rodionspringframework.recipeprojectspringbootmvc.domain.Recipe;
import com.rodionspringframework.recipeprojectspringbootmvc.dto.RecipeDto;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.HashSet;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class RecipeToRecipeDto implements Converter<Recipe, RecipeDto>{

    private final CategoryToCategoryDto categoryConveter;
    private final IngredientToIngredientDto ingredientConverter;
    private final NotesToNotesDto notesConverter;

    public RecipeToRecipeDto(CategoryToCategoryDto categoryConveter, IngredientToIngredientDto ingredientConverter,
                             NotesToNotesDto notesConverter) {
        this.categoryConveter = categoryConveter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeDto convert(Recipe source) {

        RecipeDto recipeDto = RecipeDto.builder()
                .id(source.getId())
                .cookTime(source.getCookTime())
                .prepTime(source.getPrepTime())
                .description(source.getDescription())
                .difficulty(source.getDifficulty())
                .directions(source.getDirections())
                .servings(source.getServings())
                .source(source.getSource())
                .url(source.getUrl())
                .notes(notesConverter.convert(source.getNotes()))
                .categories(new HashSet<>())
                .ingredients(new HashSet<>())
                .build();

        setCategoryDtos(source, recipeDto);
        setIngredientDtos(source, recipeDto);

        return recipeDto;
    }

    public void setCategoryDtos(Recipe source, RecipeDto recipeDto){
        if (source.getCategories() != null && source.getCategories().size() > 0) {
            source.getCategories()
                    .forEach(category -> recipeDto.getCategories().add(categoryConveter.convert(category)));
        }

    }

    public void setIngredientDtos(Recipe source, RecipeDto recipeDto){
        if (source.getCategories() != null && source.getCategories().size() > 0) {
            source.getCategories()
                    .forEach(category -> recipeDto.getCategories().add(categoryConveter.convert(category)));
        }

    }


}
