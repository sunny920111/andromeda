import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class SidePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	SidePanel(){
		setLayout(new GridLayout(12,1));
		JButton startButton = new JButton("START");
		JButton stopButton = new JButton("STOP");

		
		add(startButton);
		add(stopButton);
		setBackground(Color.white);
	}


}
