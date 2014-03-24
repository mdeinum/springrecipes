package com.apress.springrecipes.vehicle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import java.sql.SQLException;
import java.util.Arrays;

/**
 * Created by marten on 24-03-14.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("vehicle-context.xml");

        VehicleDao vehicleDao = context.getBean("vehicleDao", VehicleDao.class);
        Vehicle vehicle = new Vehicle("EX0001", "Green", 4, 4);
        vehicleDao.insert(vehicle);

    }

}
