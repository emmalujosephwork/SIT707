package web.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.LoginService;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException, ServletException {    
        System.out.println("[LoginServlet] GET");
        
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException, ServletException {        
        System.out.println("[LoginServlet] POST");
        
        String username = req.getParameter("username");
        String password = req.getParameter("passwd");
        String dob = req.getParameter("dob");

      
        System.out.println("Username/password: " + username + ", " + password + "," + dob);

        String loginStatus = "fail";  // Default login status

        if (LoginService.login(username, password, dob)) {
            loginStatus = "success";  // Set to "success" if login is successful
        }

        // Modify the response to show the login status and set the page title to "success" if successful
        String htmlResponse = "<html>";
        htmlResponse += "<head><title>" + loginStatus + "</title></head>";
        htmlResponse += "<body><h2>Login status: " + loginStatus + "</h2></body>";
        htmlResponse += "</html>";

        PrintWriter writer = resp.getWriter();
        writer.println(htmlResponse);
    }
}
