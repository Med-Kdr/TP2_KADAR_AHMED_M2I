package com.example.tp2_kadar_ahmed_m2i.Exercice2;

import com.example.tp2_kadar_ahmed_m2i.Connexion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "DisplayEmployeeServlet" , urlPatterns = "/display-employee")
public class DisplayEmployeeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>L'affichage : </h1>");



        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = Connexion.getConnexion();
            ps = conn.prepareStatement("SELECT * FROM employee ORDER BY id");
            rs = ps.executeQuery();

            out.println("<table width=\"40%\" border=\"6\" cellspacing=\"15\" cellpadding=\"8\">");
            out.println("<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>User Name</th><th>Password</th><th>Address</th><th>Contact</th></tr>");
            while(rs.next()) {
                out.println("<tr>");
                    out.println("<td>"+ rs.getInt(1) +"</td>");
                    out.println("<td>"+ rs.getString(2) +"</td>");
                    out.println("<td>"+ rs.getString(3) +"</td>");
                    out.println("<td>"+ rs.getString(4) +"</td>");
                    out.println("<td>"+ rs.getString(5) +"</td>");
                    out.println("<td>"+ rs.getString(6) +"</td>");
                    out.println("<td>"+ rs.getString(7) +"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        }catch(Exception e) {
            e.printStackTrace();
        }

        out.println("</body></html>");

    }


}
