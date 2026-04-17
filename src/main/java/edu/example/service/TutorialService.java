package edu.example.service;

import edu.example.dto.TutorialDto;

import java.util.List;
import java.util.Optional;

public interface TutorialService {

    TutorialDto addTutorial(TutorialDto tutorialdto);
    List<TutorialDto> getAllTutorials();
    Optional<TutorialDto> getTutorialById(Long id);
    TutorialDto updateTutorial(Long id, TutorialDto tutorialDto);
    String deleteTutorial(Long id);

}
