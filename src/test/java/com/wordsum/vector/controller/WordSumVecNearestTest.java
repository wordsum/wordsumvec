package com.wordsum.vector.controller;

import com.wordsum.vector.model.WordSumVecCacheItem;
import com.wordsum.vector.model.WordSumVecNearestReponse;
import com.wordsum.vector.service.WordSumVecCacheService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WordSumVecNearestTest extends ControllerTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    private final String uri = "/rest/v1/wordsum/vector/nearest";

    @Test
    public void testGetMissingParamNearest() throws Exception {

        String queryParamsMissing = "?cacheId=20655656-0206-4adf-b7dc-3c1858d5215e&count=1";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri + queryParamsMissing)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        assertEquals(400, mvcResult.getResponse().getStatus());

    }

    @Test
    public void testGBadParameterNearest() throws Exception {

        String queryParamsBad = "?cacheId=3c1858d5215e&word=test&count=1";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri + queryParamsBad)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        assertEquals(400, mvcResult.getResponse().getStatus());

    }

    @Test
    public void testGetNearestNotFound() throws Exception {

        String queryParamsNotFound = "?cacheId=29655656-0286-4adf-b7dc-3c1858d5215e&word=test&count=1";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri + queryParamsNotFound)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        assertEquals(404, mvcResult.getResponse().getStatus());

    }

    @Test
    public void testGetNearest() throws Exception {
        Collection list = new ArrayList();
        list.add("and");
        list.add("she");
        list.add("from");
        list.add("blood");
        WordSumVecNearestReponse wordSumVecNearestReponseTest = new WordSumVecNearestReponse(
                HttpStatus.OK,
                "river",
                4,
                list
        );
        WordSumVecCacheItem wordSumVecCacheItem = WordSumVecCacheService.getCache().put("rain from a bloody room, a blood cocoon and your body.Her hand " +
                "grips robe.Portland dives from dock, slides into river.River pulls her body. Her body explodes blood " +
                "through pores. With the river, blood flows.Portland strokes through ripple waves from blood to shore. " +
                "She pulls robe over body and steps from river shore. She licks bloody lips.Blood drips from her body " +
                "over rocks to concrete trail along river's edge.Street lights shine over river.Car lights shine over " +
                "bridges over river.A cold wind blows ripples and rain.Rain blows to a mist, flows with blood and drips " +
                "from robe.Portland runs, and robe flaps.Portland smiles.Lamp posts and railing guide her river run by " +
                "river's edge.Portland runs, jumps, stumbles, balances, runs upon railing then concrete trail. She runs " +
                "with highway, under bridge. She leaps, and blood mist blows from soles and palms. She flies across the " +
                "river to the other side. She flies along the river bank. She falls and sways as blood mist blows from soles.");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri + "?cacheId=" + wordSumVecCacheItem.getId() + "&word=river&count=4")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        WordSumVecNearestReponse wordSumVecNearestReponse =
                super.fromJson(
                        mvcResult.getResponse().getContentAsString(),
                        WordSumVecNearestReponse.class);
        assertTrue(wordSumVecNearestReponseTest.getNearest().containsAll(wordSumVecNearestReponse.getNearest()));
        assertEquals(200, mvcResult.getResponse().getStatus());
    }
}
