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


    private ObjectId _id;
    private int camera_id;
    @Id
    private int id;

    private String date_time;

    @JsonAlias("license_plate")
    private String licensePlate;
}
