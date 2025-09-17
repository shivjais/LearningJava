package streams;

import java.util.Arrays;
import java.util.List;

//helps to perform operation on streams concurrently
//it uses "spilerator" function to split the data into multiple chunks & it uses Fork-join pool technique
public class ParallelStream {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //sequential processing
        long seqStart = System.currentTimeMillis();
        numbers.stream().map(val -> val * val).forEach(System.out::println);
        System.out.println("Sequential processing time taken: "+(System.currentTimeMillis()-seqStart)+" ms");

        //parallel processing
        long parallelStart = System.currentTimeMillis();
        numbers.parallelStream().map(val -> val * val).forEach(System.out::println);
        System.out.println("Parallel processing time taken: "+(System.currentTimeMillis()-parallelStart)+" ms");
    }
}
