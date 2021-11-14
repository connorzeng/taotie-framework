package com.connor.taotie.bootmvc.config.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class MydateConvert implements Converter<String, Date> {


    @Override
    public Date convert(String source) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {

            return format.parse(source);

        } catch (ParseException e) {
            return null;
        }
    }

}
