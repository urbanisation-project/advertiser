package advertiser.model;

import advertiser.payload.AdSetPayload;
import advertiser.payload.CampaignPayload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Advertiser owner;
    private String name;
    @OneToMany
    private List<AdSet> adSets;
    private String objective;
    private Double budget;

    public CampaignPayload toPayload(){
        return new CampaignPayload(
                getId(),
                getOwner().toPayload(),
                getName(),
                getAdSets().stream().map(AdSet::toPayload).collect(Collectors.toList()),
                getObjective(),
                getBudget()
        );
    }
}
