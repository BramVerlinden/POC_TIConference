package be.kdg.pocticonference.services.impl;

import be.kdg.pocticonference.model.Fine;
import be.kdg.pocticonference.repository.FineRepository;
import be.kdg.pocticonference.services.api.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service("FineService")
public class FineServiceImpl implements FineService {

    @Autowired
    private FineRepository fineRepository;

    public Flux<Fine> getAllFines(){
        return fineRepository.findAll();
    }

    public Mono<Fine> saveFine(Fine fine){

        return fineRepository.insert(fine);
    }
}
