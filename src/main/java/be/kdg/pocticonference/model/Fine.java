package be.kdg.pocticonference.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
@AllArgsConstructor
public class Fine {

    @Id
    private String id;
    private Integer fineAmount;
    private String licensePlate;
    private String date_time;

    public Fine() {
    }

    public Fine(int fineAmount, String licensePlate, String date_time) {
        this.fineAmount = fineAmount;
        this.licensePlate = licensePlate;
        this.date_time = date_time;
    }
}
