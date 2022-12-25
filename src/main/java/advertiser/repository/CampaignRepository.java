package advertiser.repository;

import advertiser.model.Advertiser;
import advertiser.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    List<Campaign> findCampaignsByOwner(Advertiser advertiser);
}
