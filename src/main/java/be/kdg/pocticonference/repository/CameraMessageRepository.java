package be.kdg.pocticonference.repository;

import be.kdg.pocticonference.model.CameraMessage;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CameraMessageRepository extends ReactiveMongoRepository<CameraMessage, Integer> {

    Flux<CameraMessage> findAllByCameraId(int cameraId);
}
