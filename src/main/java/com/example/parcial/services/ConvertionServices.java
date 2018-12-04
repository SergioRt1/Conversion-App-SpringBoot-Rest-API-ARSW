package com.example.parcial.services;

public interface ConvertionServices {

    float ConvertToCelsius(Float value) throws ConvertException;

    float ConvertToFahrenheit(Float value) throws ConvertException;
}
