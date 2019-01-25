package pl.coderslab.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;

public class LocalDateConverter implements Converter <String, LocalDate> {

    @Override
    public LocalDate convert(String s) {
        if(s == null || s.length() < 10) {
            return LocalDate.now();
        }
        return LocalDate.parse(s);
    }
}
