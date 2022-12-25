package advertiser.service.impl;

import advertiser.model.Keyword;
import advertiser.payload.KeywordPayload;
import advertiser.repository.KeywordRepository;
import advertiser.service.KeywordService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KeywordServiceImpl implements KeywordService {
    private final KeywordRepository keywordRepository;

    public KeywordServiceImpl(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    @Override
    public KeywordPayload save(KeywordPayload keyword) {
        return keywordRepository.save(keyword.toEntity()).toPayload();
    }

    @Override
    public KeywordPayload findById(Long keywordId) {
        return keywordRepository.findById(keywordId).get().toPayload();
    }

    @Override
    public List<KeywordPayload> findAll() {
        return keywordRepository.findAll().stream().map(Keyword::toPayload).collect(Collectors.toList());
    }

    @Override
    public KeywordPayload update(KeywordPayload keyword) {
        return keywordRepository.save(keyword.toEntity()).toPayload();
    }

    @Override
    public boolean deleteById(Long keywordId) {
        try {
            keywordRepository.deleteById(keywordId);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public List<KeywordPayload> findKeywordsByNames(List<String> names) {
        List<KeywordPayload> keywords = new ArrayList<>();
        for(String name:names){
            keywords.addAll(
                    keywordRepository.findKeywordsByName(name)
                            .stream()
                            .map(Keyword::toPayload)
                            .collect(Collectors.toList())
            );
        }
        return keywords;
    }
}
