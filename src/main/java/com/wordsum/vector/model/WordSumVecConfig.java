package com.wordsum.vector.model;

import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;

public class WordSumVecConfig {

    public Integer minWordFrequency;
    public Integer layerSize;
    public Integer seed;
    public Integer windowSize;
    public SentenceIterator sentenceIterator;
    public TokenizerFactory tokenizerFactory;

    public WordSumVecConfig() {
    }

    public WordSumVecConfig(
            Integer minWordFrequency,
            Integer layerSize,
            Integer seed,
            Integer windowSize,
            SentenceIterator sentenceIterator,
            TokenizerFactory tokenizerFactory
    ) {
        this.minWordFrequency = minWordFrequency;
        this.layerSize = layerSize;
        this.seed = seed;
        this.windowSize = windowSize;
        this.sentenceIterator = sentenceIterator;
        this.tokenizerFactory = tokenizerFactory;
    }

    public Integer getMinWordFrequency() {
        return minWordFrequency;
    }

    public void setMinWordFrequency(Integer minWordFrequency) {
        this.minWordFrequency = minWordFrequency;
    }

    public Integer getLayerSize() {
        return layerSize;
    }

    public void setLayerSize(Integer layerSize) {
        this.layerSize = layerSize;
    }

    public Integer getSeed() {
        return seed;
    }

    public void setSeed(Integer seed) {
        this.seed = seed;
    }

    public Integer getWindowSize() {
        return windowSize;
    }

    public void setWindowSize(Integer windowSize) {
        this.windowSize = windowSize;
    }

    public SentenceIterator getSentenceIterator() {
        return sentenceIterator;
    }

    public void setSentenceIterator(SentenceIterator sentenceIterator) {
        this.sentenceIterator = sentenceIterator;
    }

    public TokenizerFactory getTokenizerFactory() {
        return tokenizerFactory;
    }

    public void setTokenizerFactory(TokenizerFactory tokenizerFactory) {
        this.tokenizerFactory = tokenizerFactory;
    }

}
