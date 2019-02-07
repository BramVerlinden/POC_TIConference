package be.kdg.pocticonference.services.impl;

import be.kdg.pocticonference.model.CameraMessage;
import be.kdg.pocticonference.repository.CameraMessageRepository;
import be.kdg.pocticonference.services.api.CameraMessageService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("CameraMessageService")
public class CameraMessageServiceImpl implements CameraMessageService {
    private final CameraMessageRepository cameraMessageRepository;

   public CameraMessageServiceImpl(CameraMessageRepository cameraMessageRepository){
       this.cameraMessageRepository = cameraMessageRepository;
   }

    @Override
    public Mono<CameraMessage> findCameraMessageById(int id) {
        return cameraMessageRepository.findById(id);
    }

    @Override
    public Flux<CameraMessage> findAll() {
        return cameraMessageRepository.findAll();
    }
}
