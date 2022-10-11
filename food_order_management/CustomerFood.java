package food_order_management;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class CustomerFood {
Map<String, Integer> ordered_items = new LinkedHashMap<>();
Map<String,Double> food_price=new LinkedHashMap<>();
List<Integer> booked_tables=new ArrayList<>();
Double bill_amount = 0.00;
static int bill_id=1001;
static int userId=2201;
private String userName;
private String phoneNumber;
public void billing(int selected_category,int choose_dish,int quantity,CustomerFood user_detail)
{
	LinkedHashMap<String, Integer> selected_sub_menu=FoodDetails.menus.get(selected_category);
	int current_index=0;
	double individual_price=0.00;
	String selected_dish="";
	for(Entry<String, Integer> select_dish:selected_sub_menu.entrySet())
	{
		if(++current_index==choose_dish)
		{
			individual_price=select_dish.getValue().doubleValue();
			selected_dish=select_dish.getKey();
		}
	}
	bill_amount+=individual_price * quantity;
	ordered_items.put(selected_dish, quantity);
	food_price.put(selected_dish, individual_price);
}
public void bill_calculation(double bill_amount,CustomerFood customer) {
	double gst_percentage = 0.05;
	bill_amount = bill_amount + (bill_amount * gst_percentage);
	customer.order_details(customer);
	customer.bill_id=bill_id++;
}

public void order_details(CustomerFood cust)
{
	if(cust.ordered_items!=null)
	{
		System.out.println("--------------------------------------------------------------------------------------------------------");
		System.out.println("Customer Name: "+cust.getUserName());
		System.out.println("Customer Contact Number: "+cust.getPhoneNumber());
		System.out.println("Bill Number:"+cust.bill_id);
		System.out.println("\n------------------------------Ordered food details---------------------------------------------");
		System.out.printf("%-35s %-25s %-5s","ordered Item","ordered Quantity","Price per quantity");
		System.out.println("\n-----------------------------------------------------------------------------------------------");
		for(Map.Entry<String,Integer> ordered_food:cust.ordered_items.entrySet())
		{
			System.out.printf("%-35s %-25s %-5s",ordered_food.getKey(),ordered_food.getValue(),cust.food_price.get(ordered_food.getKey()));
			System.out.println();
		}
		System.out.println("\n-----------------------------------------------------------------------------------------------");
		System.out.printf("%60s %5s","Total bill amount =" ,bill_amount);
		System.out.println();
		System.out.println("You will get your ordered food soon......."); 
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------------------------------");

	}
	else
	{
		System.out.println("--------------------------------------------------------------------------------------------------------");
		System.out.println("You are not ordered any food yet...:-(");
		System.out.println("--------------------------------------------------------------------------------------------------------");

	}
	
}
public CustomerFood(String userName, String mobileNumber) {
	this.userName = userName;
	this.phoneNumber = mobileNumber;
}
public void display() {
	System.out.println("--------------------------------------------------------------------------------------------------------");
	System.out.println("Customer Name: "+this.userName);
	System.out.println("Mobile Number: "+this.phoneNumber);
	System.out.println("--------------------------------------------------------------------------------------------------------");
}
public static int getUserId() {
	return userId;
}
public static void setUserId(int userId) {
	CustomerFood.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
}
