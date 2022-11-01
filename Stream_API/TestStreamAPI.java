package Stream_API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee{
    private String ename;
    private double empsalary;
    private int yoj;
    private List<String> projects;

    public Employee() {
        super();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ename='" + ename + '\'' +
                ", empsalary=" + empsalary +
                ", yoj=" + yoj +
                ", projects=" + projects +
                '}';
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getEmpsalary() {
        return empsalary;
    }

    public void setEmpsalary(double empsalary) {
        this.empsalary = empsalary;
    }

    public int getYoj() {
        return yoj;
    }

    public void setYoj(int yoj) {
        this.yoj = yoj;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }

    public Employee(String ename, double empsalary, int yoj, List<String> projects) {
        super();
        this.ename = ename;
        this.empsalary = empsalary;
        this.yoj = yoj;
        this.projects = projects;
    }
}
// Stream API -> foreach(),filter(),collector

public class TestStreamAPI {

    static List<String> projects;
    static List<Employee> emplist;

    static {
        List<String> project1list = new ArrayList<>();
        project1list.add("Payment Module");

        List<String> project2list = new ArrayList<>();
        project2list.add("Payment Module");
        project2list.add("Cart Module");

        List<String> project3list = new ArrayList<>();
        project3list.add("Payment Module");
        project3list.add("Cart Module");
        project3list.add("whishlist Module");

        Employee empone = new Employee("Shreya", 50000,2019,project1list);
        Employee emptwo = new Employee("Ujan", 70000,2020,project2list);
        Employee empthree = new Employee("Saad", 80000,2021,project3list);

        emplist = new ArrayList<Employee>();
        emplist.add(empone);
        emplist.add(emptwo);
        emplist.add(empthree);

    }

    public static void main(String[] args) {


//        System.out.println("Retrieving All the Details");
//        for(Employee empobj: emplist){
//            System.out.println(empobj);
////            System.out.println(empobj.getEname()+" "+empobj.getEmpsalary()+" "+empobj.getProjects());
//        }
        emplist.stream().forEach(System.out::println);

//        emplist.stream().forEach(empobj -> System.out.println(empobj));

//        Providing 20% hike in salary of each employee
        /*emplist.stream()
                .filter(empobj -> empobj.getEmpsalary() > 60000)
                .map(empobj ->empobj.getEmpsalary()*1.2)
                .forEach(System.out::println);*/

        // Retrieve unified list of projects (single list in String) assigned to each employee
        String unifiedprojectlist = emplist.stream()
                .map(empobj -> empobj.getProjects())
                .flatMap(string -> string.stream())
                .collect(Collectors.joining(","));
        System.out.println(unifiedprojectlist);


        /*List<Integer> listnum = List.of(2,4,5,7,8,8);
        List<Integer> evennum = new ArrayList<>();

        System.out.println("Collecting even Numbers from list from Stream API");
        Stream<Integer> stream = listnum.stream();

        stream.filter(num -> num%2 == 0)            //Intermediate Operation
                .collect(Collectors.toSet())        //Intermediate Operation
                .forEach(System.out::println);  //Method reference

        stream.filter(num-> num%2 == 0).filter(e -> e%4 == 0).forEach(System.out::println); //Multiple Filter

        stream.filter(num -> num%2 == 0)
                .collect(Collectors.toSet())
                .forEach(num -> System.out.println(num));


        stream.filter(num -> num%2 == 0)
                .collect(Collectors.toList())
                .forEach(num -> System.out.println(num));//Terminal Operation


        stream.filter(num->num%2==0).forEach(num -> System.out.print(num+"\t"));

        stream.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer num) {
                if(num % 2 == 0)
                    evennum.add(num);
            }
        });
        System.out.println(evennum);
        List<Integer> list2 = new ArrayList<>();
        list2.add(55);
        list2.add(88);

        List<Integer> list3 = Arrays.asList(55,66,88,99);

        Working with list without Stream API
        for(Integer num : listnum){
            if(num % 2 == 0){
                evennum.add(num);
            }
        }
        System.out.println("Even List from existing List");
        System.out.println(evennum);*/
    }
}
/*
Stream API is library of classes and interfaces for performing operations on
 collections of objects maintained by Collection Framework; For this we need to
convert the collection of object into stream of objects anf there after we can use
stream api support to perform desired operation.class

Stream API support provide two different kind of methods :
1. Intermediate Operation i.e, Output of one method becomes the input for second method
    in the chain of method invocation or in method pipeline
    e.g, filter(),map(), flatmap()

2. Terminal Operation i.e it finally terminates the whole stream api operations with certain
desired output; last one to call
e.g, foreach(),collect(Collector.toList or toSet)

 */