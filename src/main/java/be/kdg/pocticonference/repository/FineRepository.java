package be.kdg.pocticonference.repository;

import be.kdg.pocticonference.model.Fine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public interface FineRepository extends ReactiveMongoRepository<Fine, String> {

    //Mono<Fine> findByLicensePlate(String licensePlate);

    Flux<Fine> findAllByLicensePlate(String licensePlate);
}
