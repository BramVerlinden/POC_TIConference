package be.kdg.pocticonference.repository;

import be.kdg.pocticonference.model.Fine;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FineRepository extends ReactiveMongoRepository<Fine, Integer> {
}
