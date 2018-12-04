package com.example.parcial.services;

import com.example.parcial.model.Unit;

public interface ConvertionServices {

    Unit ConvertToCelsius(Float value) throws ConvertException;

    Unit ConvertToFahrenheit(Float value) throws ConvertException;
}
