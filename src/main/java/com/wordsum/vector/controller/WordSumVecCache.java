package com.wordsum.vector.controller;

import com.wordsum.vector.model.WordSumVecCacheItem;
import com.wordsum.vector.model.WordSumVecCacheRequest;
import com.wordsum.vector.model.WordSumVecCacheResponse;
import com.wordsum.vector.service.WordSumVecCacheService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class WordSumVecCache {

    @RequestMapping(value = "/rest/v1/wordsum/vector/cache", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<WordSumVecCacheResponse> post(@RequestBody WordSumVecCacheRequest wordSumVecCacheRequest) throws Exception {
        WordSumVecCacheItem wordSumVecCacheItem = WordSumVecCacheService.getCache().put(wordSumVecCacheRequest.words);
        return new ResponseEntity<>(new WordSumVecCacheResponse(HttpStatus.CREATED,
                new WordSumVecCacheItem(
                        wordSumVecCacheItem.getId(),
                        wordSumVecCacheItem.getWords(),
                        null
                )
        ), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/rest/v1/wordsum/vector/cache/{cacheId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<WordSumVecCacheResponse> get(@PathVariable("cacheId") UUID cacheId) throws Exception {
        if (WordSumVecCacheService.getCache().get(cacheId) != null) {
            WordSumVecCacheItem wordSumVecCacheItem = WordSumVecCacheService.getCache().get(cacheId);
            return new ResponseEntity<>(new WordSumVecCacheResponse(HttpStatus.OK,
                    new WordSumVecCacheItem(
                            wordSumVecCacheItem.getId(),
                            wordSumVecCacheItem.getWords(),
                            null
                    )
            ), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new WordSumVecCacheResponse(HttpStatus.NOT_FOUND, null), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/rest/v1/wordsum/vector/cache", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<WordSumVecCacheResponse> get() {
        WordSumVecCacheService.delete();
        return new ResponseEntity<>(new WordSumVecCacheResponse(HttpStatus.OK, null), HttpStatus.OK);
    }
}
