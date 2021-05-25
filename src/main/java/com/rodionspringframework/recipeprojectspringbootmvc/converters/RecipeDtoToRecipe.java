package com.rodionspringframework.recipeprojectspringbootmvc.converters;

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
public class RecipeDtoToRecipe implements Converter<RecipeDto, Recipe> {

    private final CategoryDtoToCategory categoryConveter;
    private final IngredientDtoToIngredient ingredientConverter;
    private final NotesDtoToNotes notesConverter;

    public RecipeDtoToRecipe(CategoryDtoToCategory categoryConveter, IngredientDtoToIngredient ingredientConverter,
                             NotesDtoToNotes notesConverter) {
        this.categoryConveter = categoryConveter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeDto source) {

        Recipe recipe = Recipe.builder()
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

        setCategories(source, recipe);
        setIngredients(source, recipe);

        return recipe;
    }

    public void setCategories(RecipeDto source, Recipe recipe){
        if (source.getCategories() != null && source.getCategories().size() > 0) {
            source.getCategories()
                    .forEach(category -> recipe.getCategories().add(categoryConveter.convert(category)));
        }

    }

    public void setIngredients(RecipeDto source, Recipe recipe){
        if (source.getCategories() != null && source.getCategories().size() > 0) {
            source.getCategories()
                    .forEach(category -> recipe.getCategories().add(categoryConveter.convert(category)));
        }

    }
}
