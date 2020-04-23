
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class StartPanel extends JFrame {
	SymbolPanel symbolPanel;
	DateSelectPanel dateSelectPanel;
	JLabel bgLabel;
	String symbol;
	int rows;
	JComboBox<String> startDaybBox, startMonthBox, startYearBox, endDayBox, endMonthBox, endYearBox, symbolBox;
	JTextField symbolField, rowsField;
	TreeSet<Integer> set = new TreeSet<>();

	// store the date parsed from String to compare
	Date date1;
	Date date2;

	// ArrayList store record
	ArrayList<Record> list;

	public StartPanel() {
		// set style of GUI
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		ImageIcon imageIcon = new ImageIcon("bgpic.jpg");

		setTitle("Stock Search");
		setSize(800, 600);
		setLayout(null);

		// get the top container of the frame
		JPanel jPanel = (JPanel) this.getContentPane();
		jPanel.setOpaque(false);

		// set background picture

		bgLabel = new JLabel(imageIcon);
		bgLabel.setBounds(0, 0, 800, 600);
		bgLabel.setOpaque(false);

		// add background picture to last second layer panel
		this.getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE));

		// add others panels
		symbolPanel = new SymbolPanel();
		symbolPanel.setBounds(0, 0, 800, 300);
		jPanel.add(symbolPanel);

		dateSelectPanel = new DateSelectPanel();
		dateSelectPanel.setBounds(0, 300, 800, 300);
		jPanel.add(dateSelectPanel);

		startDaybBox = dateSelectPanel.startDayBox;
		startMonthBox = dateSelectPanel.startMonthBox;
		startYearBox = dateSelectPanel.startYearBox;

		endDayBox = dateSelectPanel.endDayBox;
		endMonthBox = dateSelectPanel.endMonthBox;
		endYearBox = dateSelectPanel.endYearBox;

		symbolBox = symbolPanel.comboBox;
		symbolField = symbolPanel.jTextField;

		rowsField = symbolPanel.numberOfItemField;
		// Functionality Implementation
		dateSelectPanel.jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String startDay = (String) startDaybBox.getSelectedItem();
				String startMonth = (String) startMonthBox.getSelectedItem();
				String startYear = (String) startYearBox.getSelectedItem();

				String endDay = (String) endDayBox.getSelectedItem();
				String endMonth = (String) endMonthBox.getSelectedItem();
				String endYear = (String) endYearBox.getSelectedItem();

				// get ticker symbol
				if (symbolField.getText().equals("")) {
					symbol = (String) symbolBox.getSelectedItem();
				} else {
					symbol = symbolField.getText();
				}

				if (rowsField.getText().equals("")) {
					rows = 300;
				} else {
					rows = Integer.parseInt(rowsField.getText());
				}

				// get start date
				String startDate = String.format("%s/%s/%s", startMonth, startDay, startYear);
				String endDate = String.format("%s/%s/%s", endMonth, endDay, endYear);

				// compare date
				SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				try {
					date1 = df.parse(startDate);
					date2 = df.parse(endDate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// if start date is before end date
				if (date1.after(date2) || date1.equals(date2)) {
					JOptionPane.showMessageDialog(null, "Start Date must be before End Date", "Error",
							JOptionPane.WARNING_MESSAGE);
				} else {
					System.out.println(startDate);
					System.out.println(endDate);
					System.out.println(symbol);

					String url = String.format(
							"http://quotes.wsj.com/%s/historical-prices/download?MOD_VIEW=page&num_rows=%s&startDate=%s&endDate=%s",
							symbol, rows, startDate, endDate);
					downloadFile(url);

				}

			}
		});

		this.setResizable(false);
	}

	private void downloadFile(String url) {
		list = new ArrayList<Record>();
		StringTokenizer st;
		// get the redirectURL
		String redictURL = getRedirectUrl(url);
		System.out.println(redictURL);
		Scanner in;
		try {
			URL u = new URL(redictURL);
			URLConnection connection = u.openConnection();
			InputStream inStream = connection.getInputStream();
			in = new Scanner(inStream);
			// display server response to console
			in.nextLine();

			// store data in ArrayList
			while (in.hasNextLine()) {
				String inputLine = in.nextLine();

				// extract sub string
				st = new StringTokenizer(inputLine, ",");
				try {
					String date = st.nextToken();
					Double open = Double.parseDouble(st.nextToken());
					Double high = Double.parseDouble(st.nextToken());
					Double low = Double.parseDouble(st.nextToken());
					Double close = Double.parseDouble(st.nextToken());
					Double volume = Double.parseDouble(st.nextToken());
					System.out.println(date + ">" + open + ">" + high + ">" + low + ">" + close + ">" + volume);

					// store records in list
					Record record = new Record(date, open, high, low, close, volume);
					list.add(record);
				} catch (Exception e) {
					e.printStackTrace();
				}

				;
			}
			in.close();

			if (list.size() < 1) {
				JOptionPane.showMessageDialog(null, "No data retrieved", "Error", JOptionPane.WARNING_MESSAGE);
			} else {
				// launch new window to show data
				new DisplayDataFrame(list);
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No data retrieved", "Error", JOptionPane.WARNING_MESSAGE);
		}
	}

	private String getRedirectUrl(String url) {
		HttpURLConnection conn;
		try {
			conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setInstanceFollowRedirects(false);
			conn.setConnectTimeout(20000);
			return conn.getHeaderField("Location");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No data retrieved", "Error", JOptionPane.WARNING_MESSAGE);
		}
		return null;

	}
}
