import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolTip;

public class DisplayDataFrame extends JFrame{
	DataMenuPanel menuPanel;
	DrawPanel drawPanel;
	JButton openButton, highButton, lowButton, closeButton, volumeButton;
	boolean isOpenReverse =false;
	
	int[] tempData;
	ArrayList<Integer> tempYcoordinate = null;
	ArrayList<Integer> tempXcoordinate = null;
	
	
	JPanel bottomPanel, figurePanel, queryPanel;
	public DisplayDataFrame(ArrayList<Record> list) {
		setTitle("Display Data");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int width = (int)(dim.getWidth()/10)*9;
		int height = (int)(dim.getHeight()/10)*9;
		setSize(width,height);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		menuPanel = new DataMenuPanel();
		menuPanel.setPreferredSize(new Dimension(width, 50));
		add(menuPanel, BorderLayout.NORTH);
		
		Dimension dimension = new Dimension(width, (height/5)*4);
		drawPanel = new DrawPanel(dimension);
		drawPanel.setPreferredSize(dimension);
		
		openButton = menuPanel.openButton;
		highButton = menuPanel.highButton;
		lowButton = menuPanel.lowButton;
		closeButton = menuPanel.closeButton;
		volumeButton = menuPanel.volumeButton;
		
		//Data process-------

		//get X axis array
//		int a = 10;
//		int[] number = new int[list.size()];
//		for (int i = 0; i < list.size(); i++) {
//			number[i] = a;
//			a = a+6;
//		}
//		tempXcoordinate = arrayToList(number);
		
		
		openButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//get Y axis array
				ArrayList<Integer> openList = new ArrayList<Integer>();
				openList = getActualList(list, 1);
				drawPanel.setPolyline(openList);
				bottomPanel.add(drawPanel, BorderLayout.CENTER);

			}
		});

		
		
		
		bottomPanel  = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		
		add(bottomPanel, BorderLayout.CENTER);
		
		bottomPanel.add(drawPanel, BorderLayout.CENTER);
		
		queryPanel = new JPanel();
		queryPanel.setBackground(Color.RED);
		queryPanel.setPreferredSize(new Dimension(width, height/5));
		
		bottomPanel.add(queryPanel, BorderLayout.SOUTH);
		
		
		setVisible(true);
	}
	
	private ArrayList<Integer> getActualList(ArrayList<Record> list, int i) {
		if (i == 1) {
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			Iterator<Record> iterator = list.iterator();
			while (iterator.hasNext()) {
				Integer open = (int)iterator.next().getOpen();
				tempList.add(open);
			}
			return tempList;
		}
		return null;
	}
	
	
	//int[] arrays transform to ArrayList<Integer>
	private ArrayList<Integer> arrayToList(int[] arrays) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i : arrays) {
			temp.add(i);
		}
		return temp;
	}
	
	private int extractInt(int i, int sliceLength) {
		System.out.println("i = " + i);
		return Integer.parseInt(String.valueOf(i).substring(sliceLength));
	}
	
	
}
