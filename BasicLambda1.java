package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class BasicLambda1 {
    private static boolean isPrime(int number){
//        if(number <2) return false;
 //       for(int i = 2;i<number;i++){
   //         if(number%i ==0){
     //           return false;
       //     }
       // }
       // return true;
        return number>1&& IntStream.range(2,number).allMatch(n->number%n!=0);
    }
    public static <list> int findSquareOfMaxOdd(List<Integer> numbers){
        return numbers.stream().filter(i ->i%2!=0)
                .filter(i->i>3)
                .filter(i ->i<100)
                .max(Comparator.naturalOrder())
                .map(i->i*i)
                .get();
    }
    private static void o(Object o){
        System.out.println(o);
    }

    public static void main(String[] args) {
        o(isPrime(22));
        List<Integer>numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(10,2,3,4,8,5,2,4,9));
        System.out.println(findSquareOfMaxOdd(numbers));
    }
}
