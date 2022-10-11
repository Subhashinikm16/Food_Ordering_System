package food_order_management;

import java.util.LinkedHashMap;
import java.util.*;

public class FoodDetails {
	Scanner ob=new Scanner(System.in);
	static Map<Integer, LinkedHashMap<String, Integer>> menus = new LinkedHashMap<>();
	static LinkedHashMap<String, Integer> snacks = new LinkedHashMap<>();
	static LinkedHashMap<String, Integer> veg = new LinkedHashMap<>();
	static LinkedHashMap<String, Integer> nonVeg = new LinkedHashMap<>();
	static LinkedHashMap<String, Integer> deserts = new LinkedHashMap<>();
	
	public void menu() {
		
		menus.put(1, veg);
		menus.put(2, nonVeg);
		menus.put(3, snacks);
		menus.put(4, deserts);

		veg.put("Veg Food Meals", 140);
		veg.put("Palak Paneer", 120);
		veg.put("Dosa", 70);
		veg.put("Veg Biriyani", 120);
		veg.put("Chenna Masala", 90);
		veg.put("Curd Rice", 50);
		veg.put("Idly Set", 75);

		nonVeg.put("Chicken Biriyani", 120);
		nonVeg.put("Button Biriyani", 135);
		nonVeg.put("Full Meals", 220);
		nonVeg.put("Grilled Chicken", 150);
		nonVeg.put("Mutton Soup", 78);
		nonVeg.put("Fish Fry", 99);

		deserts.put("Gulab jamun", 60);
		deserts.put("Chocolate Cake", 50);
		deserts.put("halwa", 40);
		deserts.put("Ice Cream", 55);
		
		snacks.put("Popcorn", 68);
		snacks.put("Cheese Bread", 60);
		snacks.put("Veg Lolopop", 100);
		
	}
	public void details(FoodDetails foodDetails) {
		boolean choosing=true;
		while(choosing) {
		System.out.println("Choose any option:");
		System.out.println("1.Veg \n2.Non Veg \n3.Snacks\n4.deserts\n5.Main Menu");
		int submenu = ob.nextInt();
		if(submenu==5) {
			choosing=false;
		}
		showdishes(submenu);
		}
	}
	public void showdishes(int submenu) {
		int dishIndex=0;
		System.out.println();
		switch (submenu) {
		case 1: {
			System.out.println("--------------------------------------------------------------------------------------------------------");
			System.out.println("------------------------------------- dish Varieties ---------------------------------------------------");
			System.out.printf("%-5s %-25s %-5s","S.No","Dishes","Price");
			System.out.println();
			System.out.println("--------------------------------------------------------------------------------------------------------");
			System.out.println();
			for (Map.Entry<String, Integer> d : veg.entrySet()) {
				System.out.printf("%-5s %-25s %-5s",++dishIndex,d.getKey(),d.getValue());
				System.out.println();
				
			}
			System.out.println("--------------------------------------------------------------------------------------------------------");
		}
			break;

		case 2: {
			System.out.println("--------------------------------------------------------------------------------------------------------");
			System.out.println("------------------------------------- dish Varieties ---------------------------------------------------");
			System.out.printf("%-5s %-25s %-5s","S.No","Dishes","Price");
			System.out.println();
			System.out.println("----------------------------------------------------------------");
			System.out.println();
			for (Map.Entry<String, Integer> d : nonVeg.entrySet()) {
				System.out.printf("%-5s %-25s %-5s",++dishIndex,d.getKey(),d.getValue());
				System.out.println();
			}
			System.out.println("--------------------------------------------------------------------------------------------------------");
		}
			break;

		case 3: {
			System.out.println("--------------------------------------------------------------------------------------------------------");
			System.out.println("------------------------------------ dish Varieties ----------------------------------------------------");
			System.out.printf("%-5s %-25s %-5s","S.No","Dish Name","Price Per Quantity");
			System.out.println();
			System.out.println("----------------------------------------------------------------");
			System.out.println();
			for (Map.Entry<String, Integer> d : snacks.entrySet()) {
				System.out.printf("%-5s %-25s %-5s",++dishIndex,d.getKey(),d.getValue());
				System.out.println();
			}
			System.out.println("--------------------------------------------------------------------------------------------------------");

		}
			break;

		case 4: {
			System.out.println("--------------------------------------------------------------------------------------------------------");
			System.out.println("-------------------------------------- dish Varieties --------------------------------------------------");
			System.out.printf("%-5s %-25s %-5s","S.No","Dish Name","Price Per Quantity");
			System.out.println();
			System.out.println("----------------------------------------------------------------");
			System.out.println();
			for (Map.Entry<String, Integer> d: deserts.entrySet()) {
				System.out.printf("%-5s %-25s %-5s",++dishIndex,d.getKey(),d.getValue());
				System.out.println();
			}
			System.out.println("--------------------------------------------------------------------------------------------------------");
		}
			break;

		case 5:
			return;

		default:
			System.out.println("Please Choose Correct Catagory");
		}
	}
}
