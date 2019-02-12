package be.kdg.pocticonference.repository;

import be.kdg.pocticonference.model.Fine;

import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface FineRepository extends ReactiveCrudRepository<Fine, String> {

    @Tailable
    Flux<Fine> findWithTailableCursorBy();
}
