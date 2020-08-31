package com.wordsum.vector.utils;

import com.wordsum.vector.model.WordSumVecNearestReponse;
import com.wordsum.vector.service.WordSumVecCacheService;
import org.deeplearning4j.models.word2vec.Word2Vec;

import java.util.UUID;

public class WordSumVecNearestProcessor {

    private WordSumVecNearestProcessor() {
    }

    public static WordSumVecNearestReponse get(String word, Integer count, UUID cacheId) throws Exception {
        WordSumVecNearestReponse wordSumVecNearestReponse = new WordSumVecNearestReponse();
        wordSumVecNearestReponse.setCount(count);
        wordSumVecNearestReponse.setWord(word);
        return getNearest(WordSumVecCacheService.getCache().get(cacheId).getWord2Vec(), wordSumVecNearestReponse);
    }

    public static WordSumVecNearestReponse getNearest(Word2Vec word2Vec, WordSumVecNearestReponse wordSumVecNearestReponse) {
        word2Vec.fit();
        wordSumVecNearestReponse.setNearest(word2Vec.wordsNearest(wordSumVecNearestReponse.getWord(), wordSumVecNearestReponse.getCount()));
        return wordSumVecNearestReponse;
    }
}
