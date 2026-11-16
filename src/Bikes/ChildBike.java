package Bikes;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class ChildBike extends Bike {
	// ========== Attributes ===========
	private boolean additionalTires, bell;
	
	
	
	
	
	// ========== Constructor ==========
	public ChildBike(boolean additionalTires, boolean bell, double tireD, int chairPoz, double price, String Producer, String way) {
		super(tireD, chairPoz, price, Producer, way);
		this.additionalTires = additionalTires;
		this.bell = bell;
	}// ChildBike

	
	
	
	
	// ========== addTiresInteraction ==========
	public void addTiresInteraction(boolean action) {
		if(action && !additionalTires) {
			additionalTires = true;
			JOptionPane.showMessageDialog(null, "Additional tires were added!", "Information", JOptionPane.INFORMATION_MESSAGE);
		} else if(!action && additionalTires){
			additionalTires = false;
			JOptionPane.showMessageDialog(null, "Additional tires were taken out!", "Information", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Action is not possible!", "Information", JOptionPane.INFORMATION_MESSAGE);
		}// if{...}else if{...else}
	}// addTiresInteraction
	
	
	
	// ========== ringTheBell ==========
	public void ringTheBell() throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException{
		if(isbell()) {
			File f = new File("SFX" + File.separator + "ring.wav");
			AudioInputStream ais = AudioSystem.getAudioInputStream(f.getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		} else {
			JOptionPane.showMessageDialog(null, "The bell is not available!", "Error", JOptionPane.ERROR_MESSAGE);
		}// if...else
	}// ringTheBell
	
	
	
	// ========== isbell ==========
	public boolean isbell() {
		return bell;
	}// isbell
	
	// ========== isAddTire ==========
	public boolean isAddTire() {
		return additionalTires;
	}// isAddTire
	
	
	
	// ========== print ==========
			public String print() {
				return "Bike's producer: " + determineProducer()
				+"\nTire's price: " + determinePrice() + " EUR"
				+"\nTire's diameter: " + determineDiameter()
				+"\nChair's pozition: " + determinePoz()
				+"\nMovement speed: " + determineMoveSpeed() + "m/s\n"
				+"\nAdditional tires: " + ((additionalTires) ? "Is" : "N/A" + "\n")
				+"\nBell: " + ((bell) ? "Is" : "N/A" + "\n");
			}// print
	
}// class 
