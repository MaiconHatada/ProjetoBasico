package br.ce.wcaquino.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.ce.wcaquino.core.BasePage;

public class DataUtils extends BasePage {
	
	public static Date obterDataComDiferencaDias(int dias) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, dias);
		return calendar.getTime();
		
	}
public static String obterDataFormatada(Date data) {
	DateFormat format = new SimpleDateFormat("dd/MM/YYYY");
	return format.format(data);
	
}
}
