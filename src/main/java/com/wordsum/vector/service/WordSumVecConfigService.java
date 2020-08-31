package com.wordsum.vector.service;


import com.wordsum.vector.model.WordSumVecConfig;

public class WordSumVecConfigService {

    private final WordSumVecConfig config;

    private WordSumVecConfigService() {
        config = new WordSumVecConfig();
        config.setMinWordFrequency(5);
        config.setLayerSize(100);
        config.setSeed(42);
        config.setWindowSize(5);
    }

    public static class Configuration {
        public static WordSumVecConfigService config = new WordSumVecConfigService();
    }

    public WordSumVecConfig put(Integer minWordFrequency,
                                Integer layerSize,
                                Integer seed,
                                Integer windowSize) {
        if (minWordFrequency != null) {
            config.setMinWordFrequency(minWordFrequency);
        }
        if (layerSize != null) {
            config.setLayerSize(layerSize);
        }
        if (seed != null) {
            config.setSeed(seed);
        }
        if (windowSize != windowSize) {
            config.setWindowSize(windowSize);
        }

        return config;
    }

    public WordSumVecConfig get() {
        return config;
    }
}
