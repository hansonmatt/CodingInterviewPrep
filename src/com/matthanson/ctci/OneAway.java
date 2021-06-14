package com.matthanson.ctci;

public class OneAway {
    public boolean oneAway(String s1, String s2) {
        if (s1 == null) {
            s1 = "";
        }

        if (s2 == null) {
            s2 = "";
        }

        if (s2.length() < s1.length() - 1 || s2.length() > s1.length() + 1) {
            throw new IllegalArgumentException("String lengths must differ by at most 1");
        }

        String longer = (s1.length() >= s2.length()) ? s1 : s2;
        String shorter = (s1.length() < s2.length()) ? s1 : s2;

        int edits = 0;
        for (int n = 0, m = 0; n < longer.length(); ++n, ++m) {
            if (m >= shorter.length()) {
                ++edits;
            } else if (longer.charAt(n) != shorter.charAt(m)) {
                ++edits;
                if (longer.length() != shorter.length()) {
                    --m;
                }
            }
        }

        return edits <= 1;
    }
}
