package com.example.parcial;

import com.example.parcial.services.ConvertException;
import com.example.parcial.services.ConvertionServices;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParcialApplicationTests {

    @Autowired
    ConvertionServices services;

    @LocalServerPort
    private int port;

    @Test
    public void contextLoads() {
    }

    @Test
    public void toFahrenheit1() throws ConvertException {
        Assert.assertEquals( 71.6, services.ConvertToFahrenheit((float) 22).getValue(),0.1);
    }

    @Test
    public void toCelsius1() throws ConvertException {
        Assert.assertEquals(22, services.ConvertToCelsius((float) 71.6).getValue(),0.1);
    }

    @Test
    public void toFahrenheit2() throws ConvertException {
        Assert.assertEquals(50, services.ConvertToFahrenheit((float) 10).getValue(),0.1);
    }

    @Test
    public void toCelsius2() throws ConvertException {
        Assert.assertEquals(10, services.ConvertToCelsius((float) 50).getValue(),0.1);
    }




    @Test
    public void concurrentQuery() {
        List<Thread> threads = new ArrayList<>();
        int numThreads = 10;
        for (int i = 0; i < numThreads; i++) {
            threads.add(new ThreadTest());
        }
        for (Thread t: threads) {
            t.start();
        }
        for(Thread t: threads){
            try {
                t.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(ParcialApplicationTests.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public class ThreadTest extends Thread {

        private final String USER_AGENT = "Mozilla/5.0";

        @Override
        public void run() {
            String queryB;
            String GET_URL = "http://localhost:"+port+"/convertion/fahrenheit/50";
            URL obj = null;
            try {
                obj = new URL(GET_URL);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("User-Agent", USER_AGENT);
                int responseCode = con.getResponseCode();
                Assert.assertEquals(201,responseCode);
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                StringBuffer response = new StringBuffer();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                Assert.assertEquals("{\"value\":122.0,\"type\":\"ToFahrenheit\"}",response.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
