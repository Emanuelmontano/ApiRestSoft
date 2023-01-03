package com.abisoft.abisoft.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilidadFechas {

	private UtilidadFechas() {
		super();
	}

	public static Date convertStringToDate(final String format, final String fecha) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(fecha);
		} catch (Exception e) {
			return null;
		}
	}

	public static String convertDateToString(final String format, final Date fecha) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(fecha);
		} catch (Exception e) {
			return null;
		}
	}

}
