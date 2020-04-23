
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DateSelectPanel extends JPanel {
	JLabel dayLabel, monthLabel, yearLabel, tipsLabel, startDate, endDate;
	JComboBox<String> startDayBox, startMonthBox, startYearBox, endDayBox, endMonthBox, endYearBox;
	JButton jButton;
	Font font = new Font("New Times Roman", 1, 30);
	Font dateFont = new Font("New Times Roman", 1, 20);
	Font labelFont = new Font("New Times ROMAN", 1, 15);
	
	private final int dateLabelHeight = 50;
	private final int startBoxYPosition = 100;
	private final int endBoxYPosition = 150;
	private final int labelHieght = 50;
	private final int labelWidth = 120;
	private final int boxHeight = 30;
	private final int boxWidth = 50;
	
	public DateSelectPanel() {
		//set layout to NULL to use setBounds() method
		setLayout(null);
		
		//get current year
		Calendar calendar = Calendar.getInstance();
		int curYear = calendar.get(Calendar.YEAR);
		
		//Tips label
		tipsLabel = new JLabel("Select the start date & end date", JLabel.CENTER);
		tipsLabel.setFont(font);
		tipsLabel.setBounds(0, 0, 800, labelHieght);
		
		//Start date label
		startDate = new JLabel("Start Date:", JLabel.CENTER);
		startDate.setFont(labelFont);
		startDate.setBounds(180, 90, labelWidth, labelHieght);
		
		dayLabel = new JLabel("day", JLabel.CENTER);
		dayLabel.setFont(labelFont);
		dayLabel.setBounds(355, dateLabelHeight, labelWidth , labelHieght);
		
		monthLabel = new JLabel("month");
		monthLabel.setFont(labelFont);
		monthLabel.setBounds(315, dateLabelHeight, labelWidth, labelHieght);
		
		yearLabel = new JLabel("year");
		yearLabel.setFont(labelFont);
		yearLabel.setBounds(485, dateLabelHeight, labelWidth, labelHieght);
		
		//Start date box
		startDayBox = new JComboBox<String>();
		startDayBox.setBounds(390, startBoxYPosition, boxWidth, boxHeight);
		this.addItem(startDayBox, 1, 31);
		
		
		startMonthBox = new JComboBox<String>();
		startMonthBox.setBounds(310, startBoxYPosition, boxWidth, boxHeight);
		this.addItem(startMonthBox, 1, 12);
		
		startYearBox = new JComboBox<String>();
		startYearBox.setBounds(470, startBoxYPosition, 60, boxHeight);
		this.addItem(startYearBox, 1900, curYear);
		
		//End date 
		endDate = new JLabel("End Date:", JLabel.CENTER);
		endDate.setFont(labelFont);
		endDate.setBounds(180, 140, labelWidth, labelHieght);
		
		//End date box
		endDayBox = new JComboBox<String>();
		endDayBox.setBounds(390, endBoxYPosition, boxWidth, boxHeight);
		this.addItem(endDayBox, 1, 31);
		
		endMonthBox = new JComboBox<String>();
		endMonthBox.setBounds(310, endBoxYPosition, boxWidth, boxHeight);
		this.addItem(endMonthBox, 1, 12);
		
		endYearBox = new JComboBox<String>();
		endYearBox.setBounds(470, endBoxYPosition, 60, boxHeight);
		this.addItem(endYearBox, 1900, curYear);
		
		//Search button
		jButton = new JButton("Search");
		jButton.setBounds(350, 210, 100, 30);
		
		//Add component
		this.add(tipsLabel);
		this.add(dayLabel);
		this.add(monthLabel);
		this.add(yearLabel);
		this.add(startDate);
		this.add(startDayBox);
		this.add(startMonthBox);
		this.add(startYearBox);
		this.add(endDate);
		this.add(endDayBox);
		this.add(endMonthBox);
		this.add(endYearBox);
		this.add(jButton);
		
		this.setOpaque(false);
		
	}
	
	
	//loop to add item to box, the maximum year is current year
	public void addItem(JComboBox<String> comboBox, int star, int end) {
		for (int i = star; i < end + 1; i++) {
			comboBox.addItem(String.valueOf(i));
		}
	}

	
}
