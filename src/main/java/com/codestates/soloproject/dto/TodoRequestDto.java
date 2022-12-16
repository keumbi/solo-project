package com.codestates.soloproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoRequestDto {
    private String title;

    private Long order;

    private Boolean completed;
}
