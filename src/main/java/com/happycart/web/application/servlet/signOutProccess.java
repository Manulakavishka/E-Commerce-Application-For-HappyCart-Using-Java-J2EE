package com.happycart.web.application.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "signOutProccess", value = "/signOutProccess")
public class signOutProccess extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get the current session
        HttpSession session = request.getSession(false); // Pass 'false' to prevent creating a new session if it doesn't exist
        System.out.println("Session");
        if (session != null) {
            // Invalidate the session
            session.invalidate();
            System.out.println("Sign Out");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
