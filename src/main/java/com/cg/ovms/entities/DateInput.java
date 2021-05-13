package com.cg.ovms.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateInput {

	
	private String date;

	public LocalDate getDate() {
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		   LocalDate localDate= LocalDate.parse(date,formatter);
		return localDate;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
