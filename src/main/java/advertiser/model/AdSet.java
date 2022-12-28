package advertiser.model;

import advertiser.payload.AdSetPayload;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Keyword> keywords;
    @ManyToOne(cascade = CascadeType.ALL)
    private Campaign campaign;

    public AdSetPayload toPayload() {
        return new AdSetPayload(
                getId(),
                getKeywords()
                        .stream()
                        .map(Keyword::toPayload)
                        .collect(Collectors.toList()),
                getCampaign().toPayload()
        );
    }
}
