package com.wordsum.vector.model;

import org.springframework.http.HttpStatus;

import java.util.UUID;

public class WordSumVecCacheResponse {

    private UUID transactionId;
    private HttpStatus statusCode;
    private WordSumVecCacheItem wordSumVecCacheItem;

    public WordSumVecCacheResponse() {
    }

    public WordSumVecCacheResponse(HttpStatus statusCode, WordSumVecCacheItem wordSumVecCacheItem) {
        this.transactionId = UUID.randomUUID();
        this.statusCode = statusCode;
        this.wordSumVecCacheItem = wordSumVecCacheItem;
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

    public WordSumVecCacheItem getWordSumVecCacheItem() {
        return wordSumVecCacheItem;
    }

    public void setWordSumVecCacheItem(WordSumVecCacheItem wordSumVecCacheItem) {
        this.wordSumVecCacheItem = wordSumVecCacheItem;
    }
}
