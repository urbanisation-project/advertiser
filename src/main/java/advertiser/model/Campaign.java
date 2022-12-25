package advertiser.model;

import advertiser.payload.CampaignPayload;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Advertiser owner;
    private String name;
    private String objective;
    private Double budget;

    public CampaignPayload toPayload(){
        return new CampaignPayload(
                getId(),
                getOwner().toPayload(),
                getName(),
                getObjective(),
                getBudget()
        );
    }
}
