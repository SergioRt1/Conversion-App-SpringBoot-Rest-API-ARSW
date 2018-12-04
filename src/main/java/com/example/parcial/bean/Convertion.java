package com.example.parcial.bean;

import com.example.parcial.model.Unit;
import com.example.parcial.services.ConvertException;

public interface Convertion {
    Unit ConvertToCelsius(Float value) throws ConvertException;

    Unit ConvertToFahrenheit(Float value) throws ConvertException;
}
