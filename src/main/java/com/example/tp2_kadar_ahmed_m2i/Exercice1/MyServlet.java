package com.example.tp2_kadar_ahmed_m2i.Exercice1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "MyServlet" , urlPatterns = "/my-servlet")
public class MyServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String date = request.getParameter("date");
        String cne = request.getParameter("cne");

        Etudiant etudiant = new Etudiant(id,nom,prenom,date,cne);

        HttpSession session = request.getSession();
        Map<Integer,Etudiant> map;

        if(session.getAttribute("Etudiants") == null) {
            map = new HashMap<>();
        }
        else  map = (Map<Integer, Etudiant>) session.getAttribute("Etudiants");
        map.put(id,etudiant);

        session.setAttribute("Etudiants",map);


//        for (Map.Entry<Integer,Etudiant> entry : map.entrySet()) {
//            Integer key = entry.getKey();
//            Etudiant value = entry.getValue();
//            System.out.println("\n##########################################");
//            System.out.println("Clé: " + key + ", Valeur: " + value.getId() + " "+value.getNom()+ " "+value.getPrenom()+ " "+value.getDate()+ " "+value.getCne());
//        }

        System.out.println(request.getAttribute("total"));
        request.getRequestDispatcher("Exercice1/Form.jsp").forward(request,response); // Form.jsp est la classe principale de l'exercice 1



    }

}
