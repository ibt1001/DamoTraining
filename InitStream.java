package Java8;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InitStream {
    private static Stream<String> initByBuilder(){
        Stream<String> stream = Stream.<String>builder().add("web").add("lala").add("df").build();
        return stream;
    }

    private static Stream<String> initByCollection(){
        Set<String> names = new HashSet<>();
        names.add("Java");
        names.add("kaka");
        names.add("lala");
        return names.stream();
    }

    public static void main(String[] args) {
        Stream<String> stream = initByBuilder();
        stream.forEach(System.out::println);
        Stream<String> stream1 = initByCollection();
        stream1.forEach(System.out::print);
        Stream<String> stream2 = Stream.empty();
        stream2.forEach(System.out::println);
        IntStream stream3 = IntStream.rangeClosed(1,6);
        stream3.forEach(System.out::println);
        Stream<String> stream5 = Stream.of("we are dharma");
        stream5.forEach(System.out::println);
        Stream<String> stream6 = Stream.of("we","are","dharma");
        stream6.forEach(System.out::println);
        String [] array = {"we","are","dhrama"};
        Stream<String>stream7 = Stream.of(array);
        stream7.forEach(System.out::println);
        IntStream stream8 = IntStream.generate(()->new Random().nextInt());
        stream8.limit(10).forEach(System.out::println);


    }
}
