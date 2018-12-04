package com.example.parcial.bean.impl;

import com.example.parcial.bean.Convertion;
import com.example.parcial.model.Unit;
import com.example.parcial.services.ConvertException;
import org.springframework.stereotype.Service;

@Service
public class ConvertionImpl implements Convertion{

    @Override
    public Unit ConvertToCelsius(Float value) throws ConvertException {
        return new Unit((value-32)*5/9);
    }

    @Override
    public Unit ConvertToFahrenheit(Float value) throws ConvertException {
        return new Unit(value*9/5+32);
    }
}
