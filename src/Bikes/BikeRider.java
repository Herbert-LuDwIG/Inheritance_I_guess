package Bikes;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;


public class BikeRider {

	// ========== main ========== // 
	public static void main(String[] args) throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException{
		//ChildBike test = new ChildBike(true, true, 20, 3, 230, "NVidia", null);
		
		//test.ringTheBell();
		String chose;
		int choiceIndex;
		String[] actions = {"New bike", "Bike list", "Methods", "Close"};
		String[] type = {"Bike", "Mountain bike", "Bike for kids"};
		String[] answer = {"Yes", "No"};
		Object[] bikes = new Object[100];
		int bikeIndex = 0;
		
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
				if(chose == null) 
					break;
				
				choiceIndex = Arrays.asList(type).indexOf(chose);
				//-------------------------------------------------------------------------------------------------
				String prod = JOptionPane.showInputDialog("Producer of the bike: ");
				if(prod == null)
					break;
				//-------------------------------------------------------------------------------------------------
				double price = Double.parseDouble(JOptionPane.showInputDialog("Price of the bike: "));
				if(price == -1)
					break;
				//-------------------------------------------------------------------------------------------------
				double diameter = Double.parseDouble(JOptionPane.showInputDialog("Diameter of the bike's tire: "));
				if(diameter == -1)
					break;
				//-------------------------------------------------------------------------------------------------
				int chairPoz = Integer.parseInt(JOptionPane.showInputDialog("Pozition of the bike's seat: "));
				if(chairPoz == -1)
					break;
				//-------------------------------------------------------------------------------------------------
				
				String way, folder;
				
				if(choiceIndex == 0) {
					folder = "imgBike";
					way = Methods.chooseAnImage(folder);
					if(way == null)
						break;
					bikes[bikeIndex] = new Bike(diameter, chairPoz, price, prod, way);
					bikeIndex++;
					JOptionPane.showMessageDialog(null, "A simple bike was added!", "Added!", JOptionPane.INFORMATION_MESSAGE);
				} else if(choiceIndex == 1) {		
					folder = "imgMountainBike";
					way = Methods.chooseAnImage(folder);
					System.out.println("Selected image path: " + way);
					if(way == null)
					break;
					int settedSpeed =  Integer.parseInt(JOptionPane.showInputDialog("Determine setted speed "));				
					chose = (String) JOptionPane.showInputDialog(null, "Does the bike have any additional springs?", "Question",
									 JOptionPane.QUESTION_MESSAGE, null, answer, answer[0]);			
					choiceIndex = Arrays.asList(answer).indexOf(chose);
					boolean spring = (choiceIndex == 0)? true : false;
					bikes[bikeIndex] = new MountainBike(settedSpeed, spring, diameter, chairPoz, price, prod, way);
					bikeIndex++;
					JOptionPane.showMessageDialog(null, "A mountain bike was added!", "Added!", JOptionPane.INFORMATION_MESSAGE);
				} else if(choiceIndex == 2) {		
					folder = "imgChildBike";
					way = Methods.chooseAnImage(folder);
					System.out.println("Selected image path: " + way);
					if(way == null)
					break;
					
							
					chose = (String) JOptionPane.showInputDialog(null, "Does the bike have any additional tires?", "Question",
									 JOptionPane.QUESTION_MESSAGE, null, answer, answer[0]);			
					choiceIndex = Arrays.asList(answer).indexOf(chose);
					boolean addTires = (choiceIndex == 0)? true : false;
					
					chose = (String) JOptionPane.showInputDialog(null, "Does the bike have any bell?", "Question",
							 JOptionPane.QUESTION_MESSAGE, null, answer, answer[0]);			
			choiceIndex = Arrays.asList(answer).indexOf(chose);
			boolean Bell = (choiceIndex == 0)? true : false;
					
					bikes[bikeIndex] = new ChildBike(addTires, Bell, diameter, chairPoz, price, prod, way);
					bikeIndex++;
					JOptionPane.showMessageDialog(null, "A child bike was added!", "Added!", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case 1:
				if(bikes.length > 0) {
					for(int i = 0; i < bikes.length; i++) {
						if(bikes[i] instanceof Bike) 
						JOptionPane.showMessageDialog(null, ((Bike)bikes[i]).print(),
						"Information",JOptionPane.INFORMATION_MESSAGE,((Bike)bikes[i]).viewAnImage());
						
						else if(bikes[i] instanceof MountainBike) 
						JOptionPane.showMessageDialog(null, ((MountainBike)bikes[i]).print(),
					    "Information",JOptionPane.INFORMATION_MESSAGE,((MountainBike)bikes[i]).viewAnImage());
						
						else if(bikes[i] instanceof ChildBike) 
						JOptionPane.showMessageDialog(null, ((ChildBike)bikes[i]).print(),
				    	"Information",JOptionPane.INFORMATION_MESSAGE,((ChildBike)bikes[i]).viewAnImage());
						
						else 
							break; // check type of the bike
					}// i < bikes.length
				}// if(bikes.length > 0)
				break;
			}// switch "choiceIndex"
			
		}while(choiceIndex != 3); // do...while()
		
	}// main

}// class
