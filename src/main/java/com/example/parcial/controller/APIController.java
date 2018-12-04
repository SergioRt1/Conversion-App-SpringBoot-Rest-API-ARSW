package com.example.parcial.controller;

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
    public ResponseEntity<?> postConvertToFahrenheitHandler(@PathVariable Float value) {
        try {
            Float fahrenheit = service.ConvertToFahrenheit(value);
            return new ResponseEntity<>(fahrenheit,HttpStatus.CREATED);
        } catch (ConvertException ex) {
            Logger.getLogger(ConvertException.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/celsius/{value}")
    public ResponseEntity<?> postConvertToCelsiusHandler(@PathVariable Float value) {
        try {

            Float celsius = service.ConvertToCelsius(value);
            return new ResponseEntity<>(celsius,HttpStatus.CREATED);
        } catch (ConvertException ex) {
            Logger.getLogger(ConvertException.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }
    }


}
