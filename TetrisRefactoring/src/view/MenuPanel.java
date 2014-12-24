package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import controller.MenuListener;

public class MenuPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3478859524085262735L;
	
	public MenuPanel(){
		setLayout(new GridLayout(12,1));
		setBackground(Color.WHITE);
		
		JButton startButton = new JButton("START");
		JButton stopButton = new JButton("STOP");
		
		InputMap im = (InputMap)UIManager.get("Button.focusInputMap");
		im.put(KeyStroke.getKeyStroke("pressed SPACE"), "none");
		im.put(KeyStroke.getKeyStroke("released SPACE"), "none");
		
		startButton.addActionListener(new MenuListener());
		stopButton.addActionListener(new MenuListener());
		
		add(startButton);
		add(stopButton);
	}
}
