package Collection_Framework;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.BiConsumer;
import java.util.Properties;

public class TestMapImpl {
    public static void main(String[] args) {
        System.out.println("Semester Marks ");
        Map<String,Integer> semdetail = new HashMap<>();
        semdetail.put("Core Java",60);
        semdetail.put("DS",50);
        semdetail.put("Spring",80);
        semdetail.put("PHP",40);

        //System.out.println(semdetail.get("Core Java"));

//        semdetail.forEach(new BiConsumer<String, Integer>() {
//            @Override
//            public void accept(String s, Integer integer) {
//                System.out.println(s+"\t"+integer);
//            }
//        });
        //semdetail.forEach((k,v)-> System.out.println(k+"\t"+v));

        PriorityQueue<String> flicks = new PriorityQueue<>();
        flicks.add(new String("Titanic"));
        flicks.add(new String("Vertical Limit"));
        flicks.add(new String("Where Eagle Dare"));
        flicks.add(new String("Terminator"));

        System.out.println(flicks.peek());
        System.out.println(flicks.poll());
        flicks.forEach(System.out::println);

        System.out.println("Property Uses");
        Properties semdetail2 = new Properties();
        semdetail2.put("Core Java",60);
        semdetail2.put("DS",50);
        semdetail2.put("Spring",80);
        semdetail2.put("PHP",40);

        System.out.println(semdetail2);
    }
}