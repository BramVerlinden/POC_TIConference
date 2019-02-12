package be.kdg.pocticonference;

import be.kdg.pocticonference.model.CameraMessage;
import be.kdg.pocticonference.repository.CameraMessageRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReactiveMongoTest {

    @Autowired
    private CameraMessageRepository repository;

    @Test
    public void givenCamera_whenFindByAllByCamera() {
        //Flux<CameraMessage> messageFlux = repository.findAllByCameraId(1);

        /*StepVerifier
                .create(messageFlux)
                .assertNext(
                        cameraMessage -> {
                            assertEquals(1, cameraMessage.getCameraId());
                            assertNotNull(cameraMessage.getLicensePlate());
                            assertNotNull(cameraMessage.getId());
                            assertNotNull(cameraMessage.getCreatedDate());
                        }
                );
        */
    }
}
