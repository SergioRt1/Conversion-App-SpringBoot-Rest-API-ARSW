package com.example.parcial.services;

import org.springframework.stereotype.Service;

@Service
public class ConvertionServicesStub implements ConvertionServices{

    @Override
    public float ConvertToCelsius(Float value) throws ConvertException {
        return (value-32)*5/9;
    }

    @Override
    public float ConvertToFahrenheit(Float value) throws ConvertException {
        return value*9/5+32;
    }
}
