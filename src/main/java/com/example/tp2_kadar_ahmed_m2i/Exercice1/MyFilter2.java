package com.example.tp2_kadar_ahmed_m2i.Exercice1;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;


@WebFilter(filterName = "MyFilter2" , value = "/my-servlet")
public class MyFilter2 implements Filter {

    private int calculAge(String dateNaissanceString) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dateNaissanceDate = df.parse(dateNaissanceString);
        Calendar dateNaissanceCalendar = Calendar.getInstance();
        dateNaissanceCalendar.setTime(dateNaissanceDate);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dateNaissanceCalendar.get(Calendar.YEAR);
        if (today.get(Calendar.MONTH) < dateNaissanceCalendar.get(Calendar.MONTH)) {
            age--;
        } else if (today.get(Calendar.MONTH) == dateNaissanceCalendar.get(Calendar.MONTH)
                && today.get(Calendar.DAY_OF_MONTH) <
                dateNaissanceCalendar.get(Calendar.DAY_OF_MONTH)) {
            age--;
        }
        return age;
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("\n####Filter 2####\n");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String date = request.getParameter("date");
        int age = -1;
        try {
            age = calculAge(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        if(age == -1) System.out.println("\nproblème de l'age !!!!");
        else {
            if(age < 20) {
                System.out.println("\nVotre age est < 20 !!!");
                request.setAttribute("Erreur","Votre age est < 20 !!!");
                request.getRequestDispatcher("Erreur.jsp").forward(request,response);
            }
            else System.out.println("\n><<<<<<<< l'age est bien");
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }



}
