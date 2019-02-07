package be.kdg.pocticonference.web.clients;

import be.kdg.pocticonference.model.CameraMessage;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class CameraMessageWebClient {
    private WebClient client = WebClient.create("http://localhost:7890");

    private Mono<CameraMessage> cameraMessageMono = client.get()
            .uri("/CameraMessage/{id}", "1")
            .retrieve()
            .bodyToMono(CameraMessage.class);

    public 
}
