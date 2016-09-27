package com.matthanson.fb;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Matt on 9/27/16.
 */
public class AnagramsTest {
    @Test
    public void generateAnagrams() throws Exception {
        assertTrue(Anagrams.generateAnagrams(null).isEmpty());
        assertTrue(Anagrams.generateAnagrams(new String[0]).isEmpty());
        assertTrue(Anagrams.generateAnagrams(new String[]{"anagram"}).isEmpty());
        assertTrue(Anagrams.generateAnagrams(new String[]{null, null}).isEmpty());

        List<List<String>> anagramsList = new LinkedList<>();

        List<String> anagramList = new LinkedList<>();
        anagramList.add("nash");
        anagramList.add("hans");
        anagramsList.add(anagramList);

        assertEquals(anagramsList, Anagrams.generateAnagrams(new String[]{"nash", "hans"}));
        assertEquals(anagramsList, Anagrams.generateAnagrams(new String[]{"nash", "blah", "hans"}));

        anagramList = new LinkedList<>();
        anagramList.add("shey");
        anagramList.add("heys");
        anagramsList.add(anagramList);

        assertEquals(anagramsList, Anagrams.generateAnagrams(new String[]{"nash", "shey", "blah", "hans", "heys"}));
        assertEquals(anagramsList, Anagrams.generateAnagrams(new String[]{"nash", "shey", "blah", "hans", "heys", "hey"}));
        assertEquals(anagramsList, Anagrams.generateAnagrams(new String[]{"nash", "shey", "blah", "", "null", "hans", "heys", "hey"}));
        assertEquals(anagramsList, Anagrams.generateAnagrams(new String[]{"nash", null, "shey", "blah", "", "null", null, "hans", "heys", "hey"}));
    }

}