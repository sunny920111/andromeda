import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class GameSettingPanel extends JPanel {
	
	private JButton addGameRoom = new JButton("¹æ Ãß°¡");; 
	GameSettingPanel(){

		add(addGameRoom);
		setBackground(Color.white);
		setLayout(new FlowLayout(FlowLayout.RIGHT));
	}
}
