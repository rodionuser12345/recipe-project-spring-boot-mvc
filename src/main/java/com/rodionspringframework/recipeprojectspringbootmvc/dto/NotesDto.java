package com.rodionspringframework.recipeprojectspringbootmvc.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class NotesDto {

    private Long id;
    private String recipeNotes;
}
