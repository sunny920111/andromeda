package controller;

import java.awt.Color;

import model.CommonValue;
import model.DrawValue;
import model.TetrisItem;

public class DrawGamePanelController {

	private DrawValue dv = DrawValue.getInstance();
	
	
	public boolean checkValidtaion(int x, int y, boolean[][] item){
		
		if(y <0 || y+item[0].length >dv.getRows() ){
			return false;
		}
		
		return true;
	}
	
	public void setStatue(){
		
	}
	public void drawBlock(int x, int y, boolean[][] item,Color color){

		if(checkValidtaion(x,y,item)){
			for(int i=0; i< item.length;i++){
				for(int j=0; j< item[i].length;j++){
					if(item[i][j]){
						dv.getPixel(x+i, y+j).setBackground(color);
					}
				}
			}	
		}else{
			
		}

	}
	
	public void clearPanel(){
		for(int i=0; i< dv.getRows(); i++){
			for(int j=0; j<dv.getCols(); j++){
				if(dv.getBlockStatue(i,j)){
					dv.getPixel(i, j).setBackground(dv.getColor(dv.getBlockColor(i, j)));
				}else{
					dv.getPixel(i, j).setBackground(Color.white);
				}
			}
		}
	}
	

}
