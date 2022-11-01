package Stream_API;

@FunctionalInterface
interface MySample{
    void doTask();
}
@FunctionalInterface
interface MyFactory{
    Employee getEmployee();
}
class Employee{
    static void performtask(){
        System.out.println("Employee performing task");
    }
    void anytask(){
        System.out.println("Employee performing any task");
    }

}

public class TestMethodRef {
    public static void main(String[] args) {
        // 1.Static Method Reference
        // Syntax: ClassName::methodName
        MySample mySample = Employee::performtask;//Body of perform task gets inside doTask
        MySample obj = () -> Employee.performtask();    //Lambda Method
        mySample.doTask();  //Executes here
        obj.doTask();

        // 2. Instance Method Reference
        Employee empobj = new Employee();
        MySample mySample1 = empobj::anytask; // Non Static function

        //3. Constructor Method Reference
        MyFactory myFactory = new MyFactory() {
            @Override
            public Employee getEmployee() {
                return new Employee();
            }
        };
        System.out.println("Functional Interface getEmployee returning Employee obj reference");
        //Employee empobj2 = myFactory.getEmployee();
        //empobj2.anytask();
        myFactory.getEmployee().anytask();//Same as line 43 and 44

        System.out.println("Constructor Method Reference");
        //Syntax : ClassName ::new
        MyFactory myFactory1 = Employee::new; //Will run line 38
        myFactory1.getEmployee().anytask();
    }
}
