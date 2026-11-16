package Bikes;

import java.awt.Image;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Bike {
	// ========== Attributes ==========
	public int chairPoz;
	public double tireD, speedMS, price;
	public String Producer;
	ImageIcon image;
	Random rand = new Random();
	
	
	
	
	
	
	// ========== Constructor ==========
	public Bike(double tireD, int chairPoz, double price, String Producer, String way) {
		this.tireD = tireD;
		this.chairPoz = chairPoz;
		speedMS = movementSp();
		this.price = price;
		this.Producer = Producer;
		//image = makeAnImage(way);
	}// Bike
	
	
	
	
	
	
	// ========== movementSp ==========
	public double movementSp() {
		double distM = rand.nextDouble() * (1000 - 1) + 1;
		double timeS = rand.nextDouble() * (60-10) + 10;
		return Math.round(distM/timeS); // v = s/t
	}// movementSp
	
	
	
	
	
	
	// ========== makeAnImage ==========
	public ImageIcon makeAnImage(String way) {
		if(!way.endsWith(".png")) {
			way += ".png";
		}
		URL Resource = getClass().getResource("/image/" + way);
		if(Resource != null) {
			return new ImageIcon(new ImageIcon(Resource).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		} else {
			JOptionPane.showMessageDialog(null, "Can noot find any images: " + way, "Warning", JOptionPane.WARNING_MESSAGE);
			return null;
		}
	}// makeAnImage
	
	
	
	
	
	
	// ========== viewAnImage ==========
	public ImageIcon viewAnImage() {
		return image;
	}// viewAnImage
	
	
	
	
	
	
	// ========== Methods to determine attributes ==========
	public double determineDiameter() {
		return tireD;
	}
	//------------------------------------------------------
	public int determinePoz() {
		return chairPoz;
	}
	//------------------------------------------------------
	public String determineProducer() {
		return Producer;
	}
	//------------------------------------------------------
	public double determinePrice() {
		return price;
	}
	//------------------------------------------------------
	public double determineMoveSpeed() {
		return speedMS;
	}
	//------------------------------------------------------
	
	
	
	
	
	// ========== print ==========
	public String print() {
		return "Bike's producer: " + determineProducer()
		+"\nTire's price: " + determinePrice() + " EUR"
		+"\nTire's diameter: " + determineDiameter()
		+"\nChair's pozition: " + determinePoz()
		+"\nMovement speed: " + determineMoveSpeed() + "m/s\n";
	}// print
	
	
	
	
	
	// ========== Methods to change attributes ==========
	public void changePoz(int poz) {
		chairPoz = poz;
	}
	//---------------------------------------------------
	public void mities(int minienuQuan){
		speedMS += 0.15 * minienuQuan;
	}
	//---------------------------------------------------
	public void brake(int brake) {
		if(determineMoveSpeed() > 0) {
			speedMS -= (determineMoveSpeed() * 0.55) * brake;
		}// if
		if(determineMoveSpeed() < 0) {
			speedMS = 0;
		}// if
	}
	//---------------------------------------------------
	
	
	
	
}// class 
