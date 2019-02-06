package be.kdg.pocticonference.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "camera_message")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CameraMessage {

    @Id
    private int id;

    @JsonAlias("camera_id")
    private int cameraId;

    @JsonAlias("date_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdDate;

    @JsonAlias("license_plate")
    private String licensePlate;
}
