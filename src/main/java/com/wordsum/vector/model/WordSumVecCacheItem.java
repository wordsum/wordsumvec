package com.wordsum.vector.model;

import org.deeplearning4j.models.word2vec.Word2Vec;

import java.util.UUID;

public class WordSumVecCacheItem {

    private UUID id;
    private String words;
    private Word2Vec word2Vec;

    public WordSumVecCacheItem() {
    }

    public WordSumVecCacheItem(UUID id, String words, Word2Vec word2Vec) {
        this.id = id;
        this.words = words;
        this.word2Vec = word2Vec;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public Word2Vec getWord2Vec() {
        return word2Vec;
    }

    public void setWord2Vec(Word2Vec word2Vec) {
        this.word2Vec = word2Vec;
    }
}
