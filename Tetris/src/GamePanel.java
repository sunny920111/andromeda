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
				//Draw Line 
				pixel[i][j] = new JLabel();
				pixel[i][j].setBorder(BorderFactory.createLineBorder(Color.gray));
				pixel[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				pixel[i][j].setOpaque(true);
				pixel[i][j].setBackground(Color.white);
				add(pixel[i][j]);
			}
		}
		
		

	}
	
	public void paintAtPixel(int row,int col){
		pixel[row][col].setBackground(Color.lightGray);
		
		for(int i=0; i< row ; i++){
			for(int j=0; j< col ;j++){
	
				pixel[i][j].setBackground(Color.lightGray);
			}
		}
	}
	
	public void repaintAtPixel(int row){
		for(int i=0; i< cols ; i++ ){
			if(stackStatue[row][i] == false){
				pixel[row][i].setBackground(Color.white);
			}
		}
	
	}
	
	public void setStatue(int row,int col){
		stackStatue[row][col] = true;
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
			if(line ==16){
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
					}
				}
			}
			repaint();

	}
	
	
	public void repaint(){
		for(int i=0; i< rows; i++){
			for(int j=0; j<cols; j++){
				if(stackStatue[i][j]){
					pixel[i][j].setBackground(Color.lightGray);
				}else{
					pixel[i][j].setBackground(Color.white);
				}
			}
		}
	}
}
