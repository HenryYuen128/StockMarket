import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class DrawPanel2 extends JPanel {
		int[] xPoints;
		int[] yPoints;
		int nPoints;
		boolean isDraw = false;
		public DrawPanel2() {
//			this.xPoints = xPoints;
//			this.yPoints = yPoints;
//			this.nPoints = nPoints;
			setBackground(Color.WHITE);

		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
			g2.setColor(Color.BLACK);
			if (isDraw == true) {
				g2.drawPolyline(xPoints, yPoints, nPoints);
				for (int i = 0; i < xPoints.length; i++) {
					g2.drawOval(xPoints[i]-2, yPoints[i]-2, 4, 4);
				}
				
			}
			//g2.drawString("HHHHHH", 10, 10);
//			g2.drawPolyline(xPoints, yPoints, nPoints);
		}
		
		protected void setPolyline(int[] xPoints, int[] yPoints, int nPoints) {
			this.xPoints = xPoints;
			this.yPoints = yPoints;
			this.nPoints = nPoints;
			isDraw = true;
			this.repaint();
		}
		
}
