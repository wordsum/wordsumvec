package com.wordsum.vector.model;

public class WordSumVecCacheRequest {

    public String origin;
    public String words;

    public WordSumVecCacheRequest(String origin, String words) {
        this.origin = origin;
        this.words = words;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }
}
