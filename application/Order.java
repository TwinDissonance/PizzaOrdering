package application;
import java.util.ArrayList;

//Order information, will be attached to a customer and will have one or more Pizzas
public class Order {
	
	//Member Variables
	private ArrayList<Pizza> PizzaList = new ArrayList<Pizza>();
	private ArrayList<Drink> DrinkList = new ArrayList<Drink>();
	private String PaymentType; //Should be one of "Cash", "Check", or "Card"
	private String CustomerName;
	private String DeliveryAddress;
	private boolean Delivery;
	private double Cost;
	
	//Constructor
	public Order(Customer cust, boolean Deliver){
		if(Deliver){
			DeliveryAddress = cust.getAddress();
			Delivery = true;
		}
		
		CustomerName = cust.getName();
	}
	
	public void addPizza(Pizza p){
		PizzaList.add(p);
	}
	
	public void removePizza(int index){
		PizzaList.remove(index);
	}
	
	public void addDrink(Drink d){
		DrinkList.add(d);
	}
	
	public void removeDrink(int index){
		DrinkList.remove(index);
	}
	
	public double totalCost(){
		for(int i = 0; i < PizzaList.size(); i++){
			Cost += PizzaList.get(i).getCost();
		}
		for(int i = 0; i < DrinkList.size(); i++){
			Cost += DrinkList.get(i).getCost();
		}
		return Cost;
	}
	
	public boolean isDelivery(){
		return Delivery;
	}
	
	//Will be used to determine if there needs to be a line for signing
	public boolean isCard(){
		if(PaymentType == "Card"){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String getPaymentType(){
		return PaymentType;
	}
	
	public String getCustomerName(){
		return CustomerName;
	}
	
	public String getAddress(){
		return DeliveryAddress;
	}
	
	public void setPaymentType(String type){
		PaymentType = type;
	}

}
