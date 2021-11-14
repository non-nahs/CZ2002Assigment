package entity;

import java.util.ArrayList;
import java.util.Calendar;
//import java.util.Date;
import java.time.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.Scanner;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import controller.MainMgr;

/**
 * Represents sales completed over a period of 1 day or 1 month.  
 * @author Yeo Kai Liang, Jasper
 * @version 1.0
 * @since 2021-10-15
 */
public class SalesRevenue {

	//private LocalDate salesPeriod;
	//private ArrayList<OrderInvoice> salesMade;
	private double overallSales;

	/**
	 * Creates a new SalesRevenue and set overallSales to 0.
	 * overallSales is total revenue over a period of time (day/month)
	 */
	public SalesRevenue() {
		//this.salesPeriod = LocalDate.now(ZoneId.systemDefault());
		this.overallSales = 0;
	}

	/*
	public void includeOrderInvoice(OrderInvoice oi){
		this.salesMade.add(oi);
	}*/
	
	/**
	 * Print sales report by month or day. if print sales report by month, day is set to 0. 
	 * @param month month selected by user.
	 * @param day day selcted by user.
	 */
	public void printSalesReport(int month, int day) {
		overallSales=0;
		int i=0;
		ArrayList<String[]> allOrders = new ArrayList<String[]>();

		allOrders = readSalesData();
		System.out.println("----------------------------------");
		while (i < allOrders.size()) {
			try {
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(allOrders.get(i)[0]);
				//System.out.println(date);
				Calendar cal = Calendar.getInstance();
				cal.clear();
				cal.setTime(date);
				int newMonth = cal.get(Calendar.MONTH)+1;
				int newDate = cal.get(Calendar.DATE);
				
				if (month == newMonth) {
					if (day == 0) {
						System.out.println(allOrders.get(i)[1] + "\t\t$" + allOrders.get(i)[2]);
						overallSales += Double.parseDouble(allOrders.get(i)[2]);
					}
					else if (day == newDate) {
						System.out.println(allOrders.get(i)[1] + "\t\t$" + allOrders.get(i)[2]);
						overallSales += Double.parseDouble(allOrders.get(i)[2]);
					}
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			i++;
		}
		
		if(day==0)
			System.out.println("Total Revenue for month " + month + " is $" + overallSales);
		else
			System.out.println("Total Revenue for day " + day + " is $" + overallSales);

		/*
		try {
			Date reportDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
	}

	/**
	 * Gets menuItem name and price from orderList.txt
	 * @return arraylist of all orders in orderList.txt
	 */
	private ArrayList<String[]> readSalesData() {
		int i=0;
		ArrayList<String[]> alOrders = new ArrayList<String[]>();
		String[] tempLine;
		String tempString;

		try(BufferedReader br = new BufferedReader(new FileReader(MainMgr.PATH))) {
			while ((tempString = br.readLine()) != null) {
				tempLine = tempString.split("\t");
				alOrders.add(tempLine);
				//System.out.println(alOrders.get(i)[0] + " " + alOrders.get(i)[1] + " " + alOrders.get(i)[2]);
				i++;
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return alOrders;
	}
}