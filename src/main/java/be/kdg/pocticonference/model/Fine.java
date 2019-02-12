package be.kdg.pocticonference.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fine {

    @Id
    private String id;
    private int fineAmount;
    private String licensePlate;
    private String date_time;
}
