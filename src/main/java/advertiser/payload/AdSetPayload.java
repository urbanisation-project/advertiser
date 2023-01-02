package advertiser.payload;

import advertiser.model.AdSet;
import advertiser.model.Keyword;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdSetPayload {
    private Long id;
    private String name;
    private List<KeywordPayload> keywords;
    private CampaignPayload campaign;

    public AdSet toEntity() {

        List<String> keywordNames = getKeywords()
                .stream()
                .map(KeywordPayload::getName)
                .collect(Collectors.toList());
        List<Keyword> keywordsList=new ArrayList<>();
        for(String keyword:keywordNames){
            List<String> keywords = Arrays.stream(keyword.split(" ")).collect(Collectors.toList());
            keywordsList.addAll(keywords.stream().map(s -> {
                return new Keyword(-1L, s);
            }).collect(Collectors.toList()));
        }
        return new AdSet(
                getId(),
                getName(),
                keywordsList,
                getCampaign().toEntity()
        );
    }
}
