// Jasper edit

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
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controller.MainMgr;


public class SalesRevenue {

	private LocalDate salesPeriod;
	private ArrayList<OrderInvoice> salesMade;
	private double overallSales;


	public SalesRevenue() {	// constructor
		this.salesPeriod = LocalDate.now(ZoneId.systemDefault());  // dunno works or not
		this.overallSales = 0;
	}

	public void includeOrderInvoice(OrderInvoice oi){
		this.salesMade.add(oi);
	}



	// 
	public double calDaySales(LocalDate inDay,ArrayList<OrderInvoice> sales){
		double tSales = 0;

		for(OrderInvoice i : sales){
			if (i.getTimeStamp() == inDay){
				tSales += i.getFinalTotal();
			}
		}

		//this.overAllsales = tSales;
		return tSales;
	}

	public double calMthSales(int inMth,ArrayList<OrderInvoice> sales){
		double tSales = 0;
		int invoiceMth = 0;

		for(OrderInvoice i : sales){
			invoiceMth = Integer.parseInt((i.getTimeStamp().getMonth()).toString());  //should work??
			if (invoiceMth == inMth){
				tSales += i.getFinalTotal();
			}
		}
		return tSales;
	}
	// Print sales report by month or day. If true, print by month. Prints by day otherwise.
	public void printSalesReport(int month, int day, boolean b) {
		overallSales=0;
		int i=0;
		ArrayList<String[]> allOrders = new ArrayList<String[]>();

		allOrders = readSalesData();
		
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
						System.out.println(allOrders.get(i)[1] + " " + allOrders.get(i)[2]);
						overallSales += Double.parseDouble(allOrders.get(i)[2]);
					}
					else if (day == newDate) {
						System.out.println(allOrders.get(i)[1] + " " + allOrders.get(i)[2]);
						overallSales += Double.parseDouble(allOrders.get(i)[2]);
					}
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		
		System.out.println("Total Revenue for month " + month + " is $" + overallSales);

		/*
		try {
			Date reportDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/


	}

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