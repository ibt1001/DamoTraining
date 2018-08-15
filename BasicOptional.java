package Java8.Exercise;

import java.io.InputStream;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class BasicOptional {
    private static void o(Object o){
        System.out.println(o);
    }
    private static void optionalStream(){
        OptionalInt maxOdd = IntStream.of(10,20,30,40).filter(n->n%2 ==1)//Optional是存一个结果，优雅处理NullPointException
                .max();
        if(maxOdd.isPresent()){
            o(maxOdd.getAsInt());
        }else {
            o("Stream is null");
        }
    }
    public static void main(String[] args) {
        Optional<String> empty = Optional.empty();
        o(empty);
        Optional<String> str = Optional.of("ashton");
        o(str.get());
        o(str);
        String nullstring  =null;
        Optional<String> nullstr = Optional.ofNullable(nullstring);
        o(nullstr);
        OptionalInt number = OptionalInt.of(2018);
        if(number.isPresent()){
            o(number.getAsInt());
        }else {
            o("number empty");
        }
        optionalStream();

    }
}
