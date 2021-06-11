package com.matthanson.ctci;

public class URLify {
    public String urlify(char[] url, int urlLength) {
        if (url == null) {
            return null;
        }

        int swap = url.length - urlLength;
        for (int x = url.length - 1; x >= 0; --x) {
            int swapInternal = x - swap;
            if (swapInternal < 0) {
                throw new IllegalArgumentException("Invalid urlLength param");
            }

            if (url[swapInternal] == ' ') {
                url[x--] = '0';
                url[x--] = '2';
                url[x] = '%';
                swap -= 2;
            } else {
                url[x] = url[swapInternal];
            }
        }

        String returnUrl = String.valueOf(url);
        return String.valueOf(url);
    }
}
