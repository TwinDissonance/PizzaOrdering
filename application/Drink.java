package application;
//Small class for the drinks
public class Drink {
	
	private char Size; //S, M or L
	private String Type;
	
	//Constructor
	public Drink(char Size, String Type){
		this.Size = Size;
		this.Type = Type;
	}
	
	public double getCost(){
		if(Size == 'S')
			return 1.50;
		else if (Size == 'M')
			return 2.00;
		else if (Size == 'L')
			return 2.50;
		else
			return 9999999999999.99;
	}
	
	public String toString(){
		return Type;
	}
}
