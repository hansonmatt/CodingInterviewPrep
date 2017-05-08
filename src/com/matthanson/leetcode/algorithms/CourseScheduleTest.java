package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by matthans on 3/28/17.
 */
public class CourseScheduleTest {
    private CourseSchedule cs = new CourseSchedule();

    @Test
    public void canFinish() throws Exception {
        assertTrue(cs.canFinish(0, null));
        assertTrue(cs.canFinish(0, new int[0][]));
        assertTrue(cs.canFinish(1, null));
        assertTrue(cs.canFinish(1, new int[0][]));

        int [][] prerequisites = new int[3][];
        prerequisites[0] = new int[] {100,25};
        prerequisites[1] = new int[] {50,25,15};
        prerequisites[2] = new int[] {200,100,50};
        assertTrue(cs.canFinish(3, prerequisites));

        prerequisites[2] = new int[] {0,50};
        prerequisites[0] = new int[] {1,25,0};
        assertTrue(cs.canFinish(3, prerequisites));

        // leetcode - 4 [[0,1],[3,1],[1,3],[3,2]]
        prerequisites = new int[4][];
        prerequisites[0] = new int[] {0,1};
        prerequisites[1] = new int[] {3,1};
        prerequisites[2] = new int[] {1,3};
        prerequisites[3] = new int[] {3,2};
        assertFalse(cs.canFinish(4, prerequisites));

        prerequisites = new int[2][];
        prerequisites[0] = new int[] {0,1};
        prerequisites[1] = new int[] {1,0};
        assertFalse(cs.canFinish(2, prerequisites));

        //[[1,0],[2,6],[1,7],[5,1],[6,4],[7,0],[0,5]]
        prerequisites = new int[7][];
        prerequisites[0] = new int[] {1,0};
        prerequisites[1] = new int[] {2,6};
        prerequisites[2] = new int[] {1,7};
        prerequisites[3] = new int[] {5,1};
        prerequisites[4] = new int[] {6,4};
        prerequisites[5] = new int[] {7,0};
        prerequisites[6] = new int[] {0,5};
        assertFalse(cs.canFinish(8, prerequisites));
    }

    @Test
    public void testHasCycle() throws Exception {
        Map<Integer, List<Integer>> courseMap = this.getFreshCourseMap();

        assertFalse(cs.hasCycle(200, courseMap, new HashSet<>(), new HashSet<>()));

        // add cycle from 25 back to 50
        courseMap.get(25).add(50);
        assertTrue(cs.hasCycle(200, courseMap, new HashSet<>(), new HashSet<>()));

        // add cycle from 5 back to 200
        courseMap = this.getFreshCourseMap();
        LinkedList<Integer> prereqs = new LinkedList<>();
        prereqs.add(200);
        courseMap.put(5, prereqs);
        assertTrue(cs.hasCycle(200, courseMap, new HashSet<>(), new HashSet<>()));

        // remove 50 from 200 prereqs, add prereq from 200 to 50, no cycle
        courseMap = this.getFreshCourseMap();
        prereqs = new LinkedList<>();
        prereqs.add(100);
        courseMap.put(200, prereqs);
        courseMap.get(50).add(200);
        assertFalse(cs.hasCycle(200, courseMap, new HashSet<>(), new HashSet<>()));
    }

    private Map<Integer, List<Integer>> getFreshCourseMap() {
        Map<Integer, List<Integer>> courseMap = new HashMap<>();

        LinkedList<Integer> prereq = new LinkedList<>();
        prereq.add(100);
        prereq.add(50);
        courseMap.put(200, prereq);

        prereq = new LinkedList<>();
        prereq.add(25);
        courseMap.put(100, prereq);

        prereq = new LinkedList<>();
        prereq.add(25);
        prereq.add(15);
        courseMap.put(50, prereq);

        prereq = new LinkedList<>();
        prereq.add(5);
        courseMap.put(25, prereq);

        return courseMap;
    }

}