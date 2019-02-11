package be.kdg.pocticonference.services.api;

import be.kdg.pocticonference.model.CameraMessage;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CameraMessageService {
    Mono<CameraMessage> findCameraMessageById(ObjectId id);
    Flux<CameraMessage> findAll();


}
