package be.kdg.pocticonference.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class CameraMessage {


    @Id
    private String id;
    @NonNull
    private int cameraId;
    @NonNull
    private String timestamp;
    @NonNull
    private String licensePlate;
}
