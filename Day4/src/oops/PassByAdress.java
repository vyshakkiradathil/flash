package oops;
class Sample {    
    int var;
    public void update(Sample obj) {
        System.out.println("Original inside update: "+obj.var);
        var += 5;
        System.out.println("Updated inside update: "+obj.var);
    }
}


public class PassByAdress {
	public static void main(String[] args) {
        Sample ob = new Sample();
        ob.var = 50;
        System.out.println("Original outside update: "+ob.var);
        ob.update(ob);
        System.out.println("Updated ouside update: "+ob.var);
    }
}



