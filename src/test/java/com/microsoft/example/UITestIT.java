package com.microsoft.example;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UITestIT {
  //private String baseUrl = "http://localhost:8081/myshuttledev";
  private String baseUrl=System.getProperty("webdriver.base.url");
  WebDriver driver = null;
  
  @BeforeMethod
  public void crankUpDriver() {
    driver = new PhantomJSDriver(DesiredCapabilities.phantomjs());
  }
  
  @Test
  public void getHomePage() {
    driver.get(baseUrl + "/");
    
    String title = driver.getTitle();
    assertEquals("The first page should have a title of Login",
      "MyShuttle Login", title);
  }
  
  @Test
  public void loginToTheSite() {
    driver.get(baseUrl + "/");
    
    WebElement username = driver.findElement(By.name("email"));
    WebElement password = driver.findElement(By.name("password"));
    username.sendKeys("fred");
    password.sendKeys("fredpassword");
    password.submit();
    
    String title = driver.getTitle();
    assertEquals("After login, the home page should have a title of Dashboard",
      "Dashboard", title);
  }
  
  @Test
  public void viewFares() {
    driver.get(baseUrl + "/");

    // Login
    WebElement username = driver.findElement(By.name("email"));
    WebElement password = driver.findElement(By.name("password"));
    username.sendKeys("fred");
    password.sendKeys("fredpassword");
    password.submit();
    String title = driver.getTitle();
    assertEquals("After login, the dashboard page should have a title of Dashboard",
      "Dashboard", title);
    
    // Dashboard: just go to the next link
    driver.get(baseUrl + "/home.jsp");
    title = driver.getTitle();
    //assertEquals("After the dashboard, the home page should have a title of Employee Fares",
    //  "Employee Fares - Fred", title);
    
    // Home
  }
  
  @AfterMethod
  public void shutdownTheDriver() {
    driver.quit();
    driver = null;
  }
  
}

