package advertiser.payload;

import advertiser.model.Campaign;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CampaignPayload {
    private Long id;
    private AdvertiserPayload owner;
    private String name;
    private String objective;
    private Double budget;

    public Campaign toEntity(){
        return new Campaign(
                getId(),
                getOwner().toEntity(),
                getName(),
                getObjective(),
                getBudget()
        );
    }
}
