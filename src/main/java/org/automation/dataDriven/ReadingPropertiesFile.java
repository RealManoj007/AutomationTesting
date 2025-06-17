package org.automation.dataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesFile {
    public static void main(String[] args) throws IOException {

        //location of properties file
        FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\config.properties");

        //Loading properties file
        Properties propertiesobj=new Properties();
        propertiesobj.load(file);

        //Reading data from properties file
        String url=propertiesobj.getProperty("appur1");
        String email=propertiesobj.getProperty("email");
        String pwd=propertiesobj.getProperty("password");
        String orid=propertiesobj.getProperty("orderid");
        String custid=propertiesobj.getProperty("customerid");

        System.out.println(url+" : "+email+" : "+pwd+" : "+orid+" : "+custid);

        //using set<String> to get all keys
        Set<String> keys = propertiesobj.stringPropertyNames();
        System.out.println(keys);

        Set<Object> keyz = propertiesobj.keySet(); //alternative way to get keys
        System.out.println(keyz);

        //Iterating through values
        Set<Object> values = Collections.singleton(propertiesobj.values());
        for (Object value : values) {
            System.out.println(value);
        }

    }
}
