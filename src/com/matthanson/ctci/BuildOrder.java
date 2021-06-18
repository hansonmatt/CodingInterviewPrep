package com.matthanson.ctci;

import java.util.*;

public class BuildOrder<T> {

    public static class TreeNode<T> {
        public T val;
        public List<TreeNode> children = new LinkedList<>();

        TreeNode(T x) {
            val = x;
        }
    }

    public List<T> buildOrder(List<T> programs, List<ArrayList<T>> dependencies) {
        Map<T, TreeNode> programMap = new HashMap<>();
        for (T program : programs) {
            programMap.put(program, new TreeNode<T>(program));
        }

        Set<T> dependencySet = new LinkedHashSet<>();
        for (ArrayList<T> dependency : dependencies) {
            T program1 = dependency.get(0);
            T program2 = dependency.get(1);
            if (!programMap.containsKey(dependency.get(0))) {
                throw new IllegalArgumentException("All dependencies must exist in the program list");
            }

            programMap.get(dependency.get(0)).children.add(programMap.get(dependency.get(1)));
            dependencySet.add(dependency.get(0));
            if (dependencySet.contains(dependency.get(1))) {
                dependencySet.remove(dependency.get(1));
            }
        }


        List<T> returnList = new LinkedList<>();
        Set<T> visited = new HashSet<>();

        for (T dependency : dependencySet) {
            if (!visited.contains(dependency)) {
                returnList.add(dependency);
                visited.add(dependency);

                Queue<TreeNode> programQueue = new LinkedList<>();
                TreeNode program = programMap.get(dependency);
                programQueue.addAll(program.children);
                while (!programQueue.isEmpty()) {
                    TreeNode<T> child = programQueue.remove();
                    if (!visited.contains(child.val)) {
                        returnList.add(child.val);
                        visited.add(child.val);
                        programQueue.addAll(child.children);
                    }
                }
            }
        }

        for (T program : programs) {
            if (!visited.contains(program)) {
                returnList.add(program);
            }
        }

        return returnList;
    }
}
