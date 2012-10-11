package org.demo;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
//import org.testng.annotations.After;

public class PriceReaderTest {


    private Properties properties;

    @BeforeClass
    public void setUp() throws IOException {
        properties = new Properties();
        properties.setProperty("81-7656-335-8", "USD 15");
        properties.setProperty("0-471-25839-3", "EUR 17");
        FileOutputStream fileOutputStream = new FileOutputStream("currency.properties");
        properties.store(fileOutputStream, "HEADER");
        fileOutputStream.close();

    }

    public void tearDown() {

    }

    @Test (expectedExceptions = IOException.class)
    public void testConstructor() throws IOException {
        PriceReader reader = new PriceReader("xxx.properties");
        Assert.fail();
    }

    @Test
    public void getCurrencyCodeTest() {
        try {
            PriceReader priceReader = new PriceReader("currency.properties");
            String currencyCode = priceReader.getCurrencyCode("81-7656-335-8");
            Assert.assertEquals(currencyCode, "USD");
        } catch (IOException e) {

        }

    }


}
