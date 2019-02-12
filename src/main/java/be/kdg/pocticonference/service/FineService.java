package be.kdg.pocticonference.service;

import be.kdg.pocticonference.model.Fine;
import be.kdg.pocticonference.repository.FineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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


    @Autowired
    private void detect() {
        List<Fine> fines = new ArrayList<>();
       cameraMessageService.getAllMessages().subscribe(
                m -> {saveFine(new Fine(String.valueOf(id),50, m.getLicensePlate(), LocalDateTime.now().toString()
                ));id++; });

        /*cameraMessageService.getAllMessages().subscribe( cameraMessage -> {
            fines.add(new Fine(Integer.parseInt(cameraMessage.getId()), 50, cameraMessage.getLicensePlate(), LocalDateTime.now().toString()));
        });

        fineRepository.deleteAll().thenMany(
                Flux.fromIterable(fines)
                .flatMap(fineRepository::save)
        );*/

    }

    public Flux<Fine> getFines() {
        Flux<Fine> fineFlux = fineRepository.findAll();
        return fineRepository.findAll();
    }


}
