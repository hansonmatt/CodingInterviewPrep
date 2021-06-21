package com.matthanson.ctci;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    public boolean isPalindromPermutation(String input) {
        if (input == null || input.length() == 0) {
            return true;
        }

        Map<Character, Integer> charCount = new HashMap<>();
        for (int n = 0; n < input.length(); ++n) {
            char character = input.charAt(n);

            if (Character.isLetterOrDigit(character)) {
                if (Character.isLetter(character)) {
                    character = Character.toLowerCase(character);
                }

                if (!charCount.containsKey(character)) {
                    charCount.put(character, 0);
                }

                charCount.put(character, charCount.get(character) + 1);
            }

        }

        int oddCount = 0;
        for (char character : charCount.keySet()) {
            oddCount += (charCount.get(character) % 2);
        }

        return oddCount <= 1;
    }
}
