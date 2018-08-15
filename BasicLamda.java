package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.IntFunction;
import java.util.function.LongFunction;
import java.util.function.Predicate;

public class BasicLamda {
    public static int sumWithCondition(List<Integer> numbers, Predicate<Integer>predicate){
        int sum = 0;

//        Iterator<Integer>itm = numbers.iterator();
//        while (itm.hasNext()){
//            int current = itm.next();
//            if(predicate.test(current)){
//                System.out.println(current);
//                sum+=current;
//            }
//        }
//return sum;
        return numbers.parallelStream().filter(predicate).peek(System.out::println).mapToInt(i->i).sum();
    };

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(10,9,8,7,6,5,4,3,2,1,3));
        System.out.println(sumWithCondition(numbers,i->i%2 ==0));
  //      IntFunction <Integer> sumInt = new IntFunction<Integer>() {
    //        @Override
      //      public Integer apply(int value) {
        //        return x->x<=0?0:sumInt.apply();
          //  }
        };

    //}
  //  LongFunction<Integer>sumLong

}
