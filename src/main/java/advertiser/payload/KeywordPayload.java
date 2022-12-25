package advertiser.payload;

import advertiser.model.Keyword;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KeywordPayload {
    private Long id;
    private String name;

    public Keyword toEntity(){
        return new Keyword(getId(), getName());
    }
}
