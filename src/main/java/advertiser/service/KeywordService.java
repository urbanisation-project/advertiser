package advertiser.service;

import advertiser.payload.KeywordPayload;

import java.util.List;

public interface KeywordService {
    KeywordPayload save(KeywordPayload keyword);
    KeywordPayload findById(Long keywordId);
    List<KeywordPayload> findAll();
    KeywordPayload update(KeywordPayload keyword);
    boolean deleteById(Long keywordId);
    List<KeywordPayload> findKeywordsByNames(List<String> names);
}
