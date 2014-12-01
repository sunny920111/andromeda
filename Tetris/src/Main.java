
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame implements ActionListener,KeyListener,Runnable{
	
	/**
	 * The Serial Version UID 
	 */
	private static final long serialVersionUID = 1L;
	private SidePanel sidePanel;
	private GamePanel gamePanel; 
	private int width = 600;
	private int height = 800;
	private boolean threadMovement = true;
	private int row =0;
	/*
	 * Layout 지정 
	 * */
	Main(){
		setTitle("Tetris");
		setSize(width,height);
		setVisible(true);		
		setResizable(false);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		makeRightPanel();
		add(sidePanel,"East");
		add(gamePanel,"Center");
	}
	
	public void makeRightPanel(){
		sidePanel = new SidePanel();
		gamePanel = new GamePanel();
		
		addListenerAtSidePanel(sidePanel);
	}
	
	public void addListenerAtSidePanel(SidePanel sidePanel){
		Component[] components = sidePanel.getComponents();
		
		for(int i=0; i< components.length ;i++){
			if("javax.swing.JButton".equals(components[i].getClass().getName())){
				((JButton)components[i]).addActionListener(this);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String id = ((JButton)e.getSource()).getText();
		if("START".equals(id)){
			startGame();
		}else if("STOP".equals(id)){
			stopGame();
		}else{
			
		}
	}
	
	public void startGame(){
		Thread game = new Thread(this);
		game.start();
	}
	
	public void stopGame(){
		threadMovement = false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Boolean[][] stackStatue = gamePanel.getStackStatue();
		while(threadMovement){
			for(int i=0; i< 25 ;i++){
				
				// 그전에 그린거 지우기 
				if(i-1 >=0){
					gamePanel.repaintAtPixel(i-1, row);
				}
				
				//현재 초점에서 그리기 
				gamePanel.paintAtPixel(i, row);
			
				// 그 다음에 있는 아이들이 이미 채워져있을 때 , 쌓기 위해서 하는 것 		
				if(i+1 <=24 &&stackStatue[i+1][row] ==true){
					gamePanel.checkTetrisLine(i,row);
					break;
				}	
				if(i==24){
					gamePanel.checkTetrisLine(i,row);
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}
		}
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args){
		new Main();
	}
	
}
