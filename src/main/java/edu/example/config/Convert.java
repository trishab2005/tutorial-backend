package edu.example.config;

import edu.example.dto.TutorialDto;
import edu.example.entity.Tutorial;

public class Convert {
    public static Tutorial dtoToEntity (TutorialDto tutorialDto){
        return new Tutorial(tutorialDto.getId(),tutorialDto.getTitle(), tutorialDto.getDescription(), tutorialDto.getPublished());
    }
    public static TutorialDto EntityToDto (Tutorial tutorial){
        return new TutorialDto(tutorial.getId(), tutorial.getTitle(), tutorial.getDescription(), tutorial.getPublished());
    }
}
