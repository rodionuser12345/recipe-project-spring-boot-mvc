package com.rodionspringframework.recipeprojectspringbootmvc.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotesDto {

    private Long id;
    private String recipeNotes;
}
