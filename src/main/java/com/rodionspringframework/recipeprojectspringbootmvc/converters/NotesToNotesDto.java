package com.rodionspringframework.recipeprojectspringbootmvc.converters;

import com.rodionspringframework.recipeprojectspringbootmvc.domain.Notes;
import com.rodionspringframework.recipeprojectspringbootmvc.dto.NotesDto;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class NotesToNotesDto implements Converter<Notes, NotesDto>{

    @Synchronized
    @Nullable
    @Override
    public NotesDto convert(Notes source) {
        return NotesDto.builder().id(source.getId()).recipeNotes(source.getRecipeNotes()).build();
    }
}
