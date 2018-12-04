package com.example.parcial;

import com.example.parcial.services.ConvertException;
import com.example.parcial.services.ConvertionServices;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParcialApplicationTests {

    @Autowired
    ConvertionServices services;

    @Test
    public void contextLoads() {
    }

    @Test
    public void toFahrenheit1() throws ConvertException {
        Assert.assertEquals((float) 71.6, services.ConvertToFahrenheit((float) 22),0.1);
    }

    @Test
    public void toCelsius1() throws ConvertException {
        Assert.assertEquals((float) 22, services.ConvertToCelsius((float) 71.6),0.1);
    }

    @Test
    public void toFahrenheit2() throws ConvertException {
        Assert.assertEquals((float) 50, services.ConvertToFahrenheit((float) 10),0.1);
    }

    @Test
    public void toCelsius2() throws ConvertException {
        Assert.assertEquals((float) 10, services.ConvertToCelsius((float) 50),0.1);
    }
}
