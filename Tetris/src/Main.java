
import java.awt.Component;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame implements ActionListener,KeyEventDispatcher ,Runnable{
	
	/**
	 * The Serial Version UID 
	 */
	private static final long serialVersionUID = 1L;
	private SidePanel sidePanel;
	private GamePanel gamePanel; 
	private int width = 600;
	private int height = 800;
	private boolean threadMovement = true;
	private int col =0;
	/*
	 * Layout ���� 
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

		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(this);
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
				
				// ������ �׸��� ����� 
				if(i-1 >=0){
					gamePanel.repaintAtPixel(i-1);
				}
				
				//���� �������� �׸��� 
				gamePanel.paintAtPixel(i, col);
			
				// �� ������ �ִ� ���̵��� �̹� ä�������� �� , �ױ� ���ؼ� �ϴ� �� 		
				if(i+1 <=24 &&stackStatue[i+1][col] ==true){
					gamePanel.setStatue(i,col);
					break;
				}	
				if(i==24){
					gamePanel.setStatue(i,col);
				}
				
				gamePanel.chekTerisLine();
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
	public boolean dispatchKeyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getID() == KeyEvent.KEY_PRESSED){
			if(e.getKeyCode()==37){//Left
				if(col-1 <0){
					col =0;
				}else{
					col--;
				}
			}else if(e.getKeyCode()==39){//Right
				if(col+1 >15){
					col =15;
				}else{
					col++;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		new Main();
	}

	
	
}
