package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by matthans on 1/25/17.
 */
public class GroupAnagramsTest {
    private GroupAnagrams ga = new GroupAnagrams();

    @Test
    public void groupAnagramsNull() throws Exception {
        assertTrue(ga.groupAnagrams(null).isEmpty());
    }

    @Test
    public void groupAnagramsEmpty() throws Exception {
        assertTrue(ga.groupAnagrams(new String [] {}).isEmpty());
    }

    @Test
    public void groupAnagramsSingleItem() throws Exception {
        List<List<String>> anagramGroups = ga.groupAnagrams(new String [] {"matt"});
        assertEquals(1, anagramGroups.size());
        assertEquals(1, anagramGroups.get(0).size());
        assertEquals("matt", anagramGroups.get(0).get(0));
    }

    @Test
    public void groupAnagrams() throws Exception {
        List<List<String>> anagramGroups = ga.groupAnagrams(new String [] {"eat", "tea", "tan", "ate", "nat", "bat"});
        assertEquals(3, anagramGroups.size());
        assertEquals(3, anagramGroups.get(0).size());
        assertEquals("eat", anagramGroups.get(0).get(0));
        assertEquals("tea", anagramGroups.get(0).get(1));
        assertEquals("ate", anagramGroups.get(0).get(2));
    }

}