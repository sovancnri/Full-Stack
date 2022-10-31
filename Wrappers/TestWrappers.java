//Wrapper Class In Java
package Wrappers;

public class TestWrappers {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(num);

        //Explicit Boxing -> Wrapping up primitive into its class object representation
        //Converting value type into refernce type info
        Integer numobjref = new Integer(num);
        //Explicit Unboxing  ----->Converting reference type int value type
        System.out.println(numobjref.intValue());

        int numone = Integer.parseInt(args[0]);
        int numtwo = Integer.parseInt(args[1]);
        int result = numone + numtwo;
        System.out.println("Summation is - "+result);

    }
}
/*
    Wrapppers(Refernce datatype of primitives)
Primitives -------->Wrappers
int ------>Integer
float ----->Float
char ------->Char

Boxing and Unboxing
    !_Explicit
    !_Implicit  or Auto --- Done by Compiler

    Boxing ---------->Converting Value type to refernce type (Wrapping Up)
    Unboxing -------> Converting reference into value (Unwrapping)
 */
