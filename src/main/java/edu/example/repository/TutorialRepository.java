package edu.example.repository;

import edu.example.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial,Long> {
}
