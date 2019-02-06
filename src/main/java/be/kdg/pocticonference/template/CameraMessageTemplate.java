package be.kdg.pocticonference.template;

import be.kdg.pocticonference.model.CameraMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.ReactiveRemoveOperation;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CameraMessageTemplate {

    @Autowired
    ReactiveMongoTemplate template;

    public Mono<CameraMessage> findById(int id){
        return template.findById(id, CameraMessage.class);
    }

    public Flux<CameraMessage> findAll(){
        return template.findAll(CameraMessage.class);
    }

    public Mono<CameraMessage> save(Mono<CameraMessage> message){
        return template.save(message);
    }

    public ReactiveRemoveOperation.ReactiveRemove<CameraMessage> deleteAll(){
        return template.remove(CameraMessage.class);
    }
}
