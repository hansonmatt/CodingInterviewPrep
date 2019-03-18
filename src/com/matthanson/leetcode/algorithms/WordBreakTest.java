package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WordBreakTest {
    private WordBreak wordBreak = new WordBreak();

    @Test
    public void wordBreak() {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("leet");
        dictionary.add("code");
        assertTrue(wordBreak.wordBreak("leetcode", dictionary));

        dictionary.clear();
        dictionary.add("apple");
        dictionary.add("pen");
        assertTrue(wordBreak.wordBreak("applepenapple", dictionary));

        dictionary.clear();
        dictionary.add("cats");
        dictionary.add("dog");
        dictionary.add("sand");
        dictionary.add("and");
        dictionary.add("cat");
        assertFalse(wordBreak.wordBreak("catsandog", dictionary));

        dictionary.clear();
        dictionary.add("cat");
        dictionary.add("cats");
        dictionary.add("dog");
        dictionary.add("dogs");
        dictionary.add("sand");
        dictionary.add("sando");
        dictionary.add("san");
        dictionary.add("and");
        assertTrue(wordBreak.wordBreak("catsandogs", dictionary));

        dictionary.clear();
        dictionary.add("a");
        dictionary.add("aa");
        dictionary.add("aaa");
        dictionary.add("aaaa");
        dictionary.add("aaaaa");
        dictionary.add("aaaaaa");
        dictionary.add("aaaaaaaa");
        dictionary.add("aaaaaaaaa");
        dictionary.add("aaaaaaaaaa");
        assertTrue(wordBreak.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                dictionary));
    }
}