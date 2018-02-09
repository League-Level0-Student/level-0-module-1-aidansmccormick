import javax.swing.JOptionPane;

public class Unbirthday {

	public static void main(String[] args) {
	
	String bDay = JOptionPane.showInputDialog("mm/dd/yy");
	if (bDay.equals("02/08/18")) {
	JOptionPane.showMessageDialog(null, "Happy Birthday!!!");
	}		
	else {
		
		JOptionPane.showMessageDialog(null, "Happy UNbirthday!!!");
		
		
	}
	}

}
