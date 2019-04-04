package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import static org.junit.Assert.*;

public class CloneGraphTest {
    private CloneGraph clone = new CloneGraph();

    @Test
    public void cloneGraph() {
        assertNull(clone.cloneGraph(null));

        CloneGraph.Node node1 = new CloneGraph.Node();
        node1.val = 1;
        node1.neighbors = new LinkedList<>();

        CloneGraph.Node node2 = new CloneGraph.Node();
        node2.val = 2;
        node2.neighbors = new LinkedList<>();

        CloneGraph.Node node3 = new CloneGraph.Node();
        node3.val = 3;
        node3.neighbors = new LinkedList<>();

        CloneGraph.Node node4 = new CloneGraph.Node();
        node4.val = 4;
        node4.neighbors = new LinkedList<>();

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node3);
        node4.neighbors.add(node1);

        CloneGraph.Node node = clone.cloneGraph(node1);
        validateClone(node1, node);

        // 1->2
        CloneGraph.Node n = node.neighbors.get(node.neighbors.indexOf(node2));
        validateClone(node2, n);

        // 1->4
        n = node.neighbors.get(node.neighbors.indexOf(node4));
        validateClone(node4, n);

        // 1->2->3
        n = node.neighbors.get(node.neighbors.indexOf(node2));
        n = n.neighbors.get(n.neighbors.indexOf(node3));
        validateClone(node3, n);
    }

    @Test
    public void cloneBiggerGraph() {
        CloneGraph.Node node1 = new CloneGraph.Node(1, new LinkedList<>());
        CloneGraph.Node node6 = new CloneGraph.Node(6, new LinkedList<>());
        CloneGraph.Node node8 = new CloneGraph.Node(8, new LinkedList<>());
        CloneGraph.Node node12 = new CloneGraph.Node(12, new LinkedList<>());
        CloneGraph.Node node9 = new CloneGraph.Node(9, new LinkedList<>());
        CloneGraph.Node node17 = new CloneGraph.Node(17, new LinkedList<>());

        node1.neighbors.add(node6);
        node1.neighbors.add(node8);
        node1.neighbors.add(node12);

        node8.neighbors.add(node1);
        node8.neighbors.add(node12);
        node8.neighbors.add(node9);
        node8.neighbors.add(node6);

        node6.neighbors.add(node17);
        node6.neighbors.add(node8);
        node6.neighbors.add(node1);

        node9.neighbors.add(node12);
        node9.neighbors.add(node8);

        node17.neighbors.add(node12);
        node17.neighbors.add(node6);

        node12.neighbors.add(node1);
        node12.neighbors.add(node8);
        node12.neighbors.add(node17);
        node12.neighbors.add(node9);


        CloneGraph.Node node = clone.cloneGraph(node1);
        validateClone(node1, node);

        // 1->12
        CloneGraph.Node n = node.neighbors.get(node.neighbors.indexOf(node12));
        validateClone(node12, n);

        // 1->8
        n = node.neighbors.get(node.neighbors.indexOf(node8));
        validateClone(node8, n);

        // 1->6
        n = node.neighbors.get(node.neighbors.indexOf(node6));
        validateClone(node6, n);

        // 6->17
        n = n.neighbors.get(n.neighbors.indexOf(node17));
        validateClone(node17, n);

        // 1->8->9
        n = node.neighbors.get(node.neighbors.indexOf(node8));
        n = n.neighbors.get(n.neighbors.indexOf(node9));
        validateClone(node9, n);
    }

    private void validateClone(CloneGraph.Node orig, CloneGraph.Node clone) {

        assertEquals(orig.val, clone.val);
        assertEquals(orig.neighbors.size(), clone.neighbors.size());
        Set<Integer> origNeighbors = new HashSet<>();
        for (CloneGraph.Node neighbor : orig.neighbors) {
            origNeighbors.add(neighbor.val);
        }

        for (CloneGraph.Node neighbor : clone.neighbors) {
            assertTrue(origNeighbors.contains(neighbor.val));
            origNeighbors.remove(neighbor.val);
        }

        assertTrue(origNeighbors.isEmpty());
    }
}