package com.matthanson.fb;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Matt on 9/28/16.
 * <p>
 * Give you a data structure Seq
 * class Seq {
 * int value;
 * Seq next;
 * }
 * <p>
 * and give you two Seq object seq., seq., compare two objects,
 * return true if there is only one difference or no difference,
 * false if more than two differences.
 */
public class SeqDifferences {
    public static class Seq {
        int value;
        Seq next;
    }

    public boolean isSame(Seq seq1, Seq seq2) {
        Map<Integer, Integer> seq1Map = new HashMap<>();
        Map<Integer, Integer> seq2Map = new HashMap<>();

        populateMap(seq1, seq1Map);
        populateMap(seq2, seq2Map);

        Map<Integer, Integer> larger = (seq1Map.size() > seq2Map.size()) ? seq1Map : seq2Map;
        Map<Integer, Integer> smaller = (larger == seq1Map) ? seq2Map : seq1Map;
        for (Integer i : smaller.keySet()) {
            if (larger.containsKey(i)) {
                if (larger.get(i) == smaller.get(i)) {
                    larger.put(i, 0);
                    smaller.put(i, 0);
                } else {
                    larger.put(i, larger.get(i) - smaller.get(i));
                }
            }
        }

        int diffs = 0;
        for (int n : seq1Map.values()) {
            diffs += Math.abs(n);
        }

        for (int n : seq2Map.values()) {
            diffs += Math.abs(n);
        }

        return diffs <= 1;
    }

    private void populateMap(Seq s, Map<Integer, Integer> map) {
        while (s != null) {
            if (map.containsKey(s.value)) {
                map.put(s.value, map.get(s.value) + 1);
            } else {
                map.put(s.value, 1);
            }

            s = s.next;
        }
    }
}
