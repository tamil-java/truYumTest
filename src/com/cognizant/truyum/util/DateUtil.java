package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static Date convertToDate(String userDate) {
        Date date = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            date = dateFormat.parse(userDate);
        } catch (ParseException e) {
            System.out.println("DateUtil Convert Error " + e.getMessage());
            throw new RuntimeException("Date Convertion Error");
        }
        return date;
    }

    public static java.sql.Date convertUtilToSql(java.util.Date utilDate) {
        java.sql.Date sqlDate = null;
        try {
            sqlDate = new java.sql.Date(utilDate.getTime());
        } catch (RuntimeException e) {
            throw new RuntimeException("Date Convertion Error");
        }
        return sqlDate;
    }
}
