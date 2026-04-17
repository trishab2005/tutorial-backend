package edu.example.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class TutorialDto {
    private Long id;
    private String title;
    private String description;
    private Boolean published;

    public TutorialDto(String title, String description, Boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }
}
