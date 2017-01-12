package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static org.junit.Assert.*;

/**
 * Created by matthans on 1/10/17.
 */
public class GenerateParenthesesTest {
    private GenerateParentheses gp = new GenerateParentheses();

    @Test
    public void generateParenthesisNegative() throws Exception {
        assertTrue(gp.generateParenthesis(-1).isEmpty());
    }

    @Test
    public void generateParenthesis0() throws Exception {
        assertTrue(gp.generateParenthesis(0).isEmpty());
    }

    @Test
    public void generateParenthesis1() throws Exception {
        List<String> parens = gp.generateParenthesis(1);
        assertEquals(1, parens.size());
        assertTrue(parens.contains("()"));
    }

    @Test
    public void generateParenthesis3() throws Exception {
        List<String> parens = gp.generateParenthesis(3);
        assertEquals(5, parens.size());
        assertTrue(parens.contains("()()()"));
        assertTrue(parens.contains("()(())"));
        assertTrue(parens.contains("(()())"));
        assertTrue(parens.contains("((()))"));
        assertTrue(parens.contains("(())()"));
    }

    @Test
    public void generateParenthesis4() throws Exception {
        List<String> parens = gp.generateParenthesis(4);
        String [] parensArray = new String[] {"(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"};
        for (int n = 0; n < parensArray.length; ++n) {
           assertTrue(parens.contains(parensArray[n]));
        }
    }

    @Test
    public void generateParenthesis5() throws Exception {
        List<String> parens = gp.generateParenthesis(5);
        String [] parensArray = new String[] {"((((()))))","(((()())))","(((())()))","(((()))())","(((())))()","((()(())))","((()()()))","((()())())","((()()))()","((())(()))","((())()())","((())())()","((()))(())","((()))()()","(()((())))","(()(()()))","(()(())())","(()(()))()","(()()(()))","(()()()())","(()()())()","(()())(())","(()())()()","(())((()))","(())(()())","(())(())()","(())()(())","(())()()()","()(((())))","()((()()))","()((())())","()((()))()","()(()(()))","()(()()())","()(()())()","()(())(())","()(())()()","()()((()))","()()(()())","()()(())()","()()()(())","()()()()()"};
        for (int n = 0; n < parensArray.length; ++n) {
            assertTrue(parens.contains(parensArray[n]));
        }
    }

}