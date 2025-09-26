package SequencedCollections;

import java.util.*;

public class SequenceSetDemo {
    public static void main(String[] args) {
        //linkedHashSet uses doubly linked list internally
        //follows insertion order
        SequencedSet<String> linkedHashSet = new LinkedHashSet<>(List.of("b","c","d"));
        linkedHashSet.addFirst("a");
        linkedHashSet.addLast("e");
        linkedHashSet.addLast("a"); //because it is set when we try to add same element again it move the element at desired position
        linkedHashSet.addLast("f");
        System.out.println("linkedHashSet: " + linkedHashSet);
        System.out.println("First Element from linkedHashSet: " + linkedHashSet.getFirst());
        System.out.println("Last Element from linkedHashSet: " + linkedHashSet.getLast());
        System.out.println("Removed Last from linkedHashSet: " + linkedHashSet.removeLast());
        System.out.println("Removed First from linkedHashSet: " + linkedHashSet.removeFirst());
        System.out.println("Reversed linkedHashSet: " + linkedHashSet.reversed());

        //follows sorted order
        SequencedSet<Integer> treeSet = new TreeSet<>(Set.of(14,5,7));
        //TreeSet follows sorted order hence adding element to first/last makes no sense
        // because new element might not be added at desired position due to sorting. Hence, we will get UnsupportedOperationException
        //treeSet.addFirst(1);
        //treeSet.addLast(2);
        //we can simply add element
        treeSet.add(1);
        treeSet.add(15);
        System.out.println("treeSet: " + treeSet);
        System.out.println("First Element from treeSet: " + treeSet.getFirst());
        System.out.println("Last Element from treeSet: " + treeSet.getLast());
        System.out.println("Removed Last from treeSet: " + treeSet.removeLast());
        System.out.println("Removed First from treeSet: " + treeSet.removeFirst());
        System.out.println("Reversed treeSet: " + treeSet.reversed());

    }
}
