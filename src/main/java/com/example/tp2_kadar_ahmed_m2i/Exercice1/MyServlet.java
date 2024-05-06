package com.example.tp2_kadar_ahmed_m2i.Exercice1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyServlet" , urlPatterns = "/my-servet")
public class MyServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
    }

}
