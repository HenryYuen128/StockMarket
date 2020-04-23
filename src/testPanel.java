

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.omg.CORBA.PUBLIC_MEMBER;

public class testPanel extends JPanel {
	public testPanel() {
		setSize(600,500);
		setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		int[] xPoints = {10,30,50,80,100,600};
		int[] yPoints = {10,50,50,130,200,10};
		int nPoints = 6;
		g2.drawPolyline(xPoints, yPoints, nPoints);
		
	}
	
}
