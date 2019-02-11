package be.kdg.pocticonference.web.controllers;

import be.kdg.pocticonference.model.CameraMessage;
import be.kdg.pocticonference.model.Fine;
import be.kdg.pocticonference.repository.FineRepository;
import be.kdg.pocticonference.services.api.FineService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class CameraMessageWebController {

    CameraMessageController restController;
    @Autowired
    FineService fineService;

    public CameraMessageWebController(CameraMessageController restController) {
        this.restController = restController;
    }

    @GetMapping(value = "/cameramessage/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Mono<CameraMessage> getCameraMessage(@PathVariable ObjectId id) {
        return restController.cameraMessageMono(id);
    }

    @GetMapping(value = "/cameramessage")
    @ResponseBody
    public Flux<CameraMessage> getAllCameraMessages() {
        return restController.cameraMessageFlux();
    }

    @GetMapping("/fine")
    @ResponseBody
    public Flux<Fine> getAllFines(){
        Mono<Fine> fine = fineService.saveFine(new Fine("1", 100, "1-ABC-123", "2019-01-01T01:01:01"));
        return fineService.getAllFines();
    }

    @GetMapping("/")
    Mono<String> home() {
        return Mono.just("cameramessage.html");
    }
}
