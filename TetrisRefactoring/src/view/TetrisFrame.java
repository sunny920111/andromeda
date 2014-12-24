package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.KeyboardFocusManager;

import javax.swing.JFrame;

import controller.KeyboardEventController;

public class TetrisFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8379154414050682418L;
	private int width = 500;
	private int height = 800;
	
	private MainPanel mainPanel= new MainPanel();;
	private MenuPanel menuPanel= new MenuPanel();
	public TetrisFrame(){
		setTitle("Tetris");
		setSize(width,height);
		setVisible(true);		
		setResizable(false);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		menuPanel.setPreferredSize(new Dimension(100,800));
		add(mainPanel,BorderLayout.CENTER);
		add(menuPanel,BorderLayout.EAST);
		
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(new KeyboardEventController());
	}
	
	
	
	
}
