package Collection_Framework;

import java.util.*;

public class TestListImpl {
    public static void main(String[] args) {
        ArrayList<String> empnamecol = new ArrayList<>();
        empnamecol.add(new String("Rohan"));
        empnamecol.add("Mack");
        empnamecol.add("Mini");
        empnamecol.add("Mack");
        empnamecol.add("Rehan");

        System.out.println(empnamecol.get(1));
        System.out.println(empnamecol);


        LinkedList<String> empcitycol = new LinkedList();
        empcitycol.add(new String("Rohan"));
        empcitycol.add("Mack");
        empcitycol.add("Mini");
        empcitycol.add("Mack");
        empcitycol.add("Rehan");


        for(String tempcol: empcitycol){
            System.out.println(tempcol+" belongs to NRI Fintech");
        }
        Vector<String> favsportcol = new Vector<>(2,3);

        System.out.println("At beginning the size of vector collection is "+favsportcol.size());
        System.out.println("The Initial Capacity is "+favsportcol.capacity());

        favsportcol.add("Cricket");
        favsportcol.add("Soccer");
        favsportcol.add("Hockey");
        favsportcol.add("Chess");

        System.out.println("After adding the size of vector is "+favsportcol.size());
        System.out.println("After adding 4 objects, the capacity is "+favsportcol.capacity());

//        Iterator<String> iterator = empnamecol.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        ListIterator<String> listIterator = empnamecol.listIterator(empnamecol.size());
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }

        Enumeration<String> enumeration = favsportcol.elements();

        while(enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }

        System.out.println("Accessing ArrayList Using foreach() from Java 8");

//        empnamecol.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });
        //empnamecol.forEach((s)->System.out.println(s));
        empnamecol.forEach(System.out::println);    //Method Reference doesn't needs the parameters

    }
}
