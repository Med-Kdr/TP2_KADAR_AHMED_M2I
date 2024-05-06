package com.example.tp2_kadar_ahmed_m2i.Exercice2;

import com.example.tp2_kadar_ahmed_m2i.Connexion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "AddEmployeeServlet" , urlPatterns = "/add-employee")
public class AddEmployeeServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
        response.setContentType("text/html");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String conact = request.getParameter("conact");

        PrintWriter out = response.getWriter();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = Connexion.getConnexion();
            String sql = "INSERT INTO employee(firstName,lastName,userName,password,address,contact) VALUES (?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,firstName);
            ps.setString(2,lastName);
            ps.setString(3,userName);
            ps.setString(4,password);
            ps.setString(5,address);
            ps.setString(6,conact);
            int test = ps.executeUpdate();
            out.println("<html><body>");
            if(test != 0) out.println("<h1>L'insertion a été fait avec succée </h1>");
            else out.println("<h1>Il y a un problème à l'insertion </h1>");

            out.println("</body></html>");



        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        System.out.println("\n\n#################BIiiibia###################");
    }

}
