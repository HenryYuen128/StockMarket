import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.transaction.xa.XAException;

public class DrawPanel extends JPanel {
		int[] xPoints;
		int[] yPoints;
		int nPoints;
		boolean isDraw = false;
		private final static int GAP = 30; 
		int max;
		Dimension dimension;
		ArrayList<Integer> list;
		public DrawPanel(Dimension dimension) {
//			this.xPoints = xPoints;
//			this.yPoints = yPoints;
//			this.nPoints = nPoints;
			this.dimension = dimension;
			setSize(dimension);
			setBackground(Color.WHITE);

		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
			g2.setColor(Color.BLACK);
			if (isDraw == true) {
				if (list.size() > 0) {
					double yScale = (getHeight() - 2*GAP) / (list.size() - 1);
					double xScale = (getWidth() - 2*GAP) / (list.size() - 1);
				    g2.drawLine(GAP, getHeight() - GAP, GAP, GAP);
				    g2.drawLine(GAP, getHeight() - GAP, getWidth() - GAP, getHeight() - GAP);
				    
				    ArrayList<Point> points = new ArrayList<>();
				    for (int i = 0; i < list.size(); i++) {
						int y = list.indexOf(i);
						int x = (int) (GAP + i*xScale);
						Point point = new Point(x)
					}
				    
				}
					
				}
				
			}
			//g2.drawString("HHHHHH", 10, 10);
//			g2.drawPolyline(xPoints, yPoints, nPoints);
		
		protected void setPolyline(ArrayList<Integer> list) {
			this.list = list;
			max = Collections.max(list);
			isDraw = true;
			this.repaint();
		}
		
		
}
