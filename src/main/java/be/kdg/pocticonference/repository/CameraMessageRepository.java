package be.kdg.pocticonference.repository;

import be.kdg.pocticonference.model.CameraMessage;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CameraMessageRepository extends ReactiveMongoRepository<CameraMessage, Integer> {
}
