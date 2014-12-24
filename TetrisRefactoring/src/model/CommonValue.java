package model;

import java.util.Random;

public class CommonValue {

	private static CommonValue commonValue = new CommonValue();
	
	private CommonValue(){}
	
	private int randomNum; //어떤 item 선정할지
	private boolean flag =false; // thread 계속 할지 안 할지 상태를 관리 
	private boolean waiting = false;
	private Thread gameThread;
	private int speed = 150;
	private static int defalutSpeed  =150;
	private static int defalutY  =5;
	private int rotation = 0;
	
	public static CommonValue getInstance(){
		
		if(commonValue == null){
			commonValue = new CommonValue();
		}
		return commonValue;
	}
	
	public int getRandomNum(){
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		randomNum = random.nextInt(7);
		
		return randomNum;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	
	public Thread getGameThread() {
		return gameThread;
	}

	public void setGameThread(Thread gameThread) {
		this.gameThread = gameThread;
	}

	public boolean isWaiting() {
		return waiting;
	}

	public void setWaiting(boolean waiting) {
		this.waiting = waiting;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public static int getDefalutSpeed() {
		return defalutSpeed;
	}

	public static int getDefalutY() {
		return defalutY;
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}



	
}
