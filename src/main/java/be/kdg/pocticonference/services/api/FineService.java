package be.kdg.pocticonference.services.api;

import be.kdg.pocticonference.model.Fine;
import reactor.core.publisher.Flux;

public interface FineService {
    Flux<Fine> getAllFines();
    void saveFine(Fine fine);
}
