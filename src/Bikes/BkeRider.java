package Bikes;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class BkeRider {

	// ========== main ========== // 
	public static void main(String[] args) throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException{
		ChildBike test = new ChildBike(true, true, 20, 3, 230, "NVidia", null);
		
		
		//test.ringTheBell();
		String chose;
		int choiceIndex;
		String[] actions = {"New bike", "Bike list", "Methods", "Close"};
		String[] type = {"Bike", "Mountain bike", "Bike for kids"};
		String[] answer = {"Yes", "No"};
		Object[] bikes = new Object[100];
		
		do {
			chose = (String)JOptionPane.showInputDialog(null, "Choose", "dwa", JOptionPane.QUESTION_MESSAGE, null, actions, actions[0]);
			
			choiceIndex = Arrays.asList(actions).indexOf(chose);
			
			if(choiceIndex == -1) {
				choiceIndex = 3;
			}
			
			switch(choiceIndex) {
			case 0:
				chose = (String)JOptionPane.showInputDialog(null, "Choose a type of the bike", "dwa", 
															JOptionPane.QUESTION_MESSAGE, null, type, type[0]);
				break;
			case 1:
			case 2:
			case 3:
			}
			
		}while(choiceIndex != 3);
		
	}// main //

}// class
