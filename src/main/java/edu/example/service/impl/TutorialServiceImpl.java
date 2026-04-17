package edu.example.service.impl;

import edu.example.config.Convert;
import edu.example.dto.TutorialDto;
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
    public TutorialDto addTutorial(TutorialDto tutorial) {
        Tutorial toBeSaved= Convert.dtoToEntity(tutorial);
        Tutorial saved= tutorialRepository.save(toBeSaved);
        return Convert.EntityToDto(saved);
    }

    @Override
    public List<TutorialDto> getAllTutorials() {
        return tutorialRepository.findAll().stream().map(Convert::EntityToDto).toList(); // THIS MAP IS COMING FROM STREAM
    }

    @Override
    public Optional<TutorialDto> getTutorialById(Long id) {
        return tutorialRepository.findById(id).map(Convert::EntityToDto); // THIS MAP IS COMING FROM OPTIONAL
    }

    @Override
    public TutorialDto updateTutorial(Long id, TutorialDto tutorialDto) {
        Tutorial existing = tutorialRepository.findById(id)
                .orElseThrow(() -> new TutorialNotFoundException("Tutorial not found with id: " + id));

        existing.setTitle(tutorialDto.getTitle());
        existing.setDescription(tutorialDto.getDescription());
        existing.setPublished(tutorialDto.getPublished());
        Tutorial updated = tutorialRepository.save(existing);
        return Convert.EntityToDto(updated);
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