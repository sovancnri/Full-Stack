package Collection_Framework;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestSetImpl {

    public static void main(String[] args) {

        Set<String> empcitycol = new HashSet<>();
        empcitycol.add("Kolkata");
        empcitycol.add("Delhi");
        empcitycol.add("Delhi");
        empcitycol.add("Baghdad");
        empcitycol.add("Zakarta");

        //System.out.println(empcitycol);
        //Linked Hash Set Order preserves
        //Sorts the set
        TreeSet<String> sortedcol = new TreeSet<>();
        sortedcol.addAll(empcitycol);

        //System.out.println(sortedcol);

        //To sort using custom logic
        //Comparable -> this.compareTo(obj2) and Comparator -> compare(obj1,obj2)

        sortedcol.forEach(System.out::println);

    }
}