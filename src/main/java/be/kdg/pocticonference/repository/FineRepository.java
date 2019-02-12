package be.kdg.pocticonference.repository;

import be.kdg.pocticonference.model.CameraMessage;
import be.kdg.pocticonference.model.Fine;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FineRepository extends ReactiveCrudRepository<Fine, String> {

}
