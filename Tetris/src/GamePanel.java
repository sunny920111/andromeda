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
		setBackground(Color.white);
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
	}
	
	public void repaintAtPixel(int row,int col){
		pixel[row][col].setBackground(Color.white);
	}
	
	public void checkTetrisLine(int row,int col){
		stackStatue[row][col] = true;
	}
}
