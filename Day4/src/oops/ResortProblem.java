package oops;
class CustomerBooking{
	private static String[] availableMemberhipArr= {"Premium","Gold","Platinum"};
	private String custName;
	private String membershipType;
	private String custBookingId;
	private int stayDuration;
	
	public CustomerBooking(String custName,String membershipType,int stayDuration) {
		this.custName=custName;
		this.membershipType=membershipType;
		this.stayDuration=stayDuration;
		this.custBookingId=null;
	}

	public String getCustBookingId() {
		return custBookingId;
	}

	public void setCustBookingId(String custBookingId) {
		this.custBookingId = custBookingId;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public int getStayDuration() {
		return stayDuration;
	}
	public boolean validateCustMembership() {
		for(String membership:CustomerBooking.availableMemberhipArr) {
			if (this.membershipType.equals(membership)) {
				return true;
			}
		}return false;
	}
	
}
abstract class Resort{
	private static String[] roomTypeArr= {"Regular","Deluxe","Executive"};
	private static int[] roomCostArr= {1500,2500,3500};
	private static int counter =100;;
	private CustomerBooking custBooking;
	private String roomType;
	private double totalStayCost;
	
	public Resort(CustomerBooking custBooking,String roomType) {
		this.custBooking=custBooking;
		this.roomType=roomType;
	}

	public static String[] getRoomTypeArr() {
		return roomTypeArr;
	}

	public static int[] getRoomCostArr() {
		return roomCostArr;
	}
	

	public double getTotalStayCost() {
		return totalStayCost;
	}
	

	public void setTotalStayCost(double totalStayCost) {
		this.totalStayCost = totalStayCost;
	}

	public CustomerBooking getCustBooking() {
		return custBooking;
	}

	public String getRoomType() {
		return roomType;
	}
	public Integer identifyDiscountPercentage() {
		int discountPercentage=0;
		if(this.custBooking.getMembershipType().equalsIgnoreCase("Gold")) {
			if(this.roomType.equalsIgnoreCase("Executive")) {
				discountPercentage=10;
			}else if(this.roomType.equalsIgnoreCase("Deluxe")) {
				discountPercentage=8;
			}
		}else if(this.getCustBooking().getMembershipType().equalsIgnoreCase("Platinum")) {
			discountPercentage=15;
			
		}else 
			discountPercentage=0;
		return discountPercentage;
	}
	public void generateBookingId() {
		char id=this.roomType.toUpperCase().charAt(0);
		String idd=Character.toString(id);
		custBooking.setCustBookingId(idd+ (++counter));
		
		
	}
	
	abstract public void calculateTotalStayCost();
	
}
class LuxuryResort extends Resort{
	private static String[] luxuryServiceArr= {"Spa","Pool","Inroom-Dine"};
	private static int[] luxuryServiceCostArr= {800,500,400};
	private String viewType;
	private String[] reqLuxuryServiceArr;
	
	public LuxuryResort(CustomerBooking custBooking,String roomType,String viewType,String[] reqLuxuryServiceArr) {
		super(custBooking,roomType);
		this.viewType=viewType;
		this.reqLuxuryServiceArr=reqLuxuryServiceArr;
	}
	public Integer identifyLuxuryService() {
		int luxuryServiceCost=0;
		//Integer i=Integer.valueOf(luxuryServiceCost);
		if(luxuryServiceArr==null) {
			luxuryServiceCost=0;
		}
		for(int i=0;i<luxuryServiceArr.length;i++) {
			for(int j=0;j<reqLuxuryServiceArr.length;j++) {
				if(luxuryServiceArr[i].equalsIgnoreCase(reqLuxuryServiceArr[j])) {
					luxuryServiceCost+=luxuryServiceCostArr[i];
				}
			}
		}
		
	//	else if(reqLuxuryServiceArr.length==1) {
	//		if(reqLuxuryServiceArr[0]=="Spa")
	//			luxuryServiceCost=luxuryServiceCostArr[0];
	//		else if(reqLuxuryServiceArr[0]=="Pool")
	//			luxuryServiceCost=luxuryServiceCostArr[1];
	//		else if(reqLuxuryServiceArr[0]=="Inroom-Dine")
	//			luxuryServiceCost=luxuryServiceCostArr[2];
	//		else 
	//			luxuryServiceCost=0;
			
	//	}else if(reqLuxuryServiceArr.length==2) {
	//		if(reqLuxuryServiceArr[0].equalsIgnoreCase("Spa") && reqLuxuryServiceArr[1].equalsIgnoreCase("Pool")) {
	//			luxuryServiceCost=luxuryServiceCostArr[0]+luxuryServiceCostArr[1];
	//		}else if(reqLuxuryServiceArr[0].equalsIgnoreCase("Spa") && reqLuxuryServiceArr[1].equalsIgnoreCase("Inroom-Dine")) {
	//			luxuryServiceCost=luxuryServiceCostArr[0]+luxuryServiceCostArr[2];
	//		}else if(reqLuxuryServiceArr[0].equalsIgnoreCase("Pool") && reqLuxuryServiceArr[1].equalsIgnoreCase("Inroom-Dine")) {
	//			luxuryServiceCost=luxuryServiceCostArr[1]+luxuryServiceCostArr[2];
	//		}else
	//			luxuryServiceCost=0;
	//    }else if(reqLuxuryServiceArr.length==3) {
	//    	if(reqLuxuryServiceArr[0].equalsIgnoreCase("Spa") && reqLuxuryServiceArr[1].equalsIgnoreCase("Pool")&& reqLuxuryServiceArr[2].equalsIgnoreCase("Inroom-Dine")) {
	//    		luxuryServiceCost=luxuryServiceCostArr[0]+luxuryServiceCostArr[1]+luxuryServiceCostArr[2];
	//    	}else
	//    		luxuryServiceCost=0;
	//    }
		return luxuryServiceCost;
	    	
	}
	@Override
	public void calculateTotalStayCost() {
		double roomCostPerDay=0;
		double stayCost=0;
		double totalStayCost=0;
		if(this.getCustBooking().validateCustMembership()&&this.getCustBooking().getStayDuration()>0) {
			
			for(int ind=0;ind<3;ind++) {
				if(this.getRoomType().equalsIgnoreCase(LuxuryResort.getRoomTypeArr()[ind])) {
					
						System.out.println(LuxuryResort.getRoomTypeArr()[ind]);
						if(LuxuryResort.getRoomTypeArr()[ind].equalsIgnoreCase("Regular")) {
							 roomCostPerDay=1500;
							 
						}else if(LuxuryResort.getRoomTypeArr()[ind].equalsIgnoreCase("Deluxe")) {
							 roomCostPerDay=2500;
						}else if(LuxuryResort.getRoomTypeArr()[ind].equalsIgnoreCase("Executive")) {
							 roomCostPerDay=3500;
						}else 
							roomCostPerDay=-1;
				
					
				}
			}if(roomCostPerDay!=-1) {
				int discountPercentage=super.identifyDiscountPercentage();
				int luxuryServiceCost=this.identifyLuxuryService();
				stayCost=roomCostPerDay+luxuryServiceCost;
				//System.out.println(roomCostPerDay);
				if(viewType.equalsIgnoreCase("lake")) {
					stayCost+=500;
				}
                
				totalStayCost=stayCost*this.getCustBooking().getStayDuration();
				totalStayCost=totalStayCost-(totalStayCost*(discountPercentage)/100);
				
				super.generateBookingId();
			}else {
				this.getCustBooking().setCustBookingId("NA");
				totalStayCost=-1.0;
			}
			
			

		}else {
			this.getCustBooking().setCustBookingId("NA");
			totalStayCost=-1.0;
		}
		this.setTotalStayCost(totalStayCost);
			
	
		
	}
}
public class ResortProblem {
	public static void main(String args[]){
		CustomerBooking custOb=new CustomerBooking("John","Gold",3);
		String[] reqServices= {"Pool","Spa"};
		LuxuryResort luxuryResortOb=new LuxuryResort(custOb,"deluxe","lake",reqServices);
		luxuryResortOb.calculateTotalStayCost();
		System.out.println("Booking ID: "+custOb.getCustBookingId());
		System.out.println("Total Bill Amount : "+luxuryResortOb.getTotalStayCost());
		}

}
