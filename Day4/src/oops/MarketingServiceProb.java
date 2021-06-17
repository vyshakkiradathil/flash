package oops;
class Client{
	private static String[] serviceAvailabilityArr= {"ProductLaunch","Rebranding","Sales","Branding"};
	private String clientName;
	private String serviceRequired;
	private int budget;
	
	public Client(String clientName,String serviceRequired,int budget) {
		this.clientName=clientName;
		this.serviceRequired=serviceRequired;
		this.budget=budget;
		
	}

	public String getServiceRequired() {
		return serviceRequired;
	}

	public int getBudget() {
		return budget;
	}
	public boolean validateClint() {
		return true;
	}
	public boolean validateService() {
		int flage=0;
		for(int i=0;i<serviceAvailabilityArr.length;i++) {
			if(this.serviceRequired.equalsIgnoreCase(serviceAvailabilityArr[i])) {
				flage=1;
			}
		}if(flage==1)
			return true;
		else 
			return false;
	}
}
abstract class MarketingService{
	private static int counter=100;
	private Client client;
	private int timeFrame;
	private String serviceId;
	private double totalAmount;
	
	public MarketingService(Client client,int timeFrame) {
		this.client=client;
		this.timeFrame=timeFrame;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Client getClient() {
		return client;
	}

	public int getTimeFrame() {
		return timeFrame;
	}
	public void genarateServiceId() {
		char id=this.getClient().getServiceRequired().toUpperCase().charAt(0);
		String idd=Character.toString(id);
		this.setServiceId(idd + ++counter);
	}
	public Integer identifyDiscountPercentage() {
		Integer discountPercentage=0;
		if(this.timeFrame<3) {
			discountPercentage=0;
		}else if(this.timeFrame>=3 && this.timeFrame<=6) {
			discountPercentage=5;
		}else if(this.timeFrame>=7 && this.timeFrame<=12 ) {
			discountPercentage=10;
		}else if(this.timeFrame>13) {
			discountPercentage=20;
		}return discountPercentage;
	}
	abstract public void calculateTotalAmount();
}
class DigitalMarketing extends MarketingService{
	private static String[] digitalServicesArr= {"BW","IV","MA","SMH","CM"};
	private static int[] digitalServiceCostArr= {500,350,400,750,650};
	private String[] reqServiceTypeArr;
	
	public DigitalMarketing(Client client,int timeFrame,String[] reqServiceTypeArr) {
		super(client,timeFrame);
		this.reqServiceTypeArr=reqServiceTypeArr;
	}
	@Override
	public void calculateTotalAmount() {
		int costPerMonth=0;
		int initialCost=0;
		double totalCost=0;
		if(this.getClient().validateService() && this.getClient().validateService()) {
			for(int i=0;i<digitalServicesArr.length;i++) {
				for(int j=0;j<this.reqServiceTypeArr.length;j++) {
					if(digitalServicesArr[i].equalsIgnoreCase(this.reqServiceTypeArr[j])) {
						costPerMonth+=digitalServiceCostArr[i];
						initialCost=costPerMonth;
					}
				}
			}
			int serviceCost=initialCost*this.getTimeFrame();
			if(serviceCost!=0 && serviceCost<=this.getClient().getBudget()) {
				int discountPercentage=this.identifyDiscountPercentage();
				this.genarateServiceId();
				totalCost=serviceCost-(serviceCost*discountPercentage/100);
				this.setTotalAmount(totalCost);
				
			}else {
				this.setServiceId("NA");
				this.setTotalAmount(-1.0);
			}
		}else {
			this.setServiceId("NA");
			this.setTotalAmount(-1.0);
		}
			
	}
	
}
public class MarketingServiceProb {
	public static void main(String args[]){
		Client c1=new Client("Datasys.Co","sales",20000);
		String[] reqServiceTypeArr= {"BW","MA","SMH"};
		DigitalMarketing d1=new DigitalMarketing(c1,8,reqServiceTypeArr);
		d1.calculateTotalAmount();
		System.out.println("Servive ID: "+d1.getServiceId());
		System.out.println("Total Amount : "+d1.getTotalAmount());
		
		}

}
