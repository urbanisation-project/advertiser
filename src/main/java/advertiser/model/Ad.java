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
    //private Resource resource;
    @OneToOne(cascade = CascadeType.ALL)
    private AdImage resource;
    private Date startDate;
    private Date endDate;
    private String description;
    @ManyToOne
    private AdSet adSet;
    private Integer visitorsCount;

    public AdPayload toPayload(){
        return new AdPayload(getId(), getName(), getResource().toPayload(), getStartDate(), getEndDate(), getDescription(), getAdSet().toPayload(),getVisitorsCount());
    }
}
