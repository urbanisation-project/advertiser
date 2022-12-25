package advertiser.repository;

import advertiser.model.Ad;
import advertiser.model.AdSet;
import advertiser.payload.AdSetPayload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends JpaRepository<Ad,Long> {
    List<Ad> findAdsByAdSet(AdSet adSet);

}
