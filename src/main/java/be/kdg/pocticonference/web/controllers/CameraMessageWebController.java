package be.kdg.pocticonference.web.controllers;

import be.kdg.pocticonference.model.CameraMessage;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class CameraMessageWebController {

    CameraMessageController restController;

    public CameraMessageWebController(CameraMessageController restController) {
        this.restController = restController;
    }

    @GetMapping(value = "/cameramessage/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Mono<CameraMessage> getCameraMessage(@PathVariable int id) {
        return restController.cameraMessageMono(id);
    }

    @GetMapping(value = "/cameramessage")
    @ResponseBody
    public Flux<CameraMessage> getAllCameraMessages() {
        return restController.cameraMessageFlux();
    }

    @GetMapping("/")
    Mono<String> home() {
        return Mono.just("cameramessage.html");
    }
}
