package application;
//This is the class for each customer, which will have the basic information of each customer
public class Customer {
	
	//Self explanatory variables for the customer
	private String PhoneNumber;
	private String CustomerName;
	private String Address;
	private String ChargeAccount; //Charge account type, as in Visa/Mastercard
	private String AddressInfo;
	
	//Constructor for normal creation
	public Customer(String PhoneNumber, String CustomerName, String Address, String ChargeAccount){
		this.PhoneNumber = PhoneNumber;
		this.CustomerName = CustomerName;
		this.Address = Address;
		this.ChargeAccount = ChargeAccount;
	}
	
	//Constructor for Database input creation
	public Customer (String input){
		String[] temp = input.split(",");
		this.PhoneNumber = temp[0];
		this.CustomerName = temp[1];
		this.Address = temp[2];
		this.ChargeAccount = temp[3];
	}
	
	public String getNumber(){
		return PhoneNumber;
	}
	public String getName(){
		return CustomerName;
	}
	public String getAddress(){
		return Address;
	}
	public String getAccount(){
		return ChargeAccount;
	}
	public String getAddressInfo(){
		return AddressInfo;
	}
	public void setAddressInfo(String Info){
		AddressInfo = Info;
	}
}
