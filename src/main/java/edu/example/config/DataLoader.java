package edu.example.config;

import com.github.javafaker.Faker;
import edu.example.entity.Tutorial;
import edu.example.repository.TutorialRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor

public class DataLoader implements CommandLineRunner {
    private final TutorialRepository tutorialRepository;

    // USING FAKER API TO FETCH DUMMY DATA
//    @Override
//    public void run(String... args) throws Exception {
//        Faker faker =new Faker();
//        for (int i=0;i<20;i++){
//            Tutorial t =new Tutorial(faker.book().title(),
//                    faker.lorem().sentence(),
//                    faker.bool().bool());
//            tutorialRepository.save(t);
//        }
//    }

    @Override
    public void run(String... args)throws Exception{
        tutorialRepository.saveAll(
                List.of(
                        Tutorial.builder().title("java").description("core java").published(false).build(),
                        Tutorial.builder().title("python").description("python basics").published(true).build(),
                        Tutorial.builder().title("sql").description("sql advanced").published(false).build(),
                        Tutorial.builder().title("html").description("core html").published(false).build(),
                        Tutorial.builder().title("springboot").description("advanced backened").published(true).build()

                )
        );
    }
}
