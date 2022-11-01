//Abstract Class to use as Inner Class
abstract class BalanceComputer{
    double time = 1; //Fixed Time and Rate Of Interest
    double rate = 4;
    static BalanceComputer geBalanceComputer(char s){
        return new BalanceComputer(){
            @Override
            double getBalance() {
                if(s == 'S'){
                    Bl = Bl * (Math.pow(1 + (rate/400), (4 * time)));
                    return Bl;
                }
                if(s == 'C'){
                    Bl = Bl + (Bl * rate * time)/100;
                    return Bl;
                }
                return 0;
            }
        };
    }
    abstract double getBalance();
}
class BankAccount{
    long acct_number;
    char acct_type;
    String month_of_deposit;
    double Bl;
    BankAccount(long ac_no,char ac_t,String mnd){
        acct_number = ac_no;
        acct_type = ac_t;
        month_of_deposit = mnd;
        Bl = 0;
    }
    BalanceComputer tobj = new BalanceComputer() { //Creating Anonymous Class
        double getBalance().geBalanceComputer(acct_type);    
    };
    void deposit(double amt){
        Bl += amt;
        System.out.printf("Deposit Successfull.New Balance - %.2f"+Bl);
    }
    void withdraw(double amt){
        if(amt > Bl)
            System.out.println("Insufficient Funds");
        else{
            Bl -= amt;
            System.out.printf(amt+" is withdrawn.Remaining Balance- %.2f\n"+Bl);
        }
    }
}
class Test {
    public static void main(String[] args) {
        BankAccount obj = new BankAccount(78784, "S","June");
        obj.deposit(10000);
        System.out.println("Balance of "+obj.acct_number+" of "+obj.acct_type+" type is - "+obj.tobj.getBalance());
        obj.withdraw(600);
 }
}