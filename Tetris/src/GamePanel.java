import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class GamePanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rows = 25;
	private int cols = 16;
	private JLabel[][] pixel = new JLabel[rows][cols];
	private Boolean[][] stackStatue = new Boolean[rows][cols];
	private int[][] blockColor= new int[rows][cols];
	private int line=0; 
	
	public Boolean[][] getStackStatue() {
		return stackStatue;
	}

	public void setStackStatue(Boolean[][] stackStatue) {
		this.stackStatue = stackStatue;
	}

	GamePanel(){
		setLayout(new GridLayout(rows,cols));

		for(int i=0; i< rows; i++){
			for(int j=0; j<cols; j++){
				//init componet Statue
				stackStatue[i][j] = false;
				blockColor[i][j] = 7;
				//Draw Line 
				pixel[i][j] = new JLabel("");
				pixel[i][j].setBorder(BorderFactory.createLineBorder(Color.gray));
				pixel[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				pixel[i][j].setOpaque(true);
				pixel[i][j].setBackground(Color.white);
				add(pixel[i][j]);
			}
		}
		
		

	}
	
	public Color getColor(int colorNum){
		Color color = Color.LIGHT_GRAY;
		
		switch(colorNum){
		case 0:
			color = Color.red;
			break;
		case 1:
			color = Color.orange;
			break;
		case 2:
			color = Color.yellow;
			break;
		case 3:
			color = Color.green;
			break;
		case 4:
			color = Color.blue;
			break;
		case 5:
			color = Color.magenta;
			break;
		case 6:
			color = Color.cyan;
			break;
		default:
				color = Color.white;
		}
		
		return color;
	}
	
	public void paintAtPixel(int row,int col,boolean[][] item ,int color){
		//pixel[row][col].setBackground(Color.lightGray);
		for(int i=0; i< item.length;i++){
			for(int j=0; j< item[i].length;j++){
				if(row+i < rows && col+j <cols){
					if(item[i][j]){
						pixel[row+i][col+j].setBackground(getColor(color));
					}
				}
			}
		}
	
	}
	
	
	public boolean checkLeftRightSide(int row,int col,boolean[][] item,int keyCode){

		boolean leftSide = false; 
		boolean rightSide = false;
		
		//ї­ check
		for(int i=0; i< item.length ;i++){
			if(col-1 >0){
				if(stackStatue[row+i][col-1]){
					leftSide = true; 
					break;
				}else if(stackStatue[row+item.length][col-1]){
					leftSide = true; 
					break;
				}
			}else if(col==0){
				leftSide = true; 
				break;
			}

			if(col+item[i].length < cols){
				if(stackStatue[row+i][col+item[i].length]){
					rightSide = true; 
					break;
				}else if(stackStatue[row+item.length][col+item[i].length]){
					rightSide = true; 
					break;
				}
			}else if(col+item[i].length==cols){
				rightSide = true; 
				break;
			}
			
			
		}
	
		if(keyCode == 37){
			return leftSide;
		}else if(keyCode == 39){
			return rightSide;
		}
		return (leftSide||rightSide);
	}
	
	public boolean checkRotateItem(int row,int col,boolean[][] item){
		boolean result = false;
		
		if(item[0].length+col <cols){
			result = true;
		}
		
		return result; 
	}
	
	public boolean checkBottomSide(int row,int col,boolean[][] item){
		boolean result = false;
		
		//За check
		int lastTrue[] = getLastTrue(item);
		
		if(col+item[0].length<=cols){
			for(int i=0; i< item[0].length ;i++){
				if(row+item.length<rows  ){
					if(stackStatue[row+lastTrue[i]+1][col+i] ){	
						if(item[lastTrue[i]][i]){
							result = true;
							break;
						}
						
					}
				}else if(row+item.length==rows ){
					result =true;
					
					break;
				}
			}
		}

			
		return result;
	}
	
	public int[] getLastTrue(boolean[][] item){
		int[] lastTrue = new int[item[0].length];
		for(int i=0; i<item[0].length ;i++){
			for(int j=item.length-1; j>=0 ;j--){
				if(item[j][i]){
					lastTrue[i]=j;
					break;
				}
			}
		}
		return lastTrue;
	}
	
	public void setStatue(int row,int col,boolean[][] item,int color){	

		if(checkBottomSide(row,col,item)){
			for(int i=0; i<item.length;i++){
				for(int j=0; j<item[i].length;j++){
					if(!stackStatue[row+i][col+j]){
						stackStatue[row+i][col+j] = item[i][j];
						blockColor[row+i][col+j] = color;
					}
				}
			}
		}
	}
	public boolean checkLineNum(boolean[][] item){
		
		boolean flag = false;
		for(int i=0; i<rows;i++){
			for(int j=0; j< cols ;j++){
				if(stackStatue[i][j]){
					line = rows-i;
					flag = true;
					break;
				}
			}
			if(flag){
				break;
			}
		}
		
		if(line+item.length >rows){
			return false;
		}
		return true;
	}
	public void chekTerisLine(){
		
		int[] lines = new int[25];
		boolean flag = false;
		int k=0; 
		for(int i=0; i<rows ; i++){
			int line=0;
			for(int j=0; j <cols ; j++){
				if(stackStatue[i][j] == true){
					line++;
				}
			}
			if(line ==cols){
				lines[k++] = i; 
				flag = true; 
			}
		}
		
		if(flag){
			clearLine(lines);
		}
		
	}
	
	public void clearLine(int[] lines){

			for(int i=0; i < lines.length ;i++){
				for(int j=lines[i];j>0 ; j--){
					for(int k=0; k<cols ;k++){
						stackStatue[j][k] = stackStatue[j-1][k];
						blockColor[j][k] = blockColor[j-1][k];
					}
				}
			}
			repaint();

	}
	
	public void clearStackStatue(){
		for(int i=0; i<rows; i++){
			for(int j=0; j< cols;j++){
				stackStatue[i][j] = false;
				blockColor[i][j] = 7;
			}
		}
	}
	
	public void repaint(){
		for(int i=0; i< rows; i++){
			for(int j=0; j<cols; j++){
				if(stackStatue[i][j]){
					pixel[i][j].setBackground(getColor(blockColor[i][j]));
				}else{
					pixel[i][j].setBackground(Color.white);
				}
			}
		}
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}
}
