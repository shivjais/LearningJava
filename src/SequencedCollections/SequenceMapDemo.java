package SequencedCollections;

import java.util.LinkedHashMap;
import java.util.SequencedMap;
import java.util.TreeMap;

public class SequenceMapDemo {
    public static void main(String[] args) {
        //follows insertion order
        SequencedMap<Integer,String> linkedMap = new LinkedHashMap<>();
        linkedMap.put(1,"a");
        linkedMap.put(2,"b");
        linkedMap.put(3,"c");
        System.out.println("LinkedHashMap: " + linkedMap);
        System.out.println("First Element from LinkedHashMap: " + linkedMap.firstEntry());
        System.out.println("Last Element from LinkedHashMap: " + linkedMap.lastEntry());
        linkedMap.putFirst(400,"d");
        linkedMap.putLast(500,"z");
        System.out.println("Removed Last from LinkedHashMap: " + linkedMap.pollFirstEntry());
        System.out.println("Removed First from LinkedHashMap: " + linkedMap.pollLastEntry());
        System.out.println("Reversed LinkedHashMap: " + linkedMap.reversed());

        //follows sorted order, sorted based on key
        SequencedMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(100,"b");
        treeMap.put(200,"c");
        treeMap.put(300,"d");
        treeMap.put(700,"e");
        treeMap.put(500,"f");
        //TreeMap follows sorted order hence adding element to first/last makes no sense
        // because new element might not be added at desired position due to sorting. Hence, we will get UnsupportedOperationException
        // treeMap.putFirst(400,"d");
        //treeMap.putLast(500,"z");
        System.out.println("TreeMap: " + treeMap);
        System.out.println("First Element from TreeMap: " + treeMap.firstEntry());
        System.out.println("Last Element from TreeMap: " + treeMap.lastEntry());
        System.out.println("Removed Last from TreeMap: " + treeMap.pollFirstEntry());
        System.out.println("Removed First from TreeMap: " + treeMap.pollLastEntry());
        System.out.println("Reversed TreeMap: " + treeMap.reversed());

    }
}
