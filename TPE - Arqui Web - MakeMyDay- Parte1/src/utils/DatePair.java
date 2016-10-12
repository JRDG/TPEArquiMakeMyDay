package utils;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class DatePair implements Serializable {
	private String fromDate;
	private String toDate;
	
	public DatePair(String fromDate,String toDate) {
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public DatePair() {
		// TODO Auto-generated constructor stub
	}
	
	public GregorianCalendar getFromDate(){
		SimpleDateFormat parser = new SimpleDateFormat("dd-mm-yyyy");
		GregorianCalendar calendar1 = new GregorianCalendar();
		try {
			calendar1.setTime(parser.parse(fromDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return calendar1;
	}

	public GregorianCalendar getToDate() {
		SimpleDateFormat parser = new SimpleDateFormat("dd-mm-yyyy");
		GregorianCalendar calendar2 = new GregorianCalendar();
		try {
			calendar2.setTime(parser.parse(toDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return calendar2;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
}
