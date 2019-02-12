package be.kdg.pocticonference.controller;

import be.kdg.pocticonference.model.CameraMessage;
import be.kdg.pocticonference.service.CameraMessageService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Controller
public class CameraMessageWebController {

    CameraMessageService svc;

    public CameraMessageWebController(CameraMessageService svc) {
        this.svc = svc;
    }

    @GetMapping(value = "/web/messages", produces = "text/event-stream")
    @ResponseBody
    public Flux<CameraMessage> getAllMessages() {
        return svc.getAllMessages();
    }

    @GetMapping(value = "/web/messages/{id}")
    public Mono<CameraMessage> getMessageById(String id) {
        return svc.getMessageById(id);
    }

    @GetMapping(value = "/web")
    public Mono<String> homePage() {
        return Mono.just("index");
    }
}
