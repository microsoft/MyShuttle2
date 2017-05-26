package com.microsoft.example.servlet;

import com.microsoft.example.DataAccess;
import com.microsoft.example.models.Employee;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet
{
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException
    {
        PrintWriter pw = response.getWriter();
        pw.println("hello, world");
        String conStr = System.getenv("MYSQLCONNSTR_MyShuttleDb");
        pw.println("MYSQLCONNSTR_MyShuttleDb:");
        pw.println(conStr);

        String username = System.getenv("DbUsername");
        pw.println("DbUsername:");
        pw.println(username);

        try {
            pw.println("getting fred");

            Employee employee = DataAccess.login("fred", "fredpassword");
            pw.println("Got fred");
        } catch (Exception e) {
            pw.println("Exception " + e.toString());
        }

        pw.close();
    }
}