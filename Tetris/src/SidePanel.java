import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;


public class SidePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel queue;
	private int rows = 5;
	private int cols = 5;
	private JLabel[][] pixel = new JLabel[rows][cols];
	
	
	SidePanel(){
		setLayout(new GridLayout(12,1));
		JButton startButton = new JButton("START");
		JButton stopButton = new JButton("STOP");
		showQueue();
		
		InputMap im = (InputMap)UIManager.get("Button.focusInputMap");
		im.put(KeyStroke.getKeyStroke("pressed SPACE"), "none");
		im.put(KeyStroke.getKeyStroke("released SPACE"), "none");
		add(startButton);
		add(stopButton);
		add(queue);
		setBackground(Color.white);
	}

	public void showQueue(){
		queue = new JPanel();
		queue.setBackground(Color.LIGHT_GRAY);
		queue.setLayout(new GridLayout(rows,cols));
	}

}
