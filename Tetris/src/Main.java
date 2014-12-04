
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main extends JFrame implements ActionListener,KeyEventDispatcher ,Runnable{
	
	/**
	 * The Serial Version UID 
	 */
	private static final long serialVersionUID = 1L;
	private SidePanel sidePanel;
	private GamePanel gamePanel; 
	private TetrisItem item = new TetrisItem();
	private int width = 500;
	private int height = 800;
	private boolean threadMovement = true;
	private boolean suspended = false;
	private int col =0;
	private int row = 0;
	private int ItemStatue = 0;
	private Thread game;
	private boolean[][][] component;
	private int randomNum;
	private ArrayList<boolean[][][]> allItem;
	private int speed = 200;
	private boolean[][][] hold;
	private int holdRandomNum =0;
	private boolean holdFlag =false;

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

	    allItem = new ArrayList<boolean[][][]>();
		allItem.add(item.TypeI);
		allItem.add(item.TypeJ);
		allItem.add(item.TypeL);
		allItem.add(item.TypeO);
		allItem.add(item.TypeS);
		allItem.add(item.TypeT);
		allItem.add(item.TypeZ);
		
		
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(this);
	}
	
	public void makeRightPanel(){
		sidePanel = new SidePanel();
		gamePanel = new GamePanel();

		sidePanel.setPreferredSize(new Dimension(100,800));
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
			((JButton)e.getSource()).setText("PAUSE");
		}else if("STOP".equals(id)){
			stopGame();
		}else if("PAUSE".equals(id)){
			((JButton)e.getSource()).setText("RESUME");
			pauseGame();
		}else if("RESUME".equals(id)){
			((JButton)e.getSource()).setText("PAUSE");
			resumeGame();
		}
	}
	
	public void startGame(){
		if(game == null){
		
		    game = new Thread(this);
			game.start();
		}else{
			if(!game.isAlive()){
				game = new Thread(this);
				game.start();
			}
		}
		threadMovement= true;
		suspended= false;
		gamePanel.setLine(0);
		
	}
	
	public void pauseGame(){
		suspended = true;
	}
	
	public void resumeGame(){
		suspended = false;
	}
	
	public void stopGame(){
		
		if(game != null){
			((JButton)sidePanel.getComponent(0)).setText("START");
			threadMovement= false;
			gamePanel.clearStackStatue();
			gamePanel.repaint();
			sidePanel.repaint();
			game.stop();
		}else{
			JOptionPane.showMessageDialog(null, "Please, Start");
		}
		
	}
	
	public boolean[][][] getRandomItem(){
		
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		randomNum = random.nextInt(7);
		return allItem.get(randomNum);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while(threadMovement){
			col = 5;
			speed = 150;
			holdFlag =false;
			component =getRandomItem();
			for(int i = 0; i < 25; i++){
				row=i;	
				
				if(!gamePanel.checkLineNum(component[ItemStatue%4])){
					String[] buttons = {"CONFIRM"};
					int result = JOptionPane.showOptionDialog(null, "GAME OVER","GAME OVER"
							,JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, buttons,"CONFIRM");
					
					if(result ==0){
						stopGame();
					}
					break;
				}
				// 그전에 그린거 지우기
				gamePanel.repaint();
				
				//현재 초점에서 그리기 
				gamePanel.paintAtPixel(i, col,component[ItemStatue%4],randomNum);	
				

				while(suspended){ //일시중지
					//infinite loop
					System.out.println("suspended");
				}			

				if(holdFlag){
					break;
				}
				// 그 다음에 있는 아이들이 이미 채워져있을 때 , 쌓기 위해서 하는 것 		
				gamePanel.setStatue(i, col, component[ItemStatue%4],randomNum);
				
			
				gamePanel.chekTerisLine();
			
				if(gamePanel.checkBottomSide(i, col, component[ItemStatue%4])){
					break;
				}
			
				try {
					Thread.sleep(speed);
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
				
				if(!gamePanel.checkLeftRightSide(row, col, component[ItemStatue%4],37)
						&&!gamePanel.checkBottomSide(row, col, component[ItemStatue%4])){
					col--;
				}
			}else if(e.getKeyCode()==39){//Right
				if(!gamePanel.checkLeftRightSide(row, col, component[ItemStatue%4],39)
						&&!gamePanel.checkBottomSide(row, col, component[ItemStatue%4])){
					col++;
				}
			}else if(e.getKeyCode()==38){

				if(gamePanel.checkRotateItem(row, col, component[(ItemStatue+1)%4])
						&&!gamePanel.checkLeftRightSide(row, col, component[(ItemStatue+1)%4],38)
						&&!gamePanel.checkBottomSide(row, col, component[(ItemStatue+1)%4])){
		
					ItemStatue++;
				}
				
			}else if(e.getKeyCode()==40 ){
				speed =50;
			}else if(e.getKeyCode()==32){//space
				speed =5;
			}else if(e.getKeyCode() ==67){
				
				boolean[][][] temp;
				int tempColor; 
				Color color = null;
				if(hold== null){
					hold =component;
					holdRandomNum = randomNum;
					color= gamePanel.getColor(randomNum);
					holdFlag = true;
				}else{
					
					if(!gamePanel.checkLeftRightSide(row, col, hold[ItemStatue%4],67)
							&&gamePanel.checkRotateItem(row, col, hold[(ItemStatue+1)%4])){
					
						temp = component;
						component = hold;
						hold = temp;
						
						tempColor = randomNum;
						randomNum = holdRandomNum;
						holdRandomNum = tempColor;
						
						color= gamePanel.getColor(holdRandomNum);
					}else{
						color = gamePanel.getColor(holdRandomNum);
					}
					
				}
				
				sidePanel.repaint();
				sidePanel.drawQueue(hold[0], color);
			}

		}else if(e.getID() == KeyEvent.KEY_RELEASED){
			if(e.getKeyCode()==40 ||e.getKeyCode()==38){
				speed =200;
			}
		}

		return false;
	}
	
	public static void main(String[] args){
		new Main();
	}

	
	
}
