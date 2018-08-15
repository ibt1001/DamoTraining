package Java8;

import java.util.function.Function;

public class Scope {
    private Scope(){
        Function<String,String> func = x->{
            System.out.println(this);   //this 指代Scope（）,调用Scope()的toString()方法
            return x;
        };
        Function<String,String> func1 = new Function<String, String>() {
            @Override
            public String apply(String s) {
                System.out.println(this);   //this 指代Function（），调用Function()的toString()方法
                return s;
            }
        };
        System.out.println(func.apply("Dharma"));
    }

    public static void main(String[] args) {
        new Scope();
    }
}
