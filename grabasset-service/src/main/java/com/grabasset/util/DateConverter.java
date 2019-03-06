package com.grabasset.util;

import java.sql.Date;
import java.sql.Timestamp;

public class DateConverter {

	public static Date utilDateToSqlDate(java.util.Date date) {
		Date sqlDate = null;
		if (date != null) {
			sqlDate = new java.sql.Date(date.getTime());
		}
		return sqlDate;
	}

	public static Timestamp utilDateTosqlTimeStamp(java.util.Date date) {
		Timestamp timestamp = null;
		if (date != null) {
			timestamp = new java.sql.Timestamp(date.getTime());
		}
		return timestamp;
	}
}
