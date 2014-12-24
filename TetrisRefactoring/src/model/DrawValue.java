package model;

import java.awt.Color;

import javax.swing.JLabel;

public class DrawValue {
	private static DrawValue drawValue = new DrawValue();
	private int rows = 25; //mainPanel¿« row
	private int cols = 12; //mainPanel¿« col
	private boolean[][] blockStatue = new boolean[rows][cols];
	private int[][] blockColor = new int[rows][cols];
	private JLabel[][] pixel = new JLabel[rows][cols];
	private int x = 0;
	private int y = CommonValue.getDefalutY();

	private DrawValue(){}
	
	public static DrawValue getInstance(){
		if(drawValue == null){
			drawValue = new DrawValue();
		}
		return drawValue;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public boolean getBlockStatue(int i,int j) {
		return blockStatue[i][j];
	}

	public void setBlockStatue(int i, int j, boolean blockStatue) {
		this.blockStatue[i][j] = blockStatue;
	}
	
	public int getBlockColor(int i,int j) {
		return blockColor[i][j];
	}

	public void setBlockColor(int i,int j,int blockColor) {
		this.blockColor[i][j] = blockColor;
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

	public JLabel getPixel(int i,int j) {
		return pixel[i][j];
	}

	public void setPixel(int x, int y, JLabel pixel) {
		this.pixel[x][y] = pixel;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


}
