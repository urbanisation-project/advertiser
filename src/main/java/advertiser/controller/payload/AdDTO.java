package advertiser.controller.payload;

import advertiser.payload.AdSetPayload;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdDTO {
    private Long id;
    private String name;
    private String description;
    private AdSetPayload adSet;
    private Integer visitorsCount;

    public advertiser.model.Ad toEntity(){
        return new advertiser.model.Ad(
                getId(),
                getName(),
                null,
                getDescription(),
                getAdSet().toEntity(),
                getVisitorsCount());
    }
}
