package Optional_Class;

import java.util.Optional;

public class Optional_Class {
    public static void main(String[] args) {
        //Optional class is being introduced in java 8 to address the
        // problem of NullPointerException
        String username = new String("sunny");
        //String username = null;

        //if(username.equals(null) //compares the hashcode(cell reference) requires heap allocation
//        if(username == null) {     //Compares the content of the cell
//            System.out.println(username);
//        }else{
//            System.out.println("Null is in there as an object reference");
//        }
        Optional<String> optional= Optional.ofNullable(username);

        System.out.println(optional.isEmpty()); //Check Whether null or not
        //System.out.println(optional.get());     //Get whats inside the object
        // if null throws compile time error
        System.out.println(optional.orElse("No Object refernce"));  //If empty print this, if not prints the object
        //Doesn't gives compilation error
    }
}
/*
Optional is like a box; It store two states i.e, whether object has
been created
 */