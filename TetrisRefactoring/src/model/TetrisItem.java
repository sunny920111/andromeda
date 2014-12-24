package model;

import java.awt.Color;


public class TetrisItem {
	private static TetrisItem item = new TetrisItem();
	
	private boolean[][][] itemType;
	private Color color =Color.WHITE;
	private static final int TypeI =0;
	private static final int TypeJ =1;
	private static final int TypeL =2;
	private static final int TypeO =3;
	private static final int TypeS =4;
	private static final int TypeT =5;
	private static final int TypeZ =6;
	
	private CommonValue commVal = CommonValue.getInstance();
	private ItemType itemComponent = ItemType.getInstance();
	private DrawValue dv = DrawValue.getInstance();
	
	private TetrisItem(){}

	public static TetrisItem getInstance(){
		
		if(item == null){
			item = new TetrisItem();
		}
		return item;
	}

	public boolean[][][] getRandomItem(){
		
		int randomNum = commVal.getRandomNum();
		color  = dv.getColor(randomNum);
		
		switch(randomNum){
		case TypeI:
			itemType = itemComponent.getTypeI();
			break;
		case TypeJ:
			itemType = itemComponent.getTypeJ();
			break;
		case TypeL:
			itemType = itemComponent.getTypeL();
			break;
		case TypeO:
			itemType = itemComponent.getTypeO();
			break;
		case TypeS:
			itemType = itemComponent.getTypeS();
			break;
		case TypeT:
			itemType = itemComponent.getTypeT();
			break;
		case TypeZ:
			itemType = itemComponent.getTypeZ();
			break;		
		default:
			itemType = itemComponent.getTypeI();
		}
		
		
		return itemType;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
