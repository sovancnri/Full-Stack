package Functional Interface;


import javax.swing.*;

//Functional Interface - It hosts one and only one abstract methods
//but can have multiple default and static method -> Java 8 onwards
@FunctionalInterface
interface MyFunctionalInterface{
    void method1();

    default void method3(){         //Default works differently In case of FI
        System.out.println("Default m3 of My Functional Interface");
    }
    default void method4(){
        System.out.println("Default m4 of My Functional Interface");
    }
    static void method5(){
        System.out.println("Static m5 My Functional Interface");
    }
}
class Child implements MyFunctionalInterface{
    public void method1(){
        System.out.println("m1 is Overidden in Child");
    }
    public void method3(){
        System.out.println("m3 the default method of parent also got defined in Child");
        MyFunctionalInterface.super.method3();
    }
}
@FunctionalInterface
interface Calculator{
    int Sum(int a,int b);
}
public class FI_lambda {
    public static void main(String[] args) {
        Child ch = new Child();

        ch.method1();
        ch.method3();
        ch.method4();

        MyFunctionalInterface.method5();

        System.out.println("Using anonymous Class  Syntax");
        MyFunctionalInterface cone = new MyFunctionalInterface() {
            @Override
            public void method1() {
                System.out.println("abstract m1 of FI got defined using Anonymous Class");
            }
        };
        cone.method1();

        System.out.println("Using Anonymous method or lambda Expression");
        MyFunctionalInterface ctwo = ()->System.out.println("abstract m1 of FI got defined using Anonymous Method or Lambda Expression");
        ctwo.method1();

        System.out.println("Use of Lamda Expression");

        Calculator calc = new Calculator() {
            @Override
            public int Sum(int a, int b) {
                return a+b;
            }
        };
        int res = calc.Sum(3,4);
        System.out.println("Summation Using the syntax of Anonymous Class - "+res);

        Calculator calc2 = ( a, b) -> a*b;

        res = calc2.Sum(3,4);
        System.out.println("Summation using Anonymous Method "+res);

        Runnable empth = ()->{
            for(int start = 0; start <5;start++)
                System.out.println("Emp thread prints"+ start);
        };
        Thread t1 = new Thread(empth);
        t1.start();
    }
}
