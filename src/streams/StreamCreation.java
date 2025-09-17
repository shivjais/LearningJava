package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreation {
    public static void main(String[] args) {
        //from Collection
        List<Integer> list = Arrays.asList(100, 200, 300, 400);
        Stream<Integer> listStream = list.stream();

        //From Array
        Integer[] integers = {3000,4000,5000};
        Stream<Integer> arrayStream = Arrays.stream(integers);

        //from stream.of
        Stream<Integer> integerStream = Stream.of(2000, 6000, 500, 800);

        //from stream builder
        Stream.Builder<Integer> builder = Stream.builder();
        builder.add(100).add(200).add(300);
        Stream<Integer> build = builder.build();

        //from Stream iterate
        Stream<Integer> streamIterate = Stream.iterate(1000, (n) -> n + 1000).limit(3);
    }
}
