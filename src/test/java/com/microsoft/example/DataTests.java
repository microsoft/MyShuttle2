package com.microsoft.example;

import java.util.List;
import java.sql.*;
import javax.sql.*;
import static org.junit.Assert.*;
import org.junit.Test;
import com.microsoft.example.models.*;

public class DataTests {
    @Test
    public void seeIfFredCanLogin() {
        assertEquals(true, DataAccess.loginSuccessful("fred", "fredpassword"));
    }
    
    @Test
    public void fetchFredByLogin() {
        Employee actual = DataAccess.login("fred", "fredpassword");
        
        Employee expected = new Employee(1, "fred", "fredpassword");
        assertEquals(expected.getID(), actual.getID());
    }
    
    @Test
    public void viewFredFares() {
        List<Fare> fares = DataAccess.employeeFares(1); // Fred == employee 1
        
        if (fares.size() < 1) {
            fail("Fred should have some fares!");
        }
        else {
            Fare f = fares.get(0);
            assertEquals(1, f.getEmployeeID());
        }
    }
}