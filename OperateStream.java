package Java8.Exercise;

import java.util.DoubleSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OperateStream {
    private static void runMap(){
        DoubleStream.of(1.5,1.6,1.8).map(Math::cos).forEach(System.out::println);
    }
    private static void runFlatMap(){
        IntStream.range(1,10).flatMap(n-> IntStream.of(n,n*n)).forEach(System.out::println);
    }
    private static void runPeek(){
        Double sum =IntStream.rangeClosed(1,5).peek(System.out::println).filter(n->n%2==1).peek(x->System.out.println("Filtered integer: "+x))
                .mapToDouble(Math::sqrt)
                .peek(x->System.out.println("Mapped integer: "+x)).sum();
        o(sum);
    }
    private static void o(Object o){
        System.out.println("====================");
        System.out.println(o);

    }
    private static void runReduce(){
        int sum = IntStream.rangeClosed(1,5)
                .reduce(10,(left,right)->left + right);
        o(sum);
    }
    private static void runStat(){
        DoubleSummaryStatistics stats = new DoubleSummaryStatistics();
        stats.accept(100.0);
        stats.accept(300.0);
        stats.accept(1230.2);
        stats.accept(1001.34);
        long count = stats.getCount();
        double sum = stats.getSum();
        double average = stats.getAverage();
        double min = stats.getMin();
        double max = stats.getMax();
        System.out.printf("count = %d, sum = %.2f, max = %.2f, min = %.2f, average = %.2f%n",count,sum,max,min,average);

    }
    public static void main(String[] args) {
        runMap();
        runFlatMap();
        runPeek();
        runReduce();
        runStat();
    }
}
