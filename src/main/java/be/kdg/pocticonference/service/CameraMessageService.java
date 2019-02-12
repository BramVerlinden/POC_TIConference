package be.kdg.pocticonference.service;

import be.kdg.pocticonference.model.CameraMessage;
import be.kdg.pocticonference.repository.CameraMessageRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class CameraMessageService {
    private final CameraMessageRepository repo;

    public CameraMessageService(CameraMessageRepository repo) {
        this.repo = repo;
    }

    public Flux<CameraMessage> getAllMessages(){
        return repo.findAll();

    }

    public Mono<CameraMessage> getMessageById(String id){
        return repo.findById(id);
    }

    public Flux<CameraMessage> saveAll(Flux<CameraMessage> messages){
        return repo.saveAll(messages);
    }
}
