package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Note: one terminal operation is used in stream because it consume/close the stream & can't use for another stream operation
public class TerminalOperations {
    public static void main(String[] args) {
        //forEach(): perform an action on each element of stream & don't return any value
        List<Integer> numberList = List.of(2,1,4,7,10);
        numberList.stream().filter(val->val>2).forEach(System.out::println);

        //toArray(): Collects elements of stream into array
        Object[] array = numberList.stream().filter(val -> val>2).toArray();
        System.out.println("objectArray: "+ Arrays.toString(array));


        //getting Integer[] instead of Object[]
        Integer[] integers = numberList.stream().filter(val -> val > 2).toArray((size) -> new Integer[size]);
        System.out.println("IntegerArray: "+ Arrays.toString(integers));

        //reduce(): does reduction on elements of stream. Perform associative aggregation function
        Optional<Integer> reduce = numberList.stream().reduce((i1, i2) -> i1 + i2);
        System.out.println("reduce: "+ reduce.get());

        //used to collect the elements of stream into list
        //we can also directly use .toList() on streams to collect the result into a list
        List<Integer> collectList = numberList.stream().filter(val -> val > 2).collect(Collectors.toList());
        System.out.println("collectList: "+ collectList);

        //min(): returns min element based on provided comparator
        Optional<Integer> minOptional = numberList.stream().filter(val -> val > 2)
                //.min((num1,num2)->num1-num2);
                .min(Comparator.comparingInt(num -> num));//this is same as above

        System.out.println("minOptional1: "+ minOptional.get());

        minOptional = numberList.stream().filter(val -> val > 2)
                .min((num1, num2) -> num2 - num1);
        System.out.println("minOptional2: "+ minOptional.get());

        //max(): returns max element based on provided comparator
        Optional<Integer> maxOptional = numberList.stream().filter(val -> val > 2)
                //.max((num1,num2)->num1-num2);
                .max(Comparator.comparingInt(num -> num));//this is same as above

        System.out.println("maxOptional1: "+ maxOptional.get());

        maxOptional = numberList.stream().filter(val -> val > 2)
                .min((num1, num2) -> num2 - num1);
        System.out.println("maxOptional2: "+ maxOptional.get());

        //count(): returns count of elements present in stream
        long count = numberList.stream().filter(val -> val > 2).count();
        System.out.println("count: "+ count);

        //anyMatch(): check if any value in stream match the given predicate & return boolean
        boolean anyMatch = numberList.stream().anyMatch(val -> val > 2);
        System.out.println("anyMatch: "+ anyMatch);

        //allMatch(): check if all value in stream match the given predicate & return boolean
        boolean allMatch = numberList.stream().allMatch(val -> val > 2);
        System.out.println("allMatch: "+ allMatch);

        //noneMatch(): check if none value in stream match the given predicate & return boolean
        boolean noneMatch = numberList.stream().noneMatch(val -> val < 0);
        System.out.println("noneMatch: "+ noneMatch);

        //findFirst(): find the first element of stream
        Optional<Integer> firstOptional = numberList.stream().findFirst();
        System.out.println("firstOptional: "+ firstOptional.get());

        //findAny(): find any random element of stream
        Optional<Integer> findAnyOptional = numberList.stream().filter(val -> val > 2).findAny();
        System.out.println("findAnyOptional: "+ findAnyOptional.get());


    }
}
