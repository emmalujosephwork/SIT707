package web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import web.handler.LoginServlet;
import web.handler.RegistrationServlet;
import web.handler.WelcomeServlet;

public class MyServer {

    public void start() throws Exception {
        Server server = new Server(8082);
        ServletContextHandler handler = new ServletContextHandler(server, "/");
        handler.addServlet(WelcomeServlet.class, "/");
        handler.addServlet(LoginServlet.class, "/login");
        handler.addServlet(RegistrationServlet.class, "/reg");
        server.start();
    }

    public static void main(String[] args) throws Exception {
        new MyServer().start();
    }
}
