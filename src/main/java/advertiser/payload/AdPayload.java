package advertiser.payload;

import advertiser.model.Ad;
import advertiser.model.Image;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdPayload {
    private Long id;
    private String name;
    //private Resource resource;
    private Image resource;
    private String description;
    private AdSetPayload adSet;
    private int visitorsCount;

    public Ad toEntity(){
        return new Ad(
                getId(),
                getName(),
                getResource(),
                getDescription(),
                getAdSet().toEntity(),
                getVisitorsCount());
    }
}
