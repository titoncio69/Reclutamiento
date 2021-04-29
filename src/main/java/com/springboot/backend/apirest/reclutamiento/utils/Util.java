package com.springboot.backend.apirest.reclutamiento.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Util {
	public static void main (String[] args) throws ParseException {
//		String fn = "";
		String fecha = "Apr 21 2021 12:00AM";
//		System.out.println(fecha);
		SimpleDateFormat format = new SimpleDateFormat("MMM dd yyyy HH:mma", new Locale("en", "EN"));
		Date d1 = format.parse(fecha);
		Date d = new Date();
		System.out.println(d1);
		System.out.println(format.format(d));
		
	}
	
	
}
