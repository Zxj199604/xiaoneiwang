package com.zxj.tool;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class CountTime {
	//年月日，星期几
	public String currentlyTime() {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
		String DATE=dateFormat.format(date);
		return DATE;
	}
	//年月日
	public String currentlyTime1(){
//		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日"); 
		String DATE=sdf.format(date);
		return DATE;
	}

}
