package com.matthanson.leetcode.algorithms;

import java.util.*;

/**
 * Created by matthans on 1/24/17.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        List<List<String>> anagramGroups = new ArrayList<>();

        if (strs == null) {
            return anagramGroups;
        }

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (!anagramMap.containsKey(sorted)) {
                List<String> anagramGroup = new ArrayList<String>();
                anagramGroups.add(anagramGroup);
                anagramMap.put(sorted, anagramGroup);
            }

            anagramMap.get(sorted).add(s);
        }


        return anagramGroups;
    }
}
