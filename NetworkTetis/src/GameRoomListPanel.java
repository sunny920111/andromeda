import java.awt.Color;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


public class GameRoomListPanel extends JPanel {
	
	private DefaultListModel<JPanel> roomModel;
	private int roomSize = 25;
	private JList<JPanel> roomList = new JList<JPanel>();
	private JScrollPane scrollPane; 
	private JPanel roomPanel; 
	GameRoomListPanel(){

		getRoomData();
		initJList();
		
		setBackground(Color.white);
	}
	
	public void getRoomData(){
		roomModel = new DefaultListModel<JPanel>();
		
		
 		for(int i=0; i< roomSize ;i++){
 			roomModel.addElement(roomPanel);
 		}
 	 }
	
	public void makeLayout(){
		
	}
 	 
 	 public void initJList(){
 		roomList.setModel(roomModel);
 		roomList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 		roomList.setLayoutOrientation(JList.VERTICAL);
 		roomList.setAutoscrolls(true);
 		roomList.setVisibleRowCount(-1);
 

 		scrollPane = new JScrollPane();
 		scrollPane.setViewportView(roomList);
 	 }
}
