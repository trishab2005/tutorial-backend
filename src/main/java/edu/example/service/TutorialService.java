package edu.example.service;

import edu.example.entity.Tutorial;

import java.util.List;
import java.util.Optional;

public interface TutorialService {

    Tutorial addTutorial(Tutorial tutorial);
    List<Tutorial> getAllTutorials();
    Optional<Tutorial> getTutorialById(Long id);
    Tutorial updateTutorial(Long id, Tutorial tutorial);
    String deleteTutorial(Long id);

}
