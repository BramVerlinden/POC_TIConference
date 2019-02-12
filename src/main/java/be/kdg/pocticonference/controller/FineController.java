package be.kdg.pocticonference.controller;

import be.kdg.pocticonference.model.CameraMessage;
import be.kdg.pocticonference.model.Fine;
import be.kdg.pocticonference.service.FineService;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rest/fines")
public class FineController {
    private final FineService fineService;

    public FineController(FineService fineService) {
        this.fineService = fineService;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Fine> getAllFines(){
        return fineService.getFines();
    }

    @PostMapping
    public Flux<Fine> saveAllMessages(@RequestBody Flux<Fine> fines){
        return fineService.saveAll(fines);
    }

    @PostMapping("/fine")
    public Flux<Fine> saveFine(@RequestBody Mono<Fine> fine){
        return fineService.saveMonoFine(fine);
    }
}
