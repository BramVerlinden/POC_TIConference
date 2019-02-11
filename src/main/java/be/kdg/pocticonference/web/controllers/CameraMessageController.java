package be.kdg.pocticonference.web.controllers;

import be.kdg.pocticonference.model.CameraMessage;
import be.kdg.pocticonference.services.api.CameraMessageService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//controller
@Controller
public class CameraMessageController {

    private final CameraMessageService cameraMessageService;

    public CameraMessageController(CameraMessageService cameraMessageService) {
        this.cameraMessageService = cameraMessageService;
    }


    @GetMapping("/CameraMessage/{id}")
    public Mono<CameraMessage> cameraMessageMono(@PathVariable ObjectId id){
        return cameraMessageService.findCameraMessageById(id);
    }


    @GetMapping("/CameraMessages")
    public Flux<CameraMessage> cameraMessageFlux(){
        return cameraMessageService.findAll();
    }




}
