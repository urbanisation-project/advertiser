package advertiser.model;

import advertiser.payload.AdPayload;
import advertiser.payload.AdSetPayload;
import advertiser.payload.CategoryPayload;
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
public class AdSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Category> categories;
    @OneToMany
    private List<Ad> ads;

    public AdSetPayload toPayload() {
        return new AdSetPayload(
                getId(),
                getCategories()
                        .stream()
                        .map(Category::toPayload)
                        .collect(Collectors.toList()),
                getAds()
                        .stream()
                        .map(Ad::toPayload)
                        .collect(Collectors.toList())
        );
    }
}
