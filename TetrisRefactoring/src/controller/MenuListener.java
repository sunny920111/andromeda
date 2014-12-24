package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MenuListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		GameController gc = new GameController();
		
		String id = ((JButton)e.getSource()).getText();
		if("START".equals(id)){
			gc.startGame();
			((JButton)e.getSource()).setText("PAUSE");
		}else if("STOP".equals(id)){
			gc.stopGame();
		}else if("PAUSE".equals(id)){
			((JButton)e.getSource()).setText("RESUME");
			gc.pauseGame();
		}else if("RESUME".equals(id)){
			((JButton)e.getSource()).setText("PAUSE");
			gc.resumeGame();
		}
	}

}
