package be.kdg.pocticonference.model;

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

    private int cameraId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdDate;

    private String licensePlate;
}
