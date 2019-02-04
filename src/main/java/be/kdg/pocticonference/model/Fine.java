package be.kdg.pocticonference.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "fine")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Fine {

    @Id
    private int id;
    private int fineAmount;
    private String licensePlate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdDate;
}
