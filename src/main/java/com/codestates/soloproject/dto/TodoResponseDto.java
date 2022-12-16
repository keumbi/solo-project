package com.codestates.soloproject.dto;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponseDto {
    private Long id;

    private String title;

    private Long order;

    private Boolean completed;

    private String url;
}
