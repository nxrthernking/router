package com.innowise.router.dto;

import lombok.SneakyThrows;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

public class LocalDateAdapter  extends XmlAdapter<String, LocalDate> {
    @Override
    @SneakyThrows
    public LocalDate unmarshal(String s){
        return LocalDate.parse(s);
    }

    @Override
    @SneakyThrows
    public String marshal(LocalDate localDate)  {
        return localDate.toString();
    }
}