package oops;
class Customer3{
	int custId;
	String custName;
	int discount=100;
	Customer3(){
		System.out.println("Parameterless constructor");
	}
	Customer3(int id,String name){
		this.custId=id;
		this.custName=name;
	}
	public int calculateval(int n) {
		return n+10;
	}
}
class RegularCustomer1 extends Customer3{
	int discount;
	RegularCustomer1(int  id,String name,int discount){
		super(id,name);
		this.discount=discount;
	}
	@Override
	public int calculateval(int val) {
	    int discountval=super.discount;
	    System.out.println(discountval);
	    int num=super.calculateval(val);
	    return num;
	    }
	    public void method1() {
	        System.out.println("Method1");
	    }
	}
	

public class MethodOverRiddingSam2 {
	public static void main(String[] args) {
	    RegularCustomer1 rg=new RegularCustomer1(101,"Rahul",1000);//
	    System.out.println(rg.calculateval(50));    
	}

}
