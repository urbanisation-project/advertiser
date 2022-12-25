package advertiser.payload;

import advertiser.model.Ad;
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
    private String resource;
    private Date startDate;
    private Date endDate;
    private String description;
    private AdSetPayload adSet;

    public Ad toEntity(){
        return new Ad(getId(), getName(), getResource(), getStartDate(), getEndDate(), getDescription(), getAdSet().toEntity());
    }
}
