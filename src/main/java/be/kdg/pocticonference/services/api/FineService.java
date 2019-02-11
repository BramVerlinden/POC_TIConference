package be.kdg.pocticonference.services.api;

import be.kdg.pocticonference.model.Fine;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface FineService {
    Flux<Fine> getAllFines();
    Mono<Fine> saveFine(Fine fine);
}
