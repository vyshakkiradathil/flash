package oops;
class Customer{
	public String customerName;
	public long contactNumber;
	public String address;
	public int customerId;
	
	public Customer(String customerName,long contactNumber,String address) {
		this.customerName=customerName;
		this.contactNumber=contactNumber;
		this.address=address;
	
	}
    public void	displayCustomerDetails(){
    	System.out.println("Displaying Customer Details");
    	System.out.println("Customer Id"+ customerId);
    	System.out.println("Customer Name"+customerName);
    	System.out.println("Address"+address);
    	
		
	}
}
public class Tester4 {
	public static void main(String[] argsd) {
		Customer c1=new Customer("Jacob",5648394590l,"13th street,New York");
		c1.displayCustomerDetails();
		 
		
	}

}
