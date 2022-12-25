package advertiser.controller;

import advertiser.payload.KeywordPayload;
import advertiser.service.KeywordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/keywords")
public class KeywordController {
    private final KeywordService keywordService;

    public KeywordController(KeywordService keywordService) {
        this.keywordService = keywordService;
    }
    @PostMapping("/save")
    public KeywordPayload save(@RequestBody KeywordPayload keyword){
        return keywordService.save(keyword);
    }
    @GetMapping("/{keywordId}")
    public KeywordPayload getById(@PathVariable Long keywordId){
        return keywordService.findById(keywordId);
    }
    @GetMapping("/")
    public List<KeywordPayload> getAll(){
        return keywordService.findAll();
    }
    @GetMapping("/{keywordId}/delete")
    public Boolean deleteById(@PathVariable Long keywordId){
        return keywordService.deleteById(keywordId);
    }
    @PutMapping("/update")
    public KeywordPayload update(@RequestBody KeywordPayload keyword){
        return keywordService.update(keyword);
    }
    @PostMapping("/keywords")
    public List<KeywordPayload> getKeywordsByNames(@RequestBody List<String> names){
        return keywordService.findKeywordsByNames(names);
    }
}
