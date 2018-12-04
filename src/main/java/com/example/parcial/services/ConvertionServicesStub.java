package com.example.parcial.services;

import com.example.parcial.model.Unit;
import org.springframework.stereotype.Service;

@Service
public class ConvertionServicesStub implements ConvertionServices{

    @Override
    public Unit ConvertToCelsius(Float value) throws ConvertException {
        return new Unit((value-32)*5/9);
    }

    @Override
    public Unit ConvertToFahrenheit(Float value) throws ConvertException {
        return new Unit(value*9/5+32);
    }
}
