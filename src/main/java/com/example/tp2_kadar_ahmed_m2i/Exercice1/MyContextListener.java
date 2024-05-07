package com.example.tp2_kadar_ahmed_m2i.Exercice1;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@WebListener
public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        File file = new File("app_startup.txt");

        try {
            FileWriter fw = new FileWriter(file,true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("L'application démarré à : "+timestamp);
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        File file = new File("app_startup.txt");

        try {
            FileWriter fw = new FileWriter(file,true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("L'application arreter à : "+timestamp);
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
