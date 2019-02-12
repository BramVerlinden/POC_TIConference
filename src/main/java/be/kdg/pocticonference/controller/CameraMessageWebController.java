package be.kdg.pocticonference.controller;

import be.kdg.pocticonference.model.CameraMessage;
import be.kdg.pocticonference.model.Fine;
import be.kdg.pocticonference.service.CameraMessageService;
import be.kdg.pocticonference.service.FineService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class CameraMessageWebController {

    CameraMessageService cameraMessageService;
    FineService fineService;

    public CameraMessageWebController(CameraMessageService cameraMessageService, FineService fineService) {
        this.cameraMessageService = cameraMessageService;
        this.fineService = fineService;
    }

    @GetMapping(value = "/web")
    public Mono<String> homePage() {
        return Mono.just("index");
    }

    @GetMapping(value = "/web/messages", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<CameraMessage> getAllMessages() {
        return cameraMessageService.getAllMessages();
    }

    @GetMapping(value = "/web/messages/{id}")
    public Mono<CameraMessage> getMessageById(String id) {
        return cameraMessageService.getMessageById(id);
    }

    @GetMapping(value = "/web/fines", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<Fine> getAllFines() {
        return fineService.getFines();
    }
}
