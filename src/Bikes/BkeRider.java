package Bikes;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class BkeRider {

	// ========== main ==========
	public static void main(String[] args) throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException{
		ChildBike test = new ChildBike(true, true, 20, 3, 230, "NVidia", null);
		
		
		test.ringTheBell();
		
	}// main

}// class
