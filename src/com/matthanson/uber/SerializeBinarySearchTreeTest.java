package com.matthanson.uber;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Matt on 9/27/16.
 */
public class SerializeBinarySearchTreeTest {
    @Test
    public void serialize() throws Exception {
        SerializeBinarySearchTree.Node root = new SerializeBinarySearchTree.Node();
        root.val = 30;

        root.left = new SerializeBinarySearchTree.Node();
        root.left.val = 15;

        root.left.left = new SerializeBinarySearchTree.Node();
        root.left.left.val = 10;

        root.left.right = new SerializeBinarySearchTree.Node();
        root.left.right.val = 20;

        root.right = new SerializeBinarySearchTree.Node();
        root.right.val = 100;

        SerializeBinarySearchTree serializer = new SerializeBinarySearchTree();
        List<Integer> serialized = serializer.serialize(root);
        assertEquals(Arrays.asList(new Integer[]{30, 15, 10, null, null, 20, null, null, 100, null, null}), serialized);
    }

    @Test
    public void deserialize() {
        SerializeBinarySearchTree deserializer = new SerializeBinarySearchTree();
        assertNull(deserializer.deserialize(null));
        assertNull(deserializer.deserialize(new LinkedList<>()));

        List<Integer> list = new LinkedList<>();

        list.add(null);
        assertNull(deserializer.deserialize(list));

        list = Arrays.asList(new Integer[]{30, 15, 10, null, null, 20, null, null, 100, null, null});
        SerializeBinarySearchTree.Node root = deserializer.deserialize(list);
        assertNotNull(root);
        assertEquals(30, root.val);
        assertEquals(15, root.left.val);
        assertEquals(10, root.left.left.val);
        assertEquals(20, root.left.right.val);
        assertEquals(100, root.right.val);
    }

}