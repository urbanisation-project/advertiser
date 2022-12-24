package advertiser.model;

import advertiser.payload.AdPayload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //private Resource resource;
    private String resource;
    private Date startDate;
    private Date endDate;
    private String description;

    public AdPayload toPayload(){
        return new AdPayload(getId(), getName(), getResource(), getStartDate(), getEndDate(), getDescription());
    }
}
