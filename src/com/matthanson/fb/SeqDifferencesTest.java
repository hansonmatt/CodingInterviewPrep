package com.matthanson.fb;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matt on 9/28/16.
 */
public class SeqDifferencesTest {
    @Test
    public void isSame() throws Exception {
        SeqDifferences.Seq s1_1 = new SeqDifferences.Seq();
        s1_1.value = 1;
        SeqDifferences.Seq s1_12 = new SeqDifferences.Seq();
        s1_12.value = 2;
        s1_1.next = s1_12;
        SeqDifferences.Seq s1_123 = new SeqDifferences.Seq();
        s1_123.value = 3;
        s1_12.next = s1_123;

        SeqDifferences.Seq s2_1 = new SeqDifferences.Seq();
        s2_1.value = 1;
        SeqDifferences.Seq s2_13 = new SeqDifferences.Seq();
        s2_13.value = 3;
        s2_1.next = s2_13;
        SeqDifferences.Seq s2_132 = new SeqDifferences.Seq();
        s2_132.value = 2;
        s2_13.next = s2_132;

        SeqDifferences diff = new SeqDifferences();
        assertTrue(diff.isSame(s1_1, s2_1));

        SeqDifferences.Seq s2_1324 = new SeqDifferences.Seq();
        s2_1324.value = 4;
        s2_132.next = s2_1324;
        assertTrue(diff.isSame(s1_1, s2_1));

        SeqDifferences.Seq s2_13245 = new SeqDifferences.Seq();
        s2_13245.value = 5;
        s2_1324.next = s2_13245;
        assertFalse(diff.isSame(s1_1, s2_1));
    }

}