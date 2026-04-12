package edu.example.controller;

import edu.example.entity.Tutorial;
import edu.example.service.TutorialService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutorials")
@AllArgsConstructor
public class TutorialController {

    private final TutorialService tutorialService;

    @PostMapping
    // http://localhost:8888/api/tutorials
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
        Tutorial createdTutorial = tutorialService.addTutorial(tutorial);
        return new ResponseEntity<>(createdTutorial, HttpStatus.CREATED);
    }

    @GetMapping
    // http://localhost:8888/api/tutorials
    public ResponseEntity<List<Tutorial>> getAllTutorials() {
        List<Tutorial> tutorials = tutorialService.getAllTutorials();
        return new ResponseEntity<>(tutorials, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    // http://localhost:8888/api/tutorials/1
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable Long id) {
        return tutorialService.getTutorialById(id)
                .map(tutorial -> new ResponseEntity<>(tutorial, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    // http://localhost:8888/api/tutorials/1
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable Long id, @RequestBody Tutorial tutorial) {
        Tutorial updatedTutorial = tutorialService.updateTutorial(id, tutorial);
        return new ResponseEntity<>(updatedTutorial, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    // http://localhost:8888/api/tutorials/1
    public ResponseEntity<String> deleteTutorial(@PathVariable Long id) {
        String message = tutorialService.deleteTutorial(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}