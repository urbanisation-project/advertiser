package advertiser.payload;

import advertiser.model.Ad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
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

    public Ad toEntity(){
        return new Ad(getId(), getName(), getResource(), getStartDate(), getEndDate(), getDescription());
    }
}
