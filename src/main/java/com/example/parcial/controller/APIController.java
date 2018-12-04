package com.example.parcial.controller;

import com.example.parcial.model.Unit;
import com.example.parcial.services.ConvertException;
import com.example.parcial.services.ConvertionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/convertion")
public class APIController {

    @Autowired
    ConvertionServices service;

    @GetMapping("/fahrenheit/{value}")
    public ResponseEntity<?> getConvertToFahrenheitHandler(@PathVariable Float value) {
        try {
            Unit fahrenheit = service.ConvertToFahrenheit(value);
            fahrenheit.setType("ToFahrenheit");
            return new ResponseEntity<>(fahrenheit,HttpStatus.CREATED);
        } catch (ConvertException ex) {
            Logger.getLogger(ConvertException.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/celsius/{value}")
    public ResponseEntity<?> getConvertToCelsiusHandler(@PathVariable Float value) {
        try {

            Unit celsius = service.ConvertToCelsius(value);
            celsius.setType("ToCelcius");
            return new ResponseEntity<>(celsius,HttpStatus.CREATED);
        } catch (ConvertException ex) {
            Logger.getLogger(ConvertException.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }
    }


}
