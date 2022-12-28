package advertiser.model;

import advertiser.payload.AdPayload;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(optional = true,cascade = CascadeType.ALL)
    private Image resource;
    private Date startDate;
    private Date endDate;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    private AdSet adSet;
    private Integer visitorsCount;

    public AdPayload toPayload(){
        return new AdPayload(getId(), getName(), getResource(), getStartDate(), getEndDate(), getDescription(), getAdSet().toPayload(),getVisitorsCount());
    }
}
