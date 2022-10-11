package food_order_management;

import java.util.Scanner;

public class DiningArrangement{
	Scanner scanning=new Scanner(System.in);
public void choosing(CustomerFood customer) {
	boolean looping=true;
	while(looping) {
	System.out.println("Provide Your Choice");
	System.out.println("1.Food Menu\n2.Order Foods\n3.Order Details\n4.MainMenu");
	int menuChoosing=scanning.nextInt();
	FoodDetails foodDetails=new FoodDetails();
	foodDetails.menu();
	switch(menuChoosing) {
	case 1:{
		foodDetails.details(foodDetails);
	}
	break;
	case 2:{
		boolean foodOrder = true;
		while (foodOrder) {System.out.println();
			System.out.println("\nChoose any category");
			System.out.println("1.Veg \n2.Non Veg \n3.Snacks \n4.Deserts\n5.Main Menu");
			int selected_category=scanning.nextInt();
			foodDetails.showdishes(selected_category);
			scanning.nextLine();
			System.out.println("Choose dish:");
			int choose_dish=scanning.nextInt();
			String selected_dish = scanning.nextLine();
			System.out.println("Required quantity");
			int quantity = scanning.nextInt();
			customer.billing(selected_category, choose_dish, quantity, customer);
			System.out.println("\nDo you want to add any items to order?(1.yes or 2.no)");
			int start_order = scanning.nextInt();
			if (start_order == 2)
				foodOrder=false;
		}
		System.out.println("\nPayment details....");
		customer.bill_calculation(customer.bill_amount,customer);
		System.out.println("\nPayment is successfull");
		break;
	}
	case 3:{
		System.out.println("\nPayment details....");
		customer.order_details(customer);
	}
	break;
	case 4:{
		looping=false;
	}
	break;
	default:
		System.out.println("Please Choose Correct Option");
	}
	}
}
}
