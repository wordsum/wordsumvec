package com.wordsum.vector.controller;

import com.wordsum.vector.model.WordSumVecConfigReponse;
import com.wordsum.vector.service.WordSumVecConfigService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WordSumVecConfig {

    @RequestMapping(value = "/rest/v1/wordsum/vector/config", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<WordSumVecConfigReponse> put(@RequestParam(value = "minWordFrequency", required = false) Integer minWordFrequency,
                                                       @RequestParam(value = "layerSize", required = false) Integer layerSize,
                                                       @RequestParam(value = "seed", required = false) Integer seed,
                                                       @RequestParam(value = "windowSize", required = false) Integer windowSize) {
        WordSumVecConfigService.Configuration.config.put(minWordFrequency, layerSize, seed, windowSize);
        return new ResponseEntity<>(new WordSumVecConfigReponse(
                HttpStatus.OK,
                new com.wordsum.vector.model.WordSumVecConfig(
                        WordSumVecConfigService.Configuration.config.get().getMinWordFrequency(),
                        WordSumVecConfigService.Configuration.config.get().getLayerSize(),
                        WordSumVecConfigService.Configuration.config.get().getSeed(),
                        WordSumVecConfigService.Configuration.config.get().getWindowSize(),
                        null,
                        null
                )
        ), HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/v1/wordsum/vector/config", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<WordSumVecConfigReponse> get() {
        return new ResponseEntity<>(new WordSumVecConfigReponse(
                HttpStatus.OK,
                new com.wordsum.vector.model.WordSumVecConfig(
                        WordSumVecConfigService.Configuration.config.get().getMinWordFrequency(),
                        WordSumVecConfigService.Configuration.config.get().getLayerSize(),
                        WordSumVecConfigService.Configuration.config.get().getSeed(),
                        WordSumVecConfigService.Configuration.config.get().getWindowSize(),
                        null,
                        null
                )), HttpStatus.OK);
    }

}
