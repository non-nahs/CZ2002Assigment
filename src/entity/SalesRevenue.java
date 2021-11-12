// Jasper edit

package entity;

import java.util.ArrayList;
//import java.util.Date;
import java.time.*;


public class SalesRevenue {

	private LocalDate salesPeriod;
	private ArrayList<OrderInvoice> salesMade;
	private double overallSales;


	public SalesRevenue(){	// constructor
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
}