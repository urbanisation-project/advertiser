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
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    private AdSet adSet;
    private int visitorsCount;

    public AdPayload toPayload(){
        return new AdPayload(getId(), getName(), getResource(), getDescription(), getAdSet().toPayload(),getVisitorsCount());
    }
}
