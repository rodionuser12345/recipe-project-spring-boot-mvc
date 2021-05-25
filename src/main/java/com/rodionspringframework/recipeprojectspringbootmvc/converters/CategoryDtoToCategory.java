package com.rodionspringframework.recipeprojectspringbootmvc.converters;


import com.rodionspringframework.recipeprojectspringbootmvc.domain.Category;
import com.rodionspringframework.recipeprojectspringbootmvc.dto.CategoryDto;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class CategoryDtoToCategory implements Converter<CategoryDto, Category>{

    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryDto source) {
        return Category.builder().id(source.getId()).description(source.getDescription()).build();
    }
}
