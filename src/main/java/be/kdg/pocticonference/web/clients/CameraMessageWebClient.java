package be.kdg.pocticonference.web.clients;

import be.kdg.pocticonference.model.CameraMessage;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class CameraMessageWebClient {
    private WebClient client = WebClient.create("http://localhost:7890");

    public Mono<CameraMessage> getCameraMessage(int id) {
        return client.get()
                .uri("/CameraMessage/{id}", id).accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(CameraMessage.class);
    }

    public Flux<CameraMessage> getAllCameraMessages() {
        return client.get()
                .uri("/CameraMessages").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(CameraMessage.class);
    }
}
