import java.awt.Color;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


public class UserListPanel extends JPanel{
	
	private DefaultListModel userModel;
	private int userLength = 25;
	private JList<String> userList = new JList<String>();
	private JLabel panelName = new JLabel("사용자 목록");
	private JScrollPane scrollPane; 
	
 	 UserListPanel(){
 		getUsersData();
 		initJList();
 		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
 		setBackground(Color.white);
 		panelName.setAlignmentX(Component.CENTER_ALIGNMENT);
 		add(panelName);
 		add(scrollPane);
 		
	}
 	 
 	 public void getUsersData(){
 		userModel = new DefaultListModel();
 		for(int i=0; i< userLength ;i++){
 			userModel.addElement("USER "+i);
 		}
 	 }
 	 
 	 public void initJList(){
 		userList.setModel(userModel);
 		userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 		userList.setLayoutOrientation(JList.VERTICAL);
 		userList.setAutoscrolls(true);
 		userList.setVisibleRowCount(-1);
 
 		DefaultListCellRenderer renderer  = (DefaultListCellRenderer)userList.getCellRenderer(); 
 		renderer.setHorizontalAlignment(JLabel.CENTER);
 		
 		scrollPane = new JScrollPane();
 		scrollPane.setViewportView(userList);
 	 }
 
}
