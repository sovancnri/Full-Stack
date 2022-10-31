package MutabilityvsImmutability;

public class TestMutabilityvsImmutability {
    public static void main(String[] args) {

        String nameone = "Sandeep";
        String nametwo = new String("Rohan");

        //This Belongs to Object class not string
        System.out.println(nameone.hashCode());
        System.out.println(nametwo.hashCode());
        System.out.println(nameone.equals(nametwo));

        StringBuilder a = new StringBuilder("10");
        StringBuilder b = new StringBuilder("10");

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
}
/*
Useful Classes :
Object
    _toString,hashcode,equal,wait,notify
SimpleDateFormat Class
Calender

 */