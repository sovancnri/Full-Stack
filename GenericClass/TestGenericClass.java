package GenericClass;

class Sample<U,V>{
    U a;    //generic Global Variable
    V b;

    V setInfo(U infoone, V infotwo){
        a = infoone;
        b = infotwo;    //Local Generic Variable are assigned to global
        System.out.print(a);

        return b;
    }
}

public class TestGenericClass {
    public static void main(String[] args) {
    Sample<String,Integer> sobj = new Sample();
    System.out.println(sobj.setInfo(new String("Rohan"),new Integer(22)));

    Sample<Double,Character> sobj2 = new Sample();
    System.out.println(sobj2.setInfo(new Double(22.5),new Character('X')));

    }
}
