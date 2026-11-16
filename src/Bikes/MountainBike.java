package Bikes;

public class MountainBike extends Bike {
	// ========== Attributes ==========
	private int settedSpeed;
	private boolean spring;
	
	
	
	// ========== Constructor ==========
	public MountainBike(int settedSpeed, boolean spring, double tireD, int chairPoz, double price, String Producer, String way) {
		super(tireD, chairPoz, price, Producer, way);
		this.settedSpeed = settedSpeed;
		this.spring = spring;
	}// MountainBike

	
	
	
	
	// ========== Mountain bike's extended methods of superclass Bike ==========
	public int determineSpeed() {
		return settedSpeed;
	}
	//--------------------------------------------------------------------------
	public void switchSpeed(int spd) {
		settedSpeed = spd;
	}
	//--------------------------------------------------------------------------
	
	
	
	
	
	// ========== print ==========
		public String print() {
			return "Bike's producer: " + determineProducer()
			+"\nTire's price: " + determinePrice() + " EUR"
			+"\nTire's diameter: " + determineDiameter()
			+"\nChair's pozition: " + determinePoz()
			+"\nMovement speed: " + determineMoveSpeed() + "m/s\n"
			+"\nSetted speed: " + determineSpeed()
			+"\nAdditional amortization: " + ((spring) ? "Is" : "N/A" + "\n");
		}// print
	
}// class 
