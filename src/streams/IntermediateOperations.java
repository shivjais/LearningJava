package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//intermediate operations are laze operation
//that is they will not invoke/called until terminal operation is invoked on stream
public class IntermediateOperations {
    public static void main(String[] args) {
        //filter(): filters the element
        Stream<String> nameStream = Stream.of("HELLO", "EVERYBODY", "HOW", "ARE", "YOU");
        List<String> filteredList = nameStream.filter((name) -> name.length() >= 3).toList();
        System.out.println("filtered list: " + filteredList);

        //map(): used to transform each element
        nameStream = Stream.of("HELLO", "EVERYBODY", "HOW", "ARE", "YOU");
        List<String> mapList = nameStream.map(String::toLowerCase).toList();
        System.out.println("map list: " + mapList);

        //flatten map: Iterate over complex collection & flatten it
        List<List<String>> sentenseList = Arrays.asList(
                Arrays.asList("I","LOVE","JAVA"),
                Arrays.asList("CONCEPTS","ARE","CLEAR"),
                Arrays.asList("ITS","VERY","EASY")
        );

        List<String> flattenList = sentenseList.stream().flatMap(sentence -> sentence.stream().map(String::toLowerCase)).toList();
        System.out.println("flatten list: " + flattenList);

        //distinct(): removes duplicates
        Integer[] integers = {1,5,2,7,7,4,2,9};
        List<Integer> distinctList = Arrays.stream(integers).distinct().toList();
        System.out.println("distinct list: " + distinctList);

        //sorted(): sort the list
        List<Integer> sortedInAscList = Arrays.stream(integers).sorted().toList();
        System.out.println("sortedInAsc list: " + sortedInAscList);

        List<Integer> sortedInDscList = Arrays.stream(integers).sorted((val1,val2)->val2-val1).toList();
        System.out.println("sortedInDscList list: " + sortedInDscList);

        //peek(): to see the result to intermediate stream which is getting processed
        List<Integer> peekList = Arrays.stream(integers)
                .filter(val -> val > 2)
                .peek(System.out::println)
                .map(val -> val * -1).toList();
        System.out.println("peek list: " + peekList);

        //limit(): truncate the stream, have no longer than given maxSize
        List<Integer> limitList = Arrays.stream(integers).limit(3).toList();
        System.out.println("limit list: " + limitList);

        //skip(): skip first n elements of stream
        List<Integer> skipList = Arrays.stream(integers).skip(3).toList();
        System.out.println("skip list: " + skipList);

        //mapToInt(): helps to work with "int" data type
        List<String> nums = List.of("1","2","3","4","5");
        IntStream intStream = nums.stream().mapToInt(Integer::parseInt);
        int[] numArray = intStream.toArray();
        System.out.println("numArray: " + Arrays.toString(numArray));

        int[] numArr = {2,1,4,7};
        IntStream numberStream = Arrays.stream(numArr); //Arrays.stream() returns IntStream if int[] is passed
        int[] filteredArray = numberStream.filter(val -> val > 2).toArray();
        System.out.println("filteredArray: " + Arrays.toString(filteredArray));

        //similarly we can use mapToLong() & mapToDouble()

    }
}
