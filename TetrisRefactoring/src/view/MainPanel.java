package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.DrawValue;



public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8668618688820184387L;
	private DrawValue dv = DrawValue.getInstance();
	public MainPanel(){
		setLayout(new GridLayout(dv.getRows(),dv.getCols()));
		
		JLabel[][] pixel = new JLabel[dv.getRows()][dv.getCols()];
		for(int i=0; i< dv.getRows(); i++){
			for(int j=0; j<dv.getCols(); j++){
				pixel[i][j] = new JLabel("");
				pixel[i][j].setBorder(BorderFactory.createLineBorder(Color.gray));
				pixel[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				pixel[i][j].setOpaque(true);
				pixel[i][j].setBackground(Color.white);
				dv.setPixel(i, j, pixel[i][j]);
				add(dv.getPixel(i, j));
			}
		}

	
	}
}
