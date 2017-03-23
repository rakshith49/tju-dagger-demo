package com.tju.daggerDemo.di;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by rakshith on 22/03/17.
 */

public class DateTypeDeserializer implements JsonDeserializer<Date> {
    private final String[] DATE_FORMATS = new String[]{
            "MMM dd',' yyyy HH:mm:ss a",
            "MMM dd',' yyyy HH:mm:ss",
            "yyyy-MM-dd'T'HH:mm:ss",
            "yyyy-mm-dd"
    };

    @Override
    public Date deserialize(JsonElement jsonElement, Type typeOF, JsonDeserializationContext context) throws JsonParseException {
        for (String format : DATE_FORMATS) {
            try {
                return new SimpleDateFormat(format, Locale.US).parse(jsonElement.getAsString());
            } catch (ParseException e) {
                try {
                    return new Date(jsonElement.getAsLong());
                } catch (Exception ignored) {
                }
            }
        }
        return null;
    }
}
