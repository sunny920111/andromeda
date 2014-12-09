import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main extends JFrame{

	private int width = 500;
	private int height = 500; 
	
	private UserListPanel userList;
	private GameRoomListPanel gameRoomList; 
	private GameSettingPanel gameSettingPanel; 
	
	Main(){
		setTitle("게임대기방");
		setSize(width,height);
		setVisible(true);		
		setResizable(false);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		makePanel(); 
		add(userList,"West");
		add(gameRoomList,"Center");
		add(gameSettingPanel,"North");
	}
	
	public void makePanel(){
		userList = new UserListPanel();
		gameRoomList = new GameRoomListPanel();
		gameSettingPanel = new GameSettingPanel();
		
		userList.setPreferredSize(new Dimension(100,userList.HEIGHT));
	}
	public static void main(String[] args){
		new Main();
	}
}
