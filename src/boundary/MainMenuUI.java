package boundary;

import entity.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenuUI {
	// initiate controller classses

	// initiate entity classes
	public static Menu menu = new Menu();
	public static SetPromotionPackage setPromo = new SetPromotionPackage();
	public static Customer customer = new Customer();
	public static Order order = new Order();
	public static OrderInvoice orderInvoice = new OrderInvoice();
	//public static Reservation reservation = new Reservation();
	//public static Staff staff = new Staff();
	public static ArrayList<Table> table = new ArrayList<Table>();
	public static SalesRevenue salesRevenue = new SalesRevenue();


	// initiate boundary classes
	public static ItemsUI itemsUI = new ItemsUI();
	public static PromotionUI promoUI = new PromotionUI();
	public static OrderUI orderUI = new OrderUI();
	public static InvoiceUI invoiceUI = new InvoiceUI();
	public static ReservationUI reserveUI = new ReservationUI();
	public static SalesReportUI salesReportUI = new SalesReportUI();


	// initiate variables
	int choice;

	
	Scanner sc = new Scanner(System.in);

	public void displayMenu() {
		// TODO - implement MainMenuUI.displayMenu
		do {
			System.out.println("----------------------------------");
			System.out.println("Select a function to perform: ");
			System.out.println("1: Item menu");
			System.out.println("2: Promotion set menu");
			System.out.println("3: Order menu");
			System.out.println("4: Reservation menu");
			System.out.println("5: Print order invoice");
			System.out.println("6: Print sale revenue report");
			System.out.println("7: Quit");
			System.out.println("Enter the number of your choice: ");
			System.out.println("----------------------------------");
			System.out.println();

			choice = sc.nextInt();
			switch (choice) {
				 case 1: 
				 	itemsUI.itemsMenu();
				 break;
				 case 2: 
					 promoUI.promotionMenu();
				 break;
				 case 3: 
					 orderUI.orderMenu();
				 break;
				 case 4:
					 reserveUI.reservationMenu();
				 break;
				 case 5:
					 invoiceUI.printInvoice();
				 break;
				 case 6:
					 salesReportUI.printSaleReport();
				 break; 
				 case 7: System.out.println("Program terminating...");
			}
		} while (choice > 0 && choice < 7);
		//throw new UnsupportedOperationException();
	}

	public void initData() {
		menu.initMenu();
		/*
		String path = Paths.get("orderList.txt");
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("orderList.txt", false).close();
			writer.print("");
			// other operations
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Table.initTable();
	}
}