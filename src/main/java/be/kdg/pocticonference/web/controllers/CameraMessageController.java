package be.kdg.pocticonference.web.controllers;

import be.kdg.pocticonference.model.CameraMessage;
import be.kdg.pocticonference.services.api.CameraMessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Controller
public class CameraMessageController {

    private final CameraMessageService cameraMessageService;

    public CameraMessageController(CameraMessageService cameraMessageService) {
        this.cameraMessageService = cameraMessageService;
    }


    @GetMapping("/CameraMessage/{id}")
    public Mono<CameraMessage> cameraMessageMono(@PathVariable Integer id){
        return cameraMessageService.findCameraMessageById(id);
    }


    @GetMapping("/CameraMessages")
    public Flux<CameraMessage> cameraMessageFlux(){
        return cameraMessageService.findAll();
    }




}
