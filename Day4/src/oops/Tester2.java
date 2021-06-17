package oops;

class PassByValue{
	public void update(int number) {
		System.out.println("original inside value" + number);
		number+=10;
		System.out.println("updated inside" +number);
		
	}
}
public class Tester2 {
	public static void main(String[] args) {
	    int num=25;
	    PassByValue c1=new PassByValue();
	    System.out.println("original outside" + num);
		c1.update(num);
		System.out.println("updated outside" + num);
	}

}
