package Bikes;

import java.io.File;

import javax.swing.JOptionPane;

public class Methods {

	// ========== chooseAnImage ========== // Allows you to  choose an image
	static String chooseAnImage(String mape) {
	    File imageFolder = new File(mape);
	    File[] failuSaraksts = imageFolder.listFiles();

	    if (failuSaraksts == null || failuSaraksts.length == 0) {
	        JOptionPane.showMessageDialog(null, "Mapē nav bilžu!");
	        return null;
	    }

	    Object izvele = JOptionPane.showInputDialog(
	        null,
	        "Izvēlēties bildi:",
	        "Izvēle",
	        JOptionPane.INFORMATION_MESSAGE,
	        null,
	        failuSaraksts,
	        failuSaraksts[0]
	    );

	    if (izvele == null) {
	        return null;
	    }

	    return mape + File.separator + ((File) izvele).getName();
	}// chooseAnImage

}// class
