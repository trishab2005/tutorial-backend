package edu.example.service.impl;

import edu.example.entity.Tutorial;
import edu.example.exception.TutorialNotFoundException;
import edu.example.repository.TutorialRepository; // Import your repository
import edu.example.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialServiceImpl implements TutorialService {

    private final TutorialRepository tutorialRepository;

    @Autowired
    public TutorialServiceImpl(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    @Override
    public Tutorial addTutorial(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    @Override
    public List<Tutorial> getAllTutorials() {
        return tutorialRepository.findAll().stream().filter(t->t.getTitle()!=null).toList();
    }

    @Override
    public Optional<Tutorial> getTutorialById(Long id) {
        return tutorialRepository.findById(id);
    }

    @Override
    public Tutorial updateTutorial(Long id, Tutorial tutorial) {
        Tutorial existing = tutorialRepository.findById(id)
                .orElseThrow(() -> new TutorialNotFoundException("Tutorial not found with id: " + id));

        existing.setTitle(tutorial.getTitle());
        existing.setDescription(tutorial.getDescription());
        existing.setPublished(tutorial.getPublished());

        return tutorialRepository.save(existing);
    }

    @Override
    public String deleteTutorial(Long id) {
        if (!tutorialRepository.existsById(id)) {
            throw new TutorialNotFoundException("Cant delete tutorial with id " + id);
        }
        tutorialRepository.deleteById(id);
        return "Tutorial with id " + id + " deleted successfully";
    }
}