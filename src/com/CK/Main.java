package com.CK;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {

    final static char[][] pairs = {{'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};

    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        generate(res, 0, n-1, new char[n]);
        return res;
    }

    void generate(List<String> res, int l, int r, char[] cs) {
        if (l > r) {
            res.add(new String(cs));
            return;
        }
        if (l == r) {
            cs[l] = '1';
            res.add(new String(cs));
            cs[l] = '8';
            res.add(new String(cs));
            cs[l] = '0';
            res.add(new String(cs));
            return;
        }
        for (char[] p: pairs) {
            cs[l] = p[0];
            cs[r] = p[1];
            generate(res, l+1, r-1, cs);
        }
        if (l != 0 && r != cs.length-1) {
            cs[l] = '0';
            cs[r] = '0';
            generate(res, l+1, r-1, cs);
        }

    }
}