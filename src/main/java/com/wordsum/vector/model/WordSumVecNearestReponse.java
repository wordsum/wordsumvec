package com.wordsum.vector.model;

import org.springframework.http.HttpStatus;

import java.util.Collection;
import java.util.UUID;

public class WordSumVecNearestReponse {

    private UUID transactionId;
    private HttpStatus statusCode;
    private String word;
    private Integer count;
    private Collection<String> nearest;

    public WordSumVecNearestReponse() {
    }

    public WordSumVecNearestReponse(HttpStatus statusCode,
                                    String word,
                                    Integer count,
                                    Collection<String> nearest) {
        this.transactionId = UUID.randomUUID();
        this.statusCode = statusCode;
        this.word = word;
        this.count = count;
        this.nearest = nearest;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Collection<String> getNearest() {
        return nearest;
    }

    public void setNearest(Collection<String> nearest) {
        this.nearest = nearest;
    }
}
