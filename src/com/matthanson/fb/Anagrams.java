package com.matthanson.fb;

import java.util.*;

/**
 * Created by Matt on 9/27/16.
 */
public class Anagrams {
    public static List<List<String>> generateAnagrams(String[] strings) {

        List<List<String>> anagramsList = new LinkedList<>();
        if (strings == null || strings.length < 2) {
            return anagramsList;
        }

        Set<String> anagrams = new HashSet<>();
        for (int n = 0; n < strings.length; ++n) {
            String s = strings[n];

            if (s != null && !anagrams.contains(s)) {
                int sLen = s.length();

                List<String> anagramList = null;

                for (int m = n + 1; m < strings.length; ++m) {
                    if (strings[m] != null) {
                        Map<Character, Integer> wordSet = new HashMap<>();
                        for (int j = 0; j < sLen; ++j) {
                            Character c = s.charAt(j);
                            if (!wordSet.containsKey(c)) {
                                wordSet.put(c, 1);
                            } else {
                                wordSet.put(c, wordSet.get(c) + 1);
                            }
                        }


                        int stringLen = strings[m].length();
                        int l = 0;
                        for (l = 0; l < stringLen && wordSet.containsKey(strings[m].charAt(l)); ++l) {
                            char c = strings[m].charAt(l);
                            int nChars = wordSet.get(c);
                            if (nChars > 1) {
                                wordSet.put(c, wordSet.get(c) - 1);
                            } else {
                                wordSet.remove(c);
                            }
                        }

                        if (wordSet.isEmpty() && l == stringLen) {
                            // have an anagram
                            if (anagramList == null) {
                                anagramList = new LinkedList<>();
                                anagramList.add(s);
                                anagramsList.add(anagramList);

                            }

                            anagramList.add(strings[m]);
                            anagrams.add(s);
                            anagrams.add(strings[m]);
                        }
                    }
                }
            }

        }

        return anagramsList;
    }
}
