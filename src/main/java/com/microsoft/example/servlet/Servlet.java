package com.microsoft.example.servlet;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException
    {
        PrintWriter pw = response.getWriter();
        pw.println("hello, world");
        String conStr = System.getenv("MYSQLCONNSTR_MyShuttleDb");
        pw.println("MYSQLCONNSTR_MyShuttleDb:");
        pw.println(conStr);
        
        String jHome = System.getenv("JAVA_HOME");
        pw.println("JAVA_HOME:");
        pw.println(jHome);
        pw.close();
    }
}