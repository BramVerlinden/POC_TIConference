package be.kdg.pocticonference;


import be.kdg.pocticonference.model.CameraMessage;
import be.kdg.pocticonference.repository.CameraMessageRepository;
import be.kdg.pocticonference.service.FineService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class PocticonferenceApplication {

    @Bean
    CommandLineRunner demoData(CameraMessageRepository repo, FineService fineService){
        String messageJson = null;
        try {
            messageJson = new String(Files.
                    readAllBytes(
                            Paths.get("/Users/dennis/Documents/KDG/2018-2019/TI Conference/POC_TIConference/src/main/resources/data.json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        CameraMessage[] messageArray = gson.fromJson(messageJson, CameraMessage[].class);
        List<CameraMessage> messages = Arrays.asList(messageArray);
        return args -> {
                    Flux.fromIterable(messages)
                    .flatMap(repo::save)
                    .thenMany(repo.findAll())
                    .subscribe(System.out::println);
            fineService.detect();
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(PocticonferenceApplication.class, args);
    }
}

