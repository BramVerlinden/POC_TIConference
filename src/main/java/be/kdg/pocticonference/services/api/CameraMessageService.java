package be.kdg.pocticonference.services.api;

import be.kdg.pocticonference.model.CameraMessage;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CameraMessageService {
    Mono<CameraMessage> findCameraMessageById(int id);
    Flux<CameraMessage> findAll();


}
