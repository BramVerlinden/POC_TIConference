package be.kdg.pocticonference.controller;

import be.kdg.pocticonference.model.CameraMessage;
import be.kdg.pocticonference.service.CameraMessageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rest/messages")
public class CameraMessageController {

    private final CameraMessageService svc;

    public CameraMessageController(CameraMessageService svc) {
        this.svc = svc;
    }

    @GetMapping(produces = "text/event-stream")
    public Flux<CameraMessage> getAllMessages(){
        return svc.getAllMessages();
    }

    @GetMapping("/{id}")
    public Mono<CameraMessage> getMessageById(@PathVariable String id){
        return svc.getMessageById(id);
    }

    @PostMapping
    public Flux<CameraMessage> saveAllMessages(@RequestBody Flux<CameraMessage> messages){
        return svc.saveAll(messages);
    }
}
