package com.matthanson.leetcode.algorithms;

import java.util.*;

/**
 * Created by matthans on 3/28/17.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 1) {
            return true;
        }

        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        for (int prereq = 0; prereq < prerequisites.length; ++prereq) {
            int[] prereqs = prerequisites[prereq];

            if (!courseMap.containsKey(prereqs[0])) {
                courseMap.put(prereqs[0], new LinkedList<>());
            }

            for (int course = 1; course < prereqs.length; ++course) {
                courseMap.get(prereqs[0]).add(prereqs[course]);
            }
        }

        Set<Integer> completed = new HashSet<>();
        Set<Integer> mustComplete = new HashSet<>();
        for (int n = 0; n < numCourses; ++n) {
            if (courseMap.containsKey(n)) {
                mustComplete.add(n);
            } else {
                completed.add(n);
            }
        }

        for (int n : mustComplete) {
            if (hasCycle(n, courseMap, new HashSet<Integer>(), completed)) {
                return false;
            }
        }

        return true;
    }

    public boolean hasCycle(int course, Map<Integer, List<Integer>> courseMap, Set<Integer> visited, Set<Integer> completed) {
        if (visited.contains(course)) {
            return true;
        }

        if (completed.contains(course)) {
            return false;
        }

        visited.add(course);

        List<Integer> prereqs = courseMap.get(course);
        if (prereqs != null) {
            for (int prereq : prereqs) {
                if (this.hasCycle(prereq, courseMap, visited, completed)) {
                    return true;
                }
            }
        }

        visited.remove(course);
        completed.add(course);

        return false;
    }
}
