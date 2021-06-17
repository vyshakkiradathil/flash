package oops;
class StudentRegistration{
	private static String[] vaillableCourseArr= {"AI","ML","CG"};
	private static int[] vailableCourseCostAr= {250,350,200};
	private String studentName;
	private String studentType;
	private long mobNumber;
	private String courseToRegister;
	
	public StudentRegistration(String studentName,String studentType,long mobNumber,String courseToRegister) {
		this.studentName=studentName;
		this.studentType=studentType;
		this.mobNumber=mobNumber;
		this.courseToRegister=courseToRegister;
	}

	public String getStudentType() {
		return studentType;
	}

	public String getCourseToRegister() {
		return courseToRegister;
	}
	public boolean validateMobNumber() {
		if((""+this.mobNumber).length()==10) {
			return true;
		}return false;
	}public int identifyPerDayCourseFee() {
		int feePerDay=0;
		
		if(this.courseToRegister.equalsIgnoreCase(vaillableCourseArr[0])) {
			feePerDay=vailableCourseCostAr[0];
			//System.out.println(feePerDay);
		}
		else if(this.courseToRegister.equalsIgnoreCase(vaillableCourseArr[1])) {
			feePerDay=vailableCourseCostAr[1];
		}else if(this.courseToRegister.equalsIgnoreCase(vaillableCourseArr[2])) {
			feePerDay=vailableCourseCostAr[2];
		}else
			feePerDay=-1;
		return feePerDay;
	}
	
}
abstract class Workshop{
	private static int counter=1000;
	private StudentRegistration studentReg;
	private int noOfDays;
	private String registrationID;
	private double totalFee;
	
	public Workshop(StudentRegistration studentReg,int noOfDays) {
		this.studentReg=studentReg;
		this.noOfDays=noOfDays;
		this.registrationID=null;
		this.totalFee=0.0;
	}

	public double getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}

	public StudentRegistration getStudentReg() {
		return studentReg;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public String getRegistrationID() {
		return registrationID;
	}
	
	public void setRegistrationID(String registrationID) {
		this.registrationID = registrationID;
	}

	public void generateRegistrationlD() {
		this.setRegistrationID(this.getStudentReg().getCourseToRegister()+ ++counter);
	}
	public int identifyWaveoffPercentage() {
		int waveoffPercentage=0;
		if(this.studentReg.getStudentType().equals("Member")) {
			waveoffPercentage=5;
		}else if(this.studentReg.getStudentType().equals("Volunteer")) {
			waveoffPercentage=10;
		}return waveoffPercentage;
	}
	abstract void calculateFee();
}
class EngineeringWorkshop extends Workshop{
	private String[] extraAmenitiesArr;
	private boolean softSkill;
	
	public EngineeringWorkshop(StudentRegistration studentReg,int noOfDays,String[] extraAmenitiesArr,boolean softSkill) {
		super(studentReg,noOfDays);
		this.extraAmenitiesArr=extraAmenitiesArr;
		this.softSkill=softSkill;
	}
	public Integer identyfyAdditionalCost() {
		Integer additionalCost=0;
		int cost1=0;
		int cost2=0;
		int cost=0;
		if(this.extraAmenitiesArr==null) {
			additionalCost=0;
		}else {
			for(int i=0;i<extraAmenitiesArr.length;i++) {
				
				if(this.extraAmenitiesArr[i].equals("Toolkit")) {
					cost2+=1500;
					//System.out.println(i);
				}else if(this.extraAmenitiesArr[i].equals("Video")) {
					cost1+=1000;
					
				}else 
					cost=0;
				
		    }additionalCost=cost1+cost2+cost;
			//System.out.println("Ad"+additionalCost);
			if(softSkill) {
		    	additionalCost+=800;
		    }
		//System.out.println("Ad cost"+additionalCost);
	   }return additionalCost;
    }
	@Override
	public void calculateFee() {
		int additionalCost=0;
		int waveoffercentage=0;
		int courseFee=0;
		int totalFee=0;
		int perDayCourseFee=this.getStudentReg().identifyPerDayCourseFee();
		boolean validate=this.getStudentReg().validateMobNumber();
		
		if(validate && perDayCourseFee!=-1 && this.getNoOfDays()>0) {
			this.generateRegistrationlD();
			additionalCost=this.identyfyAdditionalCost();
			waveoffercentage=this.identifyWaveoffPercentage();
			courseFee=this.getStudentReg().identifyPerDayCourseFee()*this.getNoOfDays();
			totalFee=courseFee+additionalCost;
			totalFee-=(totalFee*waveoffercentage/100);
			this.setTotalFee(totalFee);
		}else {
			this.setRegistrationID("NA");
			totalFee=-1;
			
		}
			

	}
}
public class WorkshopProb {
	public static void main(String[] args) {
		StudentRegistration stud1=new StudentRegistration("John","Volunteer",9836478769l,"AI");
		String[] extraAmenitiesArr= {"Toolkit","Video"};
		EngineeringWorkshop en1=new EngineeringWorkshop(stud1,10,extraAmenitiesArr,true);
		en1.calculateFee();
		System.out.println("RegisterationId: "+en1.getRegistrationID());
		System.out.println("Total Fee : "+en1.getTotalFee());
		

	}

}
