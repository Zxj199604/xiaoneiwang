package com.zxj.tool;

public class Chinese {


		
		 public  static String  toChinese(String strvalue) {
	           try {
	               if (strvalue == null) {
	                   return "";
	               } else {
	                   strvalue = new String(strvalue.getBytes("ISO8859_1"), "utf-8");
	                   return strvalue;
	               }
	           } catch (Exception e) {
	               return "";
	           }
	    }
	}

