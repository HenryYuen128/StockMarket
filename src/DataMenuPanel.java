import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DataMenuPanel extends JPanel{
	JButton openButton, highButton, lowButton, closeButton, volumeButton;
	GridLayout gridLayout;
	public DataMenuPanel() {
		
		gridLayout = new GridLayout(1, 5, 100, 0);
		setLayout(gridLayout);
		
		openButton = new JButton("Open Price");
		highButton = new JButton("Highest Price");
		lowButton = new JButton("Lowest Price");
		closeButton = new JButton("Close Prie");
		volumeButton = new JButton("Volume");
		
		
		add(openButton);
		add(highButton);
		add(lowButton);
		add(closeButton);
		add(volumeButton);
	}
}
