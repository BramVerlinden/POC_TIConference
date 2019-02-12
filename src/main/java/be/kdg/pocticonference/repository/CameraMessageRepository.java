package be.kdg.pocticonference.repository;

import be.kdg.pocticonference.model.CameraMessage;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CameraMessageRepository extends ReactiveCrudRepository<CameraMessage, String> {

}
