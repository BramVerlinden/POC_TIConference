package be.kdg.pocticonference.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "Fine")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Fine {

    @Id
    private ObjectId _id;
    private int fineAmount;
    private String licensePlate;
    private String date_time;
}
