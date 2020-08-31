package com.wordsum.vector.service;

import com.wordsum.vector.model.WordSumVecCacheItem;
import com.wordsum.vector.utils.WordSumVecCacheProcessor;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.UUID;

public class WordSumVecCacheService {

    private final HashMap<UUID, WordSumVecCacheItem> store;

    private WordSumVecCacheService() {
        store = new HashMap<UUID, WordSumVecCacheItem>();
    }

    private static class WordSumVecCache {
        public static WordSumVecCacheService service = new WordSumVecCacheService();
    }

    public static WordSumVecCacheService getCache() {
        return WordSumVecCache.service;
    }

    public static void delete() {
        WordSumVecCache.service = new WordSumVecCacheService();
    }

    public WordSumVecCacheItem put(String words) throws Exception {
        WordSumVecCacheItem wordSumVecCacheItem = new WordSumVecCacheItem();
        wordSumVecCacheItem.setId(UUID.randomUUID());
        Word2Vec word2Vec = WordSumVecCacheProcessor.processor(words);
        wordSumVecCacheItem.setWord2Vec(word2Vec);
        wordSumVecCacheItem.setWords(words);
        store.put(wordSumVecCacheItem.getId(), wordSumVecCacheItem);
        return wordSumVecCacheItem;
    }

    public WordSumVecCacheItem get(UUID uuid) throws Exception {
        if (store.get(uuid) != null) {
            return store.get(uuid);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
    }

}
