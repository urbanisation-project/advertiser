package advertiser.payload;

import advertiser.model.AdSet;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdSetPayload {
    private Long id;
    private List<KeywordPayload> keywords;
    private CampaignPayload campaign;

    public AdSet toEntity() {
        return new AdSet(
                getId(),
                getKeywords()
                        .stream()
                        .map(KeywordPayload::toEntity)
                        .collect(Collectors.toList()),
                getCampaign().toEntity()
        );
    }
}
