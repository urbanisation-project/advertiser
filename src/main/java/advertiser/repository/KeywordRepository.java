package advertiser.repository;

import advertiser.model.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword,Long> {
    List<Keyword> findKeywordsByName(String keyword);
}
