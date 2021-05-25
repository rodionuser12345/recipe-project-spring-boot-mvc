package com.rodionspringframework.recipeprojectspringbootmvc.converters;

import com.rodionspringframework.recipeprojectspringbootmvc.domain.Ingredient;
import com.rodionspringframework.recipeprojectspringbootmvc.dto.IngredientDto;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class IngredientDtoToIngredient implements Converter<IngredientDto, Ingredient> {

    private final UnitOfMeasureDtoToUnitOfMeasure uomConverter;

    public IngredientDtoToIngredient(UnitOfMeasureDtoToUnitOfMeasure uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientDto source) {

        return Ingredient.builder()
                .id(source.getId())
                .amount(source.getAmount())
                .description(source.getDescription())
                .uom(uomConverter.convert(source.getUnitOfMeasureDto()))
                .build();
    }
}
