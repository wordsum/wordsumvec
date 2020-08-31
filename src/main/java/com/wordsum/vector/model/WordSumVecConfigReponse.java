package com.wordsum.vector.model;

import org.springframework.http.HttpStatus;

import java.util.UUID;

public class WordSumVecConfigReponse {

    private UUID transactionId;
    private HttpStatus statusCode;
    private WordSumVecConfig wordSumVecConfig;

    public WordSumVecConfigReponse(HttpStatus statusCode, WordSumVecConfig wordSumVecConfig) {
        this.transactionId = UUID.randomUUID();
        this.statusCode = statusCode;
        this.wordSumVecConfig = wordSumVecConfig;
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

    public WordSumVecConfig getWordSumVecConfig() {
        return wordSumVecConfig;
    }

    public void setWordSumVecConfig(WordSumVecConfig wordSumVecConfig) {
        this.wordSumVecConfig = wordSumVecConfig;
    }
}
