package com.example.tp2_kadar_ahmed_m2i.Exercice1;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;

@WebFilter(filterName = "MyFilter1" , value = "/my-servlet")
public class MyFilter1 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("\n####Filter 1####\n");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String cne = request.getParameter("cne");
        System.out.println("\n><<<>< "+cne);

        HttpSession session = request.getSession();
        if(session.getAttribute("Etudiants") != null) {
            Map<Integer,Etudiant> map = (Map<Integer, Etudiant>) session.getAttribute("Etudiants");
            for (Map.Entry<Integer,Etudiant> entry : map.entrySet()) {
                Integer key = entry.getKey();
                Etudiant value = entry.getValue();
                if(value.getCne().equals(cne)) {
                    System.out.println("\n#### Vers la page d'erreur .");
                    request.setAttribute("Erreur","cette cne : "+cne+" est déjà existe !!!");
                    request.getRequestDispatcher("Erreur.jsp").forward(request,response);
                }
            }
        }
        else {
            System.out.println("\n####============== La session est vide .");
        }
        filterChain.doFilter(servletRequest,servletResponse);


    }
}
