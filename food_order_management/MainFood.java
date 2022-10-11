package food_order_management;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MainFood {
    Scanner ob=new Scanner(System.in);
    ArrayList<CustomerFood> customerArray=new ArrayList<>();
    DiningArrangement da=new DiningArrangement();
	public static void main(String[] args) {
		MainFood main=new MainFood();
		main.FirstPage();
	}
    private void FirstPage() {
    	System.out.println("*****************************************************************************************");
        System.out.println("                   Welcome to Chennai's Famous 5 Star Hotel                              ");
        System.out.println("*****************************************************************************************");
        boolean choosing=true;
        while(choosing) {
        	 System.out.println("Choose Any Option ");
             System.out.println("1.Login\n2.About Us\n3.Exit");
             int option=ob.nextInt();
        	switch(option) {
        	case 1:{
        		login();
        	}
        	break;
        	case 2:{
        		System.out.println("Welcome to Chennai's Famous 5 Star Hotel...");
        		System.out.println("Chennai's Most Luxurious Indian Styled Restaurent...");
        		System.out.println("For Table Rcervations, Contact famous5starhotel@gmail.com");
        		System.out.println("Ours Address");
        		System.out.println("40.B. Ramachandra Adithanar Road,");
        		System.out.println("Gandhinagar,");
        		System.out.println("Adyar,");
        		System.out.println("Chennai-600 020");
        	}
        	break;
        	case 3:{
        		System.out.println("Thank You..Visit Again");
        		choosing=false;
        	}
        	break;
        	}
    }
    }
    public void login() {
    	System.out.println("Enter Your Name:");
    	String name=ob.next();
    	String mobileNumber="";
    	 boolean isValidph=false;
   	  while(!isValidph)
   	   {
   		   System.out.println("Enter your Mobile Number:");
   		   mobileNumber=ob.next();
   		   if(isValidMobile(mobileNumber)) {
   			   isValidph=true;
   		   }
   		   else {
   			  System.out.println("Plase Enter Valid Mobile Number");
   		   }
   	   }	 
    	CustomerFood customer=new CustomerFood(name,mobileNumber);
    	this.customerArray.add(customer);
    	customer.display();
    	da.choosing(customer);
    }
    public boolean isValidMobile(String mobile)
    {
 	   Pattern mobilepattern=Pattern.compile("(0 ||91)?[6-9][0-9]{9}");
 	   Matcher mobilematcher=mobilepattern.matcher(mobile);
 	   if(mobilematcher.find())
 		   return true;
 	   return false;
    }
}
