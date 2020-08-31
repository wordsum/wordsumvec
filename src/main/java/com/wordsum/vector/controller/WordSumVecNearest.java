package com.wordsum.vector.controller;

import com.wordsum.vector.model.WordSumVecNearestReponse;
import com.wordsum.vector.service.WordSumVecCacheService;
import com.wordsum.vector.utils.WordSumVecNearestProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
public class WordSumVecNearest {

    @RequestMapping(value = "/rest/v1/wordsum/vector/nearest", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<WordSumVecNearestReponse> get(@RequestParam("cacheId") UUID cacheId,
                                                        @RequestParam("word") String word,
                                                        @RequestParam("count") Integer count) throws Exception {
        if (WordSumVecCacheService.getCache().get(cacheId) != null) {
            return new ResponseEntity<>(WordSumVecNearestProcessor.get(word, count, cacheId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
