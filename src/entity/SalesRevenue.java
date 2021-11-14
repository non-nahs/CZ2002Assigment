// Jasper edit

package entity;

import java.util.ArrayList;
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
		readSalesData();
		/*String date = "2021-11-14";
		try {
			Date reportDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/


	}

	private void readSalesData() {
		Scanner sc = new Scanner(MainMgr.PATH);
		int i=0;
		ArrayList<String[]> alOrders = new ArrayList<String[]>();
		String[] tempLine;
		String tempString;
		Pattern dateFormat = Pattern.compile("(\\d{4}-\\d{2}-\\d{2})");

		try(BufferedReader br = new BufferedReader(new FileReader(MainMgr.PATH))) {
			while ((tempString = br.readLine()) != null) {
				tempLine = tempString.split("\t");
				alOrders.add(tempLine);
				System.out.println(tempLine[0] + " " + tempLine[1] + " " + tempLine[2]);
				System.out.println(alOrders.get(i));
				//Matcher readDate = dateFormat.matcher(tempLine);
				//Date reportDate = new SimpleDateFormat("yyyy-MM-dd").parse(readDate.toString());
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}