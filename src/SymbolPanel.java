
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class SymbolPanel extends JPanel {
	JLabel tipsLabel, tipsLabel2, numberOfItemLable;
	JComboBox<String> comboBox;
	JTextField jTextField, numberOfItemField;
	String str1 = "Select the ticker symbol";
	String str2 = "Cannot find? type here";
	String str3 = "Number of records displayed (default 300)";
	Font font = new Font("New Times Roman", 1, 30);

	public SymbolPanel() {

		// setBackground(Color.YELLOW);
		setLayout(null);
		tipsLabel = new JLabel(str1, JLabel.CENTER);
		tipsLabel.setFont(font);
		tipsLabel.setBounds(0, 20, 800, 50);

		comboBox = new JComboBox<String>();
		comboBox.addItem("AAPL");
		comboBox.addItem("DVMT");
		comboBox.addItem("HPQ");
		comboBox.addItem("MSFT");
		comboBox.setBounds(360, 70, 70, 30);

		tipsLabel2 = new JLabel(str2, JLabel.CENTER);
		tipsLabel2.setFont(font);
		tipsLabel2.setBounds(0, 30, 800, 250);

		jTextField = new JTextField();
		jTextField.setHorizontalAlignment(JTextField.CENTER);
		jTextField.setBounds(325, 180, 150, 30);

		numberOfItemLable = new JLabel(str3, JLabel.CENTER);
		numberOfItemLable.setFont(font);
		numberOfItemLable.setBounds(0, 120, 800, 250);

		numberOfItemField = new JTextField();
		numberOfItemField.setHorizontalAlignment(JTextField.CENTER);
		numberOfItemField.setBounds(325, 270, 150, 30);
		
		//add KeyListener to ensure that only digits can be entered
		numberOfItemField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				int keyChar = e.getKeyChar();
				if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {
				} else {
					e.consume();
				}
				
				if (numberOfItemField.getText().length() >= 4) {
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});

		
		//add components
		this.setBackground(Color.RED);
		this.add(tipsLabel);
		this.add(comboBox);
		this.add(tipsLabel2);
		this.add(jTextField);
		this.add(numberOfItemLable);
		this.add(numberOfItemField);

		this.setOpaque(false);
	}
}
