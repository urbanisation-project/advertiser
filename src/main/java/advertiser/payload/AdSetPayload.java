package advertiser.payload;

import advertiser.model.AdSet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdSetPayload {
    private Long id;
    private List<CategoryPayload> categories;
    private List<AdPayload> ads;

    public AdSet toEntity() {
        return new AdSet(
                getId(),
                getCategories()
                        .stream()
                        .map(CategoryPayload::toEntity)
                        .collect(Collectors.toList()),
                getAds()
                        .stream()
                        .map(AdPayload::toEntity)
                        .collect(Collectors.toList())
        );
    }
}
