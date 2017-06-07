package application;
//Pizza class with specified size, toppings, ect

public class Pizza {
	
	private char Size; //S, M or L
	private double Cost;
	private String Description;
	
	//Topping booleans, if they are selected or not
	private boolean ExtraCheese = false;
	private boolean Pepperoni = false;
	private boolean Sausage = false;
	private boolean Onions = false;
	private boolean Peppers = false;
	private boolean Spinach = false;
	private boolean Ham = false;
	
	//Crust Booleans
	private boolean ThinCrust = false;
	private boolean StuffedCrust = false;
	private boolean ThickCrust = false;
	
	//Long constructor
	public Pizza(char Size, boolean ExtraCheese, boolean Pepperoni, boolean Sausage, boolean Onions, boolean Peppers, boolean Spinach, boolean Ham){
		this.Size = Size;
		this.ExtraCheese = ExtraCheese;
		this.Pepperoni = Pepperoni;
		this.Sausage = Sausage;
		this.Onions = Onions;
		this.Peppers = Peppers;
		this.Spinach = Spinach;
		this.Ham = Ham;
	}
	
	public double getCost(){
		if(Size == 'S')
			Cost = 6.00;
		else if (Size == 'M')
			Cost = 9.00;
		else if (Size == 'L')
			Cost = 12.00;
		else
			return 9999999999999.99;
		if(ThinCrust || ThickCrust || StuffedCrust)
			Cost += 2.50;
		if(ExtraCheese)
			Cost += 1.00;
		if(Pepperoni)
			Cost += 1.00;
		if(Sausage)
			Cost += 1.00;
		if(Onions)
			Cost += 1.00;
		if(Peppers)
			Cost += 1.00;
		if(Spinach)
			Cost += 1.00;
		if(Ham)
			Cost += 1.00;
		return Cost;
	}
	
	public String toString(){
		Description = (Size + " Pizza");
		if(ThinCrust || ThickCrust || StuffedCrust || ExtraCheese || Pepperoni || Sausage || Onions || Peppers || Spinach || Ham)
			Description = Description + " with";
		if(ThinCrust)
			Description = Description + " Thin Crust";
		else if (ThickCrust)
			Description = Description + " Thick Crust";
		else if (StuffedCrust)
			Description = Description + " Stuffed Crust";
		if(ExtraCheese)
			Description = Description + " Extra Cheese";
		if(Pepperoni)
			Description = Description + " Pepperoni";
		if(Sausage)
			Description = Description + " Sausage";
		if(Onions)
			Description = Description + " Onions";
		if(Peppers)
			Description = Description + " Peppers";
		if(Spinach)
			Description = Description + " Spinach";
		if(Ham)
			Description = Description + " Ham";
		return Description;
	}
}
