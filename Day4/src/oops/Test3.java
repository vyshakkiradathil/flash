package oops;

public class Test3 {
	private static int var1=40;
	final int var3=40;
	private int var2=40;
	
	public Test3(int var2) {
		this.var2=var2;
		this.var2=++this.var2-var3;
		
		Test3.var1=Test3.var1--;
		Test3.var1--;
		
		
	}
	public int method1() {
		System.out.println(var1);
		System.out.println(var2);
		return Test3.var1+this.var2;
	}
	
	public static void main(String[] args) {
		
		Test3.var1--;
		Test3 obj1=new Test3(40);
		Test3 obj2=new Test3(30);
		System.out.println(obj1.method1()+obj2.method1());
		
		
	}

}
