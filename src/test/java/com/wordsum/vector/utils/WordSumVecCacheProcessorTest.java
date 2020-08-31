package com.wordsum.vector.utils;

import com.wordsum.vector.model.WordSumVecNearestReponse;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class WordSumVecCacheProcessorTest {

    Word2Vec word2Vec;

    String words = "The harvester Mary says to the farmers like Jesus Smith, who work the farm fields of Utah for the company Univeral Work Team, ''We'll give you two years of wages to train for a month to earn a job on Mars. If you pass work challenge during the journey to Mars, you'll make enough money for your family's family.'' \n" +
            "Univeral Work Team picks poor workers without the United States citizenchip from Utah, Idaho, Navada. They offer the workers freedom, money and the chance to enrich themselves and their families by working on Mars. Once the workers say to a harvester like Mary, ''I want to work on Mars,'' Universal Work Team transfers the worker to a training facility that isolates the workers for a month training. \n" +
            "During the month of training, the workers live a small room as big a closet. During the day, the workers silently run, eat and read fiction alone. They sleep and live in their small rooms alone at night. The guards only enforce rule one, ''NO COMMUNICATION.'' \n" +
            "Every day the guards punish workers that talk, make eye contact, gestilcate with guards or other workers by giving the workers less food, humiliation, or threaten their future profits as a worker on Mars. For thirty days, the trainers threaten, ''If you communicate after the chip is injected. You may fail the work challenge.''\n" +
            "''No communication,'' A shock jolts their bodies any time they make noise with their mouths during the final two weeks of training. For the final week of training, the workers wear halo collars connected to opague head spheres blocking senory input around the head until a guard removes the headsphere and injects a Universal Work Team nano-chip into the worker's foreheads.";

    @Before
    public void before() throws Exception {
        word2Vec = WordSumVecCacheProcessor.processor(words);
    }

    @Test
    public void testNearest() {

        Collection list = new ArrayList();
        list.add("work");
        list.add("the");
        list.add("of");
        list.add("for");
        list.add("and");

        WordSumVecNearestReponse wordSumVecNearestReponse = new WordSumVecNearestReponse();
        wordSumVecNearestReponse.setCount(5);
        wordSumVecNearestReponse.setWord("workers");
        WordSumVecNearestProcessor.getNearest(word2Vec, wordSumVecNearestReponse);

        Assert.assertTrue(list.containsAll(wordSumVecNearestReponse.getNearest()));
    }

}
