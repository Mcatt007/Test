package foodOrder;

import java.util.Scanner;
import java.util.Vector;

public class Main {
	Scanner scan = new Scanner(System.in);
	Vector<String> foodTypeArr = new Vector<String>();
	Vector<String> foodNameArr = new Vector<String>();
	Vector<Double> foodCaloriesArr = new Vector<Double>();
	Vector<Integer> foodPriceArr = new Vector<Integer>();
	
	public Main() {
		int menu = -1;
		
		do {
			System.out.println("Food Order");
			System.out.println("==========");
			System.out.println("1. Insert New Food");
			System.out.println("2. List of Food");
			System.out.println("3. Search Food");
			System.out.println("4. Delete Food");
			System.out.println("5. Exit");
			System.out.print("Choose : ");
			try {
				menu = scan.nextInt();
			}catch (Exception e) {
				menu = -1;
			}
			scan.nextLine();
			
			if (menu == 1) {
				String foodType = "";
				String foodName = "";
				Double foodCalories = 0.0;
				Integer foodPrice = 0;
				
				do {
					System.out.print("Input food's type [Appetizer | Main Course | Dessert] : ");
					foodType = scan.nextLine();
				}while(!(foodType.equalsIgnoreCase("appetizer") || foodType.equalsIgnoreCase("Main Course") || foodType.equalsIgnoreCase("Dessert")));
				
				do {
					System.out.print("Input food's Name [3-20] : ");
					foodName = scan.nextLine();					
				}while(foodName.length() < 3 || foodName.length() > 20);
				
				do {
					System.out.print("Input food's Calories [1.0 - 4.0] : ");
					foodCalories = scan.nextDouble();
					scan.nextLine();
				}while(foodCalories < 1.0 || foodCalories > 4.0);
				
				do {
					System.out.print("Input food's Price [10000 - 40000] : ");
					foodPrice = scan.nextInt();
					scan.nextLine();
				}while(foodPrice < 10000 || foodPrice > 40000);
				
				System.out.println("Data has been Successfully inserted!");
				
				foodTypeArr.add(foodType);
				foodNameArr.add(foodName);
				foodCaloriesArr.add(foodCalories);
				foodPriceArr.add(foodPrice);
			}
			else if(menu == 2) {
				if(foodTypeArr.size() < 1) {
					System.out.println("No Data!");
					System.out.println();
				}
				else {
					for (int i = 0; i < foodTypeArr.size(); i++) {
						int no = i+1;
						System.out.println("No : " + no);
						System.out.println("=========");
						System.out.println("1. Type : " + foodTypeArr.get(i));
						System.out.println("2. Name : " + foodNameArr.get(i));
						System.out.println("3. Calories : " + foodCaloriesArr.get(i));
						System.out.println("4. Price : " + foodPriceArr.get(i));
						System.out.println();
					}					
				}
			}
			else if(menu == 3) {
				String foodName = "";
				
				do {
					System.out.print("Input food's Name [3-20] : ");
					foodName = scan.nextLine();
				}
				while(foodName.length() < 3 || foodName.length() > 20);
				
				int index = foodNameArr.indexOf(foodName);
				if(index >= 0) {
					int no = index + 1;
					System.out.println("No : " + index);
					System.out.println("=========");
					System.out.println("1. Type : " + foodTypeArr.get(index));
					System.out.println("2. Name : " + foodNameArr.get(index));
					System.out.println("3. Calories : " + foodCaloriesArr.get(index));
					System.out.println("4. Price : " + foodPriceArr.get(index));
					System.out.println();
				}else {
					System.out.println("Data not found");
				}
			}
			else if(menu == 4) {
				if(foodTypeArr.isEmpty()) {
					System.out.println("No Data!");
				}
				else {
					for (int i = 0; i < foodTypeArr.size(); i++) {
						int no = i+1;
						System.out.println("No : " + no);
						System.out.println("=========");
						System.out.println("1. Type : " + foodTypeArr.get(i));
						System.out.println("2. Name : " + foodNameArr.get(i));
						System.out.println("3. Calories : " + foodCaloriesArr.get(i));
						System.out.println("4. Price : " + foodPriceArr.get(i));
						System.out.println();
					}
					int input = 0;
					System.out.println();
					do {
						System.out.printf("Input number(No) to be deleted [1 .. %d] [0 for cancel] : ", foodTypeArr.size());
						input = scan.nextInt();
						scan.nextLine();
					}while (input > foodTypeArr.size());
					
					if(input == 0) {
						System.out.println("");
					}else {
						input--;
						foodTypeArr.remove(input);
						foodNameArr.remove(input);
						foodCaloriesArr.remove(input);
						foodPriceArr.remove(input);
						System.out.println("Data has been successfully deleted!");
					}
				}
			}
		}
		while(menu != 5);
		
	}
	
	public static void main(String[] args) {
		new Main();

	}

}
