package controller;

import model.CommonValue;
import model.DrawValue;
import model.TetrisItem;

public class GameController implements Runnable{
	private CommonValue commVal = CommonValue.getInstance();
	private TetrisItem tetrisItem = TetrisItem.getInstance();
	private DrawValue dv = DrawValue.getInstance();
	private DrawGamePanelController drawController;
	
	private boolean[][] item;
	public GameController(){
		drawController = new DrawGamePanelController();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		while(commVal.isFlag()){
			dv.setY(CommonValue.getDefalutY());
			commVal.setSpeed(CommonValue.getDefalutSpeed());
			
			item = tetrisItem.getRandomItem()[0];
			for(int i=0; i<dv.getRows();i++){
			
				drawController.clearPanel();
				
				drawController.drawBlock(i, dv.getY(), item,tetrisItem.getColor());
				
				while(commVal.isWaiting()){
					System.out.println("Pause");
				}
				
				try {
					Thread.sleep(commVal.getSpeed());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

	public void startGame(){
		if(commVal.getGameThread() == null){
			commVal.setGameThread(new Thread(this));
			commVal.getGameThread().start();
		}else{
			if(!commVal.getGameThread().isAlive()){
				commVal.setGameThread(new Thread(this));
				commVal.getGameThread().start();
			}
		}
		
		commVal.setFlag(true);
		commVal.setWaiting(false);
		
	}
	
	public void pauseGame(){
		commVal.setWaiting(true);
	}
	
	public void resumeGame(){
		commVal.setWaiting(false);
	}
	
	public void stopGame(){
		if(commVal.getGameThread() != null){
			commVal.getGameThread().stop();
		}
	}

}
