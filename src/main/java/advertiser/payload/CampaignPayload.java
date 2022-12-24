package advertiser.payload;

import advertiser.model.Campaign;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampaignPayload {
    private Long id;
    private AdvertiserPayload owner;
    private String name;
    private List<AdSetPayload> adSets;
    private String objective;
    private Double budget;

    public Campaign toEntity(){
        return new Campaign(
                getId(),
                getOwner().toEntity(),
                getName(),
                getAdSets().stream().map(AdSetPayload::toEntity).collect(Collectors.toList()),
                getObjective(),
                getBudget()
        );
    }
}
