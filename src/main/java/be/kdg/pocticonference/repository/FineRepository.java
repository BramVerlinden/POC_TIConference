package be.kdg.pocticonference.repository;

import be.kdg.pocticonference.model.Fine;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface FineRepository extends ReactiveMongoRepository<Fine, Integer> {

    Mono<Fine> findByLicensePlate(String licensePlate);

    Flux<Fine> findAllByLicensePlate(String licensePlate);
}
