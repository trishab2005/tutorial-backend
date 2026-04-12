package edu.example.config;

import com.github.javafaker.Faker;
import edu.example.entity.Tutorial;
import edu.example.repository.TutorialRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor

public class DataLoader implements CommandLineRunner {
    private final TutorialRepository tutorialRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker =new Faker();
        for (int i=0;i<20;i++){
            Tutorial t =new Tutorial(faker.book().title(),
                    faker.lorem().sentence(),
                    faker.bool().bool());
            tutorialRepository.save(t);
        }
    }
}
