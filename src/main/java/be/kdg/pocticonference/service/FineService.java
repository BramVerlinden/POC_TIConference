package be.kdg.pocticonference.service;

import be.kdg.pocticonference.model.CameraMessage;
import be.kdg.pocticonference.model.Fine;
import be.kdg.pocticonference.repository.FineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Service
public class FineService {
    private CameraMessageService cameraMessageService;
    private FineRepository fineRepository;
    private int id=2;
    private String licenseplate = "5-ABC-123";

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


    @Autowired
    private void detect() {

        cameraMessageService.getAllMessages().subscribe( cameraMessage -> {
            Fine fine = new Fine(cameraMessage.getId(), 50, cameraMessage.getLicensePlate(), LocalDateTime.now().toString());
            WebClient.RequestHeadersSpec<?> request = WebClient
                    .create()
                    .post()
                    .uri("http://localhost:8080/rest/fines/fine")
                    .body(BodyInserters.fromObject(fine))
                    .header("Content-Type", "application/json");
            request.exchange();
        });
    }

    public Flux<Fine> getFines() {
        Flux<Fine> fineFlux = fineRepository.findAll();
        return fineRepository.findAll();
    }

    public Flux<Fine> saveAll(Flux<Fine> fines){
        return fineRepository.saveAll(fines);
    }


}
