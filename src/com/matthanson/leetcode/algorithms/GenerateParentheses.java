package com.matthanson.leetcode.algorithms;

import java.util.*;

/**
 * Created by matthans on 1/10/17.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        if (n < 2) {
            List<String> parens = new ArrayList<>();
            if (n == 1) {
                parens.add("()");

            }
            return parens;
        }

        Map<Integer, List<String>> parensMap = new HashMap<>(n);

        generateParenthesis(n, parensMap);

        return parensMap.get(n);
    }

    private void generateParenthesis(int n, Map<Integer, List<String>> parenthesis) {
        List<String> parens = new ArrayList<>();
        parenthesis.put(n, parens);
        if (n == 1) {
            parens.add("()");
            return;
        }

        this.generateParenthesis(n - 1, parenthesis);
        List<String> parensRecurse = parenthesis.get(n - 1);

        parens = parenthesis.get(n);
        HashSet<String> duplicateCheck = new HashSet<>();
        duplicateCheck.addAll(parens);
        for (int m = 1; m < n; ++m) {
            List<String> left = parenthesis.get(m);
            List<String> right = parenthesis.get(n - m);
            for (String l : left) {
                for (String r : right) {
                    String s = l.concat(r);
                    if (!duplicateCheck.contains(s)) {
                        parens.add(s);
                        duplicateCheck.add(s);
                    }
                }
            }
        }

        for (String s : parensRecurse) {

            String append = "(".concat(s).concat(")");
            if (!duplicateCheck.contains(append)) {
                parens.add(append);
                duplicateCheck.add(append);
            }
        }
    }
}
