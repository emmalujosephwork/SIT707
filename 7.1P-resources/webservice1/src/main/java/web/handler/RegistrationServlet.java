package web.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.RegistrationService;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {    
        System.out.println("[RegistrationServlet] GET");
        
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {        
        System.out.println("[RegistrationServlet] POST");
        
        String fName = req.getParameter("fname");
        String lName = req.getParameter("lname");
        String email = req.getParameter("email");
        String dob = req.getParameter("dob");
        
        // Call registration business logic
        boolean registered = RegistrationService.register(fName, lName, email, dob);
        
        // Writes a status response based on the result of registration
        resp.setContentType("application/json");
        if (registered) {
            resp.getWriter().println("{\"status\": \"ok\"}");
        } else {
            resp.getWriter().println("{\"status\": \"error\", \"message\": \"Email already registered\"}");
        }
    

    }
}
