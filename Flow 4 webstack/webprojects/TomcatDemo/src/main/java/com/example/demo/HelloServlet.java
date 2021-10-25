package com.example.demo;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String firstName =request.getParameter("fname");
        String lastName = request.getParameter("lname");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>" + "Du ramte min get" + "</h2>");
        out.println("Firstname is: " + firstName + " and lastname: " +lastName);
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName =request.getParameter("fname");
        String lastName = request.getParameter("lname");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>" + "Du ramte min post" + "</h2>");
        out.println("Firstname is: " + firstName + " and lastname: " +lastName);
        out.println("</body></html>");
    }

    public void destroy() {
    }
}