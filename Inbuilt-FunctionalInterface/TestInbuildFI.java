

/*
class Animal{

}
class Reptile extends Animal{

}
ArrayList<T extends Animal>--------> T : Generic Type Parameters
//Compile Time

ArrayList<? extends Animal> --------> :Wild Card Parameters

 */


import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestInbuildFI {
    public static void main(String[] args) {
        Predicate<String> predicate = (s)-> {
                if(s == "mini")
                    return true;
                else
                    return false;
        };

        System.out.println(predicate.test("mini"));

        Consumer<String> consumer = (s)->System.out.println("The Info is "+s);
        consumer.accept("Sunny Dewal");

        Supplier<Double> supplier = ()->3.14;

        System.out.println("PI value is "+supplier.get());

        //First is data type of Incoming parameter second is the data type of return type
        Function<String,String> function = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toLowerCase();
            }
        };

        String info = function.apply("Rini");
        System.out.println(info);
    }
}
