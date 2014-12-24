package model;

public class ItemType {
	public static ItemType item = new ItemType();
	
	private ItemType(){}
	
	public static ItemType getInstance(){
		if(item == null){
			item = new ItemType();
		}
		
		return item;
	}
	
	private boolean[][][] TypeI = {
			{
				{true,	true,	true,	true},
			},
			{
				{true},
				{true},	
				{true},		
				{true},	
			},
			{
				{true,	true,	true,	true},
			},
			{
				
				{true},
				{true},	
				{true},		
				{true}
	
			}
		};
	
	
	private boolean[][][] TypeJ = {
				{
					{true,	false,	false},
					{true,	true,	true}
				},
				{
					{true,	true},
					{true,	false},
					{true,	false}
				},
				{
		
					{true,	true,	true},
					{false,	false,	true}
				},
				{
					{false,	true},
					{false,	true},
					{true,	true}
				}
		};
		
	private boolean[][][] TypeL = {
				{
					{false,	false,	true},
					{true,	true,	true}
				},
				{
					{true,	false},
					{true,	false},
					{true,	true},
				},
				{
					{true,	true,	true},
					{true,	false,	false}
				},
				{
					{true,	true},	
					{false,	true},	
					{false,	true}
				}
		};
		
	private boolean[][][] TypeO = {
				{
					{true,	true},
					{true,	true},
				},
				{
					{true,	true},
					{true,	true},
				},
				{	
					{true,	true},
					{true,	true},
				},
				{
					{true,	true},
					{true,	true},
				}
		};
		
	private boolean[][][] TypeS = {
				{
					{false,	true,	true},
					{true,	true,	false}
				},
				{
					{true,	false},
					{true,	true},
					{false,	true}
				},
				{
					{false,	true,	true},
					{true,	true,	false}
				},
				{
					{true,	false},	
					{true,	true},	
					{false,	true}
				}
		};
	private boolean[][][] TypeT = {
				{
					{false,	true,	false},
					{true,	true,	true}
				},
				{
					{true,	false},
					{true,	true},
					{true,	false}
				},
				{
					{true,	true,	true},
					{false,	true,	false}
				},
				{
					{false,	true},
					{true,	true},
					{false,	true}
				}
		};
	private boolean[][][] TypeZ = {
				{
					{true,	true,	false},
					{false,	true,	true}
				},
				{
					{false,	true},
					{true,	true},
					{true,	false}
				},
				{
					{true,	true,	false},
					{false,	true,	true}
				},
				{
					{false,	true},	
					{true,	true},	
					{true,	false}
				}
		};

	public boolean[][][] getTypeI() {
		return TypeI;
	}

	public void setTypeI(boolean[][][] typeI) {
		TypeI = typeI;
	}

	public boolean[][][] getTypeJ() {
		return TypeJ;
	}

	public void setTypeJ(boolean[][][] typeJ) {
		TypeJ = typeJ;
	}

	public boolean[][][] getTypeL() {
		return TypeL;
	}

	public void setTypeL(boolean[][][] typeL) {
		TypeL = typeL;
	}

	public boolean[][][] getTypeO() {
		return TypeO;
	}

	public void setTypeO(boolean[][][] typeO) {
		TypeO = typeO;
	}

	public boolean[][][] getTypeS() {
		return TypeS;
	}

	public void setTypeS(boolean[][][] typeS) {
		TypeS = typeS;
	}

	public boolean[][][] getTypeT() {
		return TypeT;
	}

	public void setTypeT(boolean[][][] typeT) {
		TypeT = typeT;
	}

	public boolean[][][] getTypeZ() {
		return TypeZ;
	}

	public void setTypeZ(boolean[][][] typeZ) {
		TypeZ = typeZ;
	}
}
