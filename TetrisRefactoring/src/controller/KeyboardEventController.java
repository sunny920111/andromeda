package controller;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

import model.CommonValue;

public class KeyboardEventController implements KeyEventDispatcher {

	private CommonValue commVal = CommonValue.getInstance();
	
	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getID() == KeyEvent.KEY_PRESSED){
			if(e.getKeyCode()==37){//Left
				System.out.println("Left");
	
			}else if(e.getKeyCode()==39){//Right
				System.out.println("Right");
			
			}else if(e.getKeyCode()==38){//rotation
				
			}else if(e.getKeyCode()==40 ){
				
			}else if(e.getKeyCode()==32){ //space
				
			}else if(e.getKeyCode() ==67){ //hold
				
			}
		}else if(e.getID() == KeyEvent.KEY_RELEASED){
			if(e.getKeyCode()==40 ||e.getKeyCode()==38){
				commVal.setSpeed(CommonValue.getDefalutSpeed());
			}
		}
		return false;
	}

}
