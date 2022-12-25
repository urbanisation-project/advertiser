package advertiser.repository;

import advertiser.model.AdSet;
import advertiser.model.Campaign;
import advertiser.model.Keyword;
import advertiser.payload.KeywordPayload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdSetRepository extends JpaRepository<AdSet, Long> {
    List<AdSet> findAdSetsByCampaign(Campaign campaign);

    List<AdSet> findAdSetsByKeywordsContains(Keyword keyword);
}
