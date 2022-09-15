package com.liao.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter1 implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        SimpleDateFormat format=new SimpleDateFormat("YYYY--MM--dd");
        try {
            Date date=format.parse(source);
            return date;
        }
        catch (ParseException e) {


        }
        return null;
    }
}
