package com.wordsum.vector.utils;

import com.wordsum.vector.service.WordSumVecConfigService;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.text.sentenceiterator.BasicLineIterator;
import org.deeplearning4j.text.sentenceiterator.LineSentenceIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.CommonPreprocessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;

import java.io.ByteArrayInputStream;
import java.io.File;

public class WordSumVecCacheProcessor {

    private WordSumVecCacheProcessor() {
    }

    public static Word2Vec processor(String words) {
        return new Word2Vec.Builder()
                .windowSize(WordSumVecConfigService.Configuration.config.get().getWindowSize())
                .minWordFrequency(WordSumVecConfigService.Configuration.config.get().getMinWordFrequency())
                .layerSize(WordSumVecConfigService.Configuration.config.get().getLayerSize())
                .seed(WordSumVecConfigService.Configuration.config.get().getSeed())
                .iterate(loadString(words))
                .tokenizerFactory(getTokenizer())
                .build();
    }

    public static TokenizerFactory getTokenizer() {
        TokenizerFactory tokenizerFactory = new DefaultTokenizerFactory();
        tokenizerFactory.setTokenPreProcessor(new CommonPreprocessor());
        return tokenizerFactory;
    }

    public static SentenceIterator loadString(String words) {
        return new BasicLineIterator(new ByteArrayInputStream(words.getBytes()));
    }

    public static SentenceIterator loadFile(String filePath) {
        return new LineSentenceIterator(new File(filePath));
    }

}