package com.matthanson.ctci;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BuildOrderTest {
    private BuildOrder buildOrder = new BuildOrder();

    @Test
    public void testBuildOrder() {
        List<ArrayList<Integer>> l = new LinkedList<>();
        l.add(new ArrayList(Arrays.asList(1, 4)));
        l.add(new ArrayList(Arrays.asList(6, 2)));
        l.add(new ArrayList(Arrays.asList(2, 4)));
        l.add(new ArrayList(Arrays.asList(6, 1)));
        l.add(new ArrayList(Arrays.asList(4, 3)));
        List<Integer> returnList = buildOrder.buildOrder((List<Integer>) Arrays.asList(1, 2, 3, 4, 5, 6), l);
    }
}