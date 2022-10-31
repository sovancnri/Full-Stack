package Generic;

//Generic Dont need overloading
//Function which data type neutral -> Generic in nature -> Type Safe code
//Write function is a way that it will become neutral to the datatype it will work for any data type
class Sample<T>{        //any alphabet called Placeholder not actual data type
    //not specifying any data type
//Place Holder are replacd with corresponding wrapper classes
//by JVM at the time of function call - Type Erasing
T ShowInfo(T info){
return info;
}
//    char ShowInfo(char Info){
//        return  Info;
//    }
//    String ShowInfo(String Info){
//        return Info;
//    }
//    int ShowInfo(int info){
//        return info;
//    }
}
public class TestGeneric {
public static void main(String[] args) {
Sample sone = new Sample();
System.out.println(sone.ShowInfo(new Character('A')));
System.out.println(sone.ShowInfo(new String("Rohan")));
System.out.println(sone.ShowInfo(new Integer(22)));
}
}
