package Collection_Framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Java Bean where all attributes are private and have all getters and setters
// Java Bean  ------> An Entity from Real Life
class Employee implements Comparable<Employee>{
    private String empname;
    private double empsalary;
    private int yoj;

    public Employee() {
        super();
    }

    public Employee(String empname, double empsalary, int yoj) {
        super();
        this.empname = empname;
        this.empsalary = empsalary;
        this.yoj = yoj;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
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

    @Override
    public String toString() {
        return "Employee{" +
                "empname='" + empname + '\'' +
                ", empsalary=" + empsalary +
                ", yoj=" + yoj +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return this.getYoj() - o.getYoj();
    }
}

class NameSort implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getEmpname().compareTo(o2.getEmpname());
    }
}

class SalarySort implements  Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        if(o1.getEmpsalary() < o2.getEmpsalary())
            return -1;
        else  if(o1.getEmpsalary() > o2.getEmpsalary())
            return 1;
        else
            return 0;
    }
}

public class TestComparableComapartor {
    public static void main(String[] args) {
        ArrayList<Employee> emcol = new ArrayList<>();

        emcol.add(new Employee("Mack Mohan",50000, 2015));
        emcol.add(new Employee("Rehan", 60000,2011));
        emcol.add(new Employee("Anik", 40000,2019));
        emcol.add(new Employee("Rehan", 30000,2017));

        System.out.println("Collection of employee object before any sort of sorting algo");
//        System.out.println(emcol);
        for(Employee tempobj :emcol){
            System.out.println(tempobj.getEmpname()+" "+tempobj.getEmpsalary()+" "+tempobj.getYoj());
        }
        System.out.println("Collection of employee object after sorting on yoj using compareTo");
        Collections.sort(emcol);
        for(Employee tempobj :emcol){
            System.out.println(tempobj.getEmpname()+" "+tempobj.getEmpsalary()+" "+tempobj.getYoj());
        }
        System.out.println("Collection of employee object after sorting on yoj using compareTo");
        Collections.sort(emcol);
        for(Employee tempobj :emcol){
            System.out.println(tempobj.getEmpname()+" "+tempobj.getEmpsalary()+" "+tempobj.getYoj());
        }

        System.out.println("Collection of employee object after sorting on Name using compare of Comparator");
        NameSort nameSort = new NameSort();
        Collections.sort(emcol,nameSort);
        for(Employee tempobj :emcol){
            System.out.println(tempobj.getEmpname()+" "+tempobj.getEmpsalary()+" "+tempobj.getYoj());
        }

        System.out.println("Collection of employee object after sorting on Salary using compare of Comparator");
        SalarySort salarySort = new SalarySort();
        Collections.sort(emcol,salarySort);
        for(Employee tempobj :emcol){
            System.out.println(tempobj.getEmpname()+" "+tempobj.getEmpsalary()+" "+tempobj.getYoj());
        }
    }
}