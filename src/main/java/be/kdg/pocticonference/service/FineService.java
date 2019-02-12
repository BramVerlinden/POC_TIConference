package be.kdg.pocticonference.service;

import be.kdg.pocticonference.model.CameraMessage;
import be.kdg.pocticonference.model.Fine;
import be.kdg.pocticonference.repository.FineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Service
public class FineService {
    private CameraMessageService cameraMessageService;
    private FineRepository fineRepository;
    private int id=2;
    private final String LICENSEPLATE = "1-YSG-123";

    @Autowired
    private ReactiveMongoTemplate template;

    public FineService(CameraMessageService cameraMessageService, FineRepository fineRepository) {
        this.cameraMessageService = cameraMessageService;
        this.fineRepository = fineRepository;
    }

    public void saveFine(Fine fine) {
        Mono<Fine> fineMono = Mono.just(fine);
        fineRepository.save(fine);
    }

    public Flux<Fine> saveMonoFine(Mono<Fine> fine){
        return fineRepository.saveAll(fine);
    }


    @Scheduled(fixedDelay = 1000)
    public void detect() {
        Flux<CameraMessage> messagesFlux = cameraMessageService.getAllMessages();
       messagesFlux.subscribe(cameraMessage -> {
           if(cameraMessage.getLicensePlate().equals(LICENSEPLATE)){
               Fine fine = new Fine(cameraMessage.getId(), 50, cameraMessage.getLicensePlate(), LocalDateTime.now().toString());
               fineRepository.save(fine).subscribe();
           }
       });
    }

    public Flux<Fine> getFines() {
        return fineRepository.findWithTailableCursorBy();
    }

    public Flux<Fine> saveAll(Flux<Fine> fines){
        return fineRepository.saveAll(fines);
    }


}
