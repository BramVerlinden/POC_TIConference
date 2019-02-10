package be.kdg.pocticonference.web.clients;

import be.kdg.pocticonference.model.CameraMessage;
import org.springframework.web.reactive.function.client.WebClient;

public class CameraMessageWebClient {
    private WebClient client = WebClient.create("http://localhost:7890");
}
