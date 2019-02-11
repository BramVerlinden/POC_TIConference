package be.kdg.pocticonference.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CameraMessage")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CameraMessage {


    @Id
    private ObjectId _id;
    private int messageId;
    private int cameraId;
    private String timestamp;
    private String licensePlate;
}
