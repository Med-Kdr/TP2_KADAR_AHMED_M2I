package com.example.tp2_kadar_ahmed_m2i.Exercice1;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebListener
public class MyRequestCounterListener implements ServletRequestListener {

    private static int total = 0;

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        HttpSession session = request.getSession();
        total++;
        session.setAttribute("total",total);

        request.setAttribute("total",total);



    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }
}
