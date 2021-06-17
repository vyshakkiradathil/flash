package oops;
class Customer2{
    int custId;
    String custName;
    Customer2(){
        System.out.println("Parameterless Constructor");
    }
    Customer2(int id, String name){
        System.out.println("Parameterized Constructor");
        this.custId=id;
        this.custName=name;
    }
    //Overridden
    public void display() {
        System.out.println("Display method of Customer");
    }
}
class RegularCustomer extends Customer2{
    int discount;
    RegularCustomer(int id, String name, int discount){
    super(id,name);
    System.out.println("Parameterized Child Constructor");
    this.discount=discount;
    }
    public void display() {
    System.out.println("Display method of RegularCustomer");
    }
    
    public void method1() {
        System.out.println("Methdo1");
    }
}
public class MethodOverRig {
	public static void main(String[] args) {
	    Customer2 rg=new RegularCustomer(101,"Rahul",1000);//
	    rg.display();
	    //rg.method1();
	    
	}

}
